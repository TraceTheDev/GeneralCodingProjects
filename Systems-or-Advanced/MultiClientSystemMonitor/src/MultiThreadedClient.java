import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class MultiThreadedClient {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in); // Initialize Scanner to get user input

        // Prompt for and read the server IP address
        System.out.print("Enter server IP address (e.g., 127.0.0.1): ");
        String serverAddress = scanner.nextLine();

        // Prompt for and read the server port
        System.out.print("Enter server port (e.g., 1234): ");
        int port = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left over from nextInt()

        // Prompt for and read the operation to request from the server
        System.out.println("Enter the operation to request (e.g., date and time, uptime, memory use, netstat, current users, running processes): ");
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
            Thread thread = new Thread(() -> {
                long startTime = System.currentTimeMillis();
                try (Socket socket = new Socket(serverAddress, port);
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                    out.println(operation);

                    String responseLine;
                    while ((responseLine = in.readLine()) != null) {
                        System.out.println("Server response:");
                        System.out.println(responseLine);
                    }

                    long endTime = System.currentTimeMillis();
                    long turnAroundTime = endTime - startTime;

                    synchronized (turnAroundTimes) {
                        turnAroundTimes.add(turnAroundTime);
                    }

                } catch (IOException e) {
                    System.out.println("Error connecting to server: " + e.getMessage());
                }
            });
            threads.add(thread);
            thread.start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Calculate total and average turnaround times
        long totalTurnAroundTime = turnAroundTimes.stream().mapToLong(Long::longValue).sum();
        double averageTurnAroundTime = totalTurnAroundTime / (double) requestCount;

        System.out.println("Total Turn-around Time: " + totalTurnAroundTime + " ms");
        System.out.println("Average Turn-around Time: " + averageTurnAroundTime + " ms");
    }
}
