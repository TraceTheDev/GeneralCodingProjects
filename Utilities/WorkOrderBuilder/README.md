# WorkOrderSystem

A Java-based backend ticketing system that simulates employee work order assignment. The program reads employees and customer tickets from CSV files, assigns tickets to employees based on tier, generates work orders, and writes the output to a final CSV. Great for understanding object-oriented design, inheritance, file I/O, and real-world workflow automation in Java.

---

## Project Structure

```
WorkOrderSystem/
├── src/
│   └── WorkOrderProcessor.java
│   └── FileHandler.java
│   └── WorkOrder.java
│   └── Ticket.java
│   └── Customer.java
│   └── Employee.java
│   └── Tier2Employee.java
│   └── Person.java
│   └── Printable.java
├── employee_data.csv
├── tier1_ticket_data.csv
├── tier2_ticket_data.csv
└── 
```

---

## Core Java Classes

### `WorkOrderProcessor.java`
Main entry point. Loads data, assigns tickets to employees in a round-robin fashion, and creates work orders.

### `FileHandler.java`
Handles all file I/O operations:
- Reading employees and tickets from CSV
- Writing generated work orders to CSV
- Logging key steps for debugging

### `WorkOrder.java`
Represents a completed assignment between a ticket and an employee. Also calculates the work order time as 20 minutes after ticket creation.

### `Ticket.java`
Encapsulates the customer ticket info, including customer details, creation time, and ticket ID.

### `Customer.java`
Extends `Person`. Adds customer-specific fields like customer ID and account number.

### `Employee.java`
Extends `Person`. Represents a general employee with ID, clocked-in status, and hire date.

### `Tier2Employee.java`
Extends `Employee`. Adds a certification field for Tier 2 classification.

### `Person.java`
Base class for shared attributes between employees and customers (e.g., name, address, contact info).

### `Printable.java`
Interface that standardizes the ability of objects to be formatted for CSV output via `getFileData()`.

---

## How to Run

### 1. Prepare Input Files
Ensure the following CSV files are in the root directory:
- `employee_data.csv`
- `tier1_ticket_data.csv`
- `tier2_ticket_data.csv`

Each should follow the structure expected by the program (see headers in source or starter CSVs).

### 2. Run the Program

#### Option A: Using an IDE
- Open the project in an IDE like IntelliJ or Eclipse.
- Set `WorkOrderProcessor.java` as the main class.
- Run the program directly.

#### Option B: Using Terminal or Bash

```bash
javac -d bin src/*.java
cd bin
java WorkOrderProcessor
```

The program will generate:
- `workOrder_data.csv` — the output work orders file
- `logger.txt` — log file of processing steps

---

## Future Enhancements
- Add GUI support for real-time ticket entry and work order display.
- Allow dynamic employee availability or shift logic.
- Add tier escalation tracking and performance metrics.
- Implement database persistence instead of flat files.

---

## License
This project is licensed for personal, educational use only. Redistribution or commercial use requires permission from the author.  
See the [LICENSE] file for full details.

---

## Author

**Trace Davis**  
- GitHub: [TraceTheDev](https://github.com/TraceTheDev)  
- LinkedIn: [Trace Davis](https://www.linkedin.com/in/trace-d-926380138/)
