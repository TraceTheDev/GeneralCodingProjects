import java.io.*; // Import classes for input and output
import java.net.*; // Import classes for networking (Socket, ServerSocket)
import java.util.ArrayList; // Import ArrayList for storing data
import java.util.List; // Import List interface
import java.util.Scanner; // Import Scanner for reading user input

public class MultiThreadedClient {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in); // Initialize Scanner to get user input

        // Prompt for and read the server IP address
        System.out.print("Enter server IP address: ");
        String serverAddress = scanner.nextLine();

        // Prompt for and read the server port
        System.out.print("Enter server port: ");
        int port = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left over from nextInt()

        // Prompt for and read the operation to request from the server
        System.out.print("Enter the operation to request (e.g., date and time, uptime, memory use, netstat, current users, running processes): ");
        String operation = scanner.nextLine();

        // Prompt for and read the number of client requests to generate
        System.out.print("Enter the number of client requests to generate (1, 5, 10, 15, 20, or 25): ");
        int requestCount = scanner.nextInt();

        // List to store the turnaround time for each request
        List<Long> turnAroundTimes = new ArrayList<>();

        // List to keep track of all threads created
        List<Thread> threads = new ArrayList<>();

        // Loop to create and start the specified number of client threads
        for (int i = 0; i < requestCount; i++) {
            // Each thread is responsible for one client request
            Thread thread = new Thread(() -> {
                long startTime = System.currentTimeMillis(); // Record the start time for turnaround time measurement
                try (Socket socket = new Socket(serverAddress, port); // Connect to the server
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Output stream to send data to server
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) { // Input stream to read data from server

                    out.println(operation); // Send the requested operation to the server

                    // Read and print the server's response line by line
                    String responseLine;
                    while ((responseLine = in.readLine()) != null) { // Read each line of the server's response
                        System.out.println(responseLine); // Print each line of response
                    }

                    long endTime = System.currentTimeMillis(); // Record end time after receiving response
                    long turnAroundTime = endTime - startTime; // Calculate turnaround time for the request

                    // Synchronized block to safely add turnaround time to the list (avoiding race conditions)
                    synchronized (turnAroundTimes) {
                        turnAroundTimes.add(turnAroundTime);
                    }

                } catch (IOException e) {
                    System.out.println("Error connecting to server: " + e.getMessage()); // Handle connection errors
                }
            });
            threads.add(thread); // Add the created thread to the list
            thread.start(); // Start the thread to begin the client request
        }

        // Wait for all threads to complete before proceeding
        for (Thread thread : threads) {
            try {
                thread.join(); // Waits for this thread to finish
            } catch (InterruptedException e) {
                e.printStackTrace(); // Handle interrupted exceptions
            }
        }

        // Calculate the total turnaround time by summing up all individual times
        long totalTurnAroundTime = turnAroundTimes.stream().mapToLong(Long::longValue).sum();

        // Calculate the average turnaround time
        double averageTurnAroundTime = totalTurnAroundTime / (double) requestCount;

        // Output the total and average turnaround times
        System.out.println("Total Turn-around Time: " + totalTurnAroundTime + " ms");
        System.out.println("Average Turn-around Time: " + averageTurnAroundTime + " ms");
    }
}