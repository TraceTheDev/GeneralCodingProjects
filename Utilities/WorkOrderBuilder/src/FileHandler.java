import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * FileHandler is responsible for:
 * - Reading employees and tickets from CSV files
 * - Assigning unique ticket IDs and staggered timestamps
 * - Writing work orders to a CSV
 * - Logging progress throughout the process
 */
public class FileHandler {

	/**
	 * Writes the finalized work orders to a CSV file.
	 * This method also logs each entry for auditing/debugging.
	 */
	public static void writeData(String workOrderFileName) {
		workOrderFileName = "workOrder_data.csv";  // Always write to a consistent filename

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(workOrderFileName))) {
			logger("Writing Work Order Data to File");

			// Header for CSV columns
			bw.write("customer_id,customer_first_name,customer_last_name,ticket_id,ticket_createdAt,workorder_createdAt,employee_id,employee_first_name,employee_last_name,clocked_in,certification\n");

			// Write each work order's data as a new line in the file
			for (WorkOrder workOrder : WorkOrderProcessor.workOrderList) {
				String line = workOrder.getFileData();
				bw.write(line + "\n");
				logger(line); // Log each row to keep track of what was written
			}

			logger("Work Orders Created. Program Exiting");
		} catch (Exception e) {
			System.out.println("Cannot write to File");
		}
	}

	/**
	 * Reads employees from a CSV file and adds them to the shared employee list.
	 * Differentiates between Tier 1 and Tier 2 employees and creates the correct object type.
	 */
	public static void readEmployeeData(String employeeFileName) {
		employeeFileName = "employee_data.csv"; // Hardcoded here for consistent processing

		try (BufferedReader br = new BufferedReader(new FileReader(employeeFileName))) {
			String line = br.readLine(); // Skip header line

			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");

				// Extract fields for both Employee and Tier2Employee
				String employeeID = values[0];
				String firstName = values[1];
				String lastName = values[2];
				String email = values[3];
				String address = values[4];
				String phoneNumber = values[5];
				String clockedIn = values[6];
				String hiredDate = values[7];
				String tier = values[8];
				String certification = values[9];

				// Use the tier field to determine which subclass to create
				Employee employee;
				if (tier.equalsIgnoreCase("tier1")) {
					employee = new Employee(firstName, lastName, address, phoneNumber, email, employeeID, clockedIn, hiredDate);
				} else {
					employee = new Tier2Employee(firstName, lastName, address, phoneNumber, email, employeeID, clockedIn, hiredDate, certification);
				}

				// Add employee to the global list for later assignment
				WorkOrderProcessor.employeeList.add(employee);
			}

			logger("Loading Employee Data");
		} catch (IOException e) {
			System.out.println("File cannot be found");
		}
	}

	/**
	 * Reads tickets from the given CSV and generates Ticket objects with unique IDs and creation times.
	 * Uses a shared base timestamp and starting index to keep ticket times and IDs consistent across files.
	 */
	public static Queue<Ticket> readTicketData(String filename, long baseTime, int startingIndex) {
	    Queue<Ticket> tickets = new LinkedList<>();
	    int lineNumber = startingIndex; // Ensures ticket numbering continues across files

	    try (Scanner fileScanner = new Scanner(new File(filename))) {
	        if (fileScanner.hasNextLine()) fileScanner.nextLine(); // Skip header

	        while (fileScanner.hasNextLine()) {
	            String[] fields = fileScanner.nextLine().split(",");
	            if (fields.length < 7) continue; // Skip malformed or incomplete rows

	            // Create Customer from CSV fields
	            Customer customer = new Customer(
	                fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]
	            );

	            // Generate a formatted ticket ID like T001, T002, ...
	            String ticketId = String.format("T%03d", lineNumber);

	            // Stagger ticket times: 20 minutes apart per ticket
	            long offset = lineNumber * 20 * 60 * 1000L;
	            String createdAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
	                .format(new Date(baseTime + offset));

	            // Add the completed ticket to the queue
	            tickets.add(new Ticket(customer, createdAt, ticketId));
	            lineNumber++; // Increment for the next ticket
	        }
	    } catch (Exception e) {
	        System.out.println("Error reading ticket data: " + e.getMessage());
	    }

	    return tickets;
	}

	/**
	 * Appends timestamped log messages to a local text file ("logger.txt").
	 * Useful for tracking application progress and debugging.
	 */
	static void logger(String log) {
		Format f = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String str = f.format(new Date());

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("logger.txt", true))) {
			bw.append("Log: " + str + " : " + log + "\n");
		} catch (Exception e) {
			System.out.println("Cannot write to File");
		}
	}
}