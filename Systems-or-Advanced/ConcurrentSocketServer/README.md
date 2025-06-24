# ConcurrentSocketServer

A simple Java-based multithreaded client-server application that demonstrates socket programming, concurrent request handling, and response time tracking. This project simulates a basic remote command service with support for multiple simultaneous client requests and performance measurement.

---

## Project Structure

```
ConcurrentSocketServer/
├── src/
│   ├── ConcurrentServer.java         # Handles incoming client connections and request processing
│   └── MultiThreadedClient.java      # Spawns multiple threads to issue requests and track turnaround times
└──
```

---

## Core Java Classes

### `ConcurrentServer.java`
Implements a multithreaded server that:
- Listens for client connections on port `1234`
- Spawns a new thread to handle each request
- Supports operations including:
  - `date and time`
  - `uptime`
  - `memory use`
  - `netstat`
  - `current users`
  - `running processes`

### `MultiThreadedClient.java`
Implements a client application that:
- Prompts the user for a server address, port, and operation
- Launches 1–25 concurrent threads to issue requests to the server
- Tracks and displays total and average turnaround time for all requests

---

## How to Run

1. Compile both Java files:
```bash
javac src/ConcurrentServer.java
javac src/MultiThreadedClient.java
```

2. Run the server in one terminal or IDE:
```bash
java -cp src ConcurrentServer
```

3. Run the client in another terminal or IDE:
```bash
java -cp src MultiThreadedClient
```

4. Follow on-screen prompts to enter server IP, port, command, and number of client threads.

---

## Future Enhancements
- Add authentication for client-server communication
- Support command-line arguments for headless execution
- Implement file-based logging of requests and statistics
- Provide a GUI for easier client interaction

---

## License
This project is licensed for personal, non-commercial use only. Redistribution, resale, or modification is prohibited without written permission from the author.  
See the [LICENSE] file for full details.

---

## Author  
**Trace Davis**  
- GitHub: [Trace0727](https://github.com/Trace0727)  
- LinkedIn: [Trace Davis](https://www.linkedin.com/in/trace-d-926380138/)
