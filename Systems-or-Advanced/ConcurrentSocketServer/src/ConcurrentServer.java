import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConcurrentServer {
    private static long startTime; // Start time to calculate server uptime

    public static void main(String[] args) {
        startTime = System.currentTimeMillis(); // Record the server's start time
        int port = 1234; // Port number to listen on

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Concurrent Server started on port " + port);

            // Infinite loop to accept client connections
            while (true) {
                Socket clientSocket = serverSocket.accept(); // Accept a new client connection
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                // Spawn a new thread to handle the client request
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.out.println("Error starting server on port " + port);
            e.printStackTrace();
        }
    }

    // ClientHandler class to handle each client's request in a separate thread
    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket; // Assign the client socket
        }

        @Override
        public void run() {
            try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                String request = in.readLine(); // Read the client's request
                System.out.println("Received request: " + request);

                // Process the request and generate a response
                String response = handleRequest(request);

                // Send the response back to the client
                out.println(response);
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close(); // Close the client connection
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Method to process client requests
        private String handleRequest(String request) {
            switch (request.toLowerCase()) {
                case "date and time":
                    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                case "uptime":
                    long uptime = System.currentTimeMillis() - startTime;
                    return formatDuration(uptime);
                case "memory use":
                    Runtime runtime = Runtime.getRuntime();
                    long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
                    return "Memory used: " + memoryUsed / (1024 * 1024) + " MB";
                case "netstat":
                    return executeCommand("netstat");
                case "current users":
                    return executeCommand("who");
                case "running processes":
                    return executeCommand("ps -e");
                default:
                    return "Unknown request";
            }
        }

        // Helper method to format duration into hours, minutes, and seconds
        private String formatDuration(long millis) {
            long seconds = millis / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            seconds %= 60;
            minutes %= 60;
            return hours + " hours, " + minutes + " minutes, " + seconds + " seconds";
        }

        // Helper method to execute system commands and return the output
        private String executeCommand(String command) {
            StringBuilder output = new StringBuilder();
            try {
                Process process = Runtime.getRuntime().exec(command);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
                reader.close();
            } catch (IOException e) {
                output.append("Error executing command: ").append(command);
            }
            return output.toString();
        }
    }
}