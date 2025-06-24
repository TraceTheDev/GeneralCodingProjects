import java.io.*;
import java.net.*; 
import java.text.SimpleDateFormat; 
import java.util.Date; 

public class IterativeServer {

    private static long startTime; // Variable to store the server's start time

    public static void main(String[] args) {
        startTime = System.currentTimeMillis(); // Record the start time for uptime calculation
        int port = 1234; // Define the port number the server will listen on

        // Create a ServerSocket to listen for incoming connections on the specified port
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            // Infinite loop to handle client connections one at a time (iterative server)
            while (true) {
                // Accept a client connection and set up input/output streams
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("Client connected: " + clientSocket.getInetAddress());

                    String request = in.readLine(); // Read the client's request
                    System.out.println("Received request: " + request);

                    String response = handleRequest(request); // Process the request and generate a response
                    out.println(response); // Send the response back to the client

                } catch (IOException e) {
                    System.out.println("Error handling client connection: " + e.getMessage()); // Handle client connection errors
                }
            }

        } catch (IOException e) {
            System.out.println("Could not start server on port " + port); // Handle errors when starting the server
            e.printStackTrace();
        }
    }

    // Method to process client requests based on the command sent by the client
    private static String handleRequest(String request) {
        switch (request.toLowerCase()) {
            case "date and time": // Return the current date and time
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            case "uptime": // Calculate and return the server's uptime
                long uptime = System.currentTimeMillis() - startTime;
                return formatDuration(uptime);
            case "memory use": // Calculate and return current memory usage
                Runtime runtime = Runtime.getRuntime();
                long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
                return "Memory used: " + memoryUsed / (1024 * 1024) + " MB";
            case "netstat": // Execute the netstat command and return its output
                return executeCommand("netstat");
            case "current users": // Execute the "who" command to list current users
                return executeCommand("who");
            case "running processes": // Execute the "ps -e" command to list running processes
                return executeCommand("ps -e");
            default: // Handle unknown requests
                return "Unknown request";
        }
    }

    // Helper method to format uptime duration into hours, minutes, and seconds
    private static String formatDuration(long millis) {
        long seconds = millis / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        seconds %= 60;
        minutes %= 60;
        return hours + " hours, " + minutes + " minutes, " + seconds + " seconds";
    }

    // Helper method to execute system commands and return the output as a String
    private static String executeCommand(String command) {
        StringBuilder output = new StringBuilder(); // StringBuilder to capture the command output
        
        try {
            Process process = Runtime.getRuntime().exec(command); // Execute the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream())); // Read command output
            String line;
            while ((line = reader.readLine()) != null) { // Append each line of output
                output.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            output.append("Error executing command: ").append(command); // Handle errors in command execution
        }
        return output.toString(); // Return the command output or error message
    }
}
