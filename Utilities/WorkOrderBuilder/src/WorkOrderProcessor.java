import java.util.ArrayList;
import java.util.Queue;

/**
 * The WorkOrderProcessor class serves as the main controller for the application.
 * It loads employees and tickets, assigns tickets to employees as work orders,
 * and writes the resulting data to a CSV file.
 */
public class WorkOrderProcessor {
	public static String employeeFileName;            // Filename for employee data
	public static String tier1TicketFileName;         // Filename for tier 1 tickets
	public static String tier2TicketFileName;         // Filename for tier 2 tickets
	public static String workOrderFileName;           // Output file for work orders
	public static ArrayList<Employee> employeeList;   // List of available employees
	public static Queue<Ticket> tier1TicketFile;      // Queue of Tier 1 tickets
	public static Queue<Ticket> tier2TicketFile;      // Queue of Tier 2 tickets
	public static ArrayList<WorkOrder> workOrderList; // Resulting list of work orders

	/**
	 * Main method that orchestrates the process:
	 * - Loads input files
	 * - Reads and queues tickets
	 * - Assigns tickets to employees
	 * - Outputs processed work orders to a CSV
	 */
	public static void main(String[] args) {
		System.out.println("Project 3 Work Order Generator");
		System.out.println();

		// Define the input ticket files (CSV)
		tier1TicketFileName = "tier1_ticket_data.csv";
		tier2TicketFileName = "tier2_ticket_data.csv";

		System.out.println("Loading Employee Data");
		employeeList = new ArrayList<>();
		FileHandler.readEmployeeData(employeeFileName); // Populates employeeList

		System.out.println("Loading Ticket Data");

		// Use a common base time for consistent staggering
		long baseTime = System.currentTimeMillis();

		// Shared counter ensures ticket IDs and timestamps are unique across both files
		int ticketCounter = 1;

		// Read tier 1 tickets starting from counter = 1
		tier1TicketFile = FileHandler.readTicketData(tier1TicketFileName, baseTime, ticketCounter);

		// Update counter based on how many tier 1 tickets were loaded
		ticketCounter += tier1TicketFile.size();

		// Read tier 2 tickets starting from the new counter value
		tier2TicketFile = FileHandler.readTicketData(tier2TicketFileName, baseTime, ticketCounter);

		System.out.println("Creating Work Orders");
		createWorkOrders();  // Assign tickets to employees

		System.out.println("Writing Work Order Data to File");
		FileHandler.writeData(workOrderFileName);  // Output result to workOrder_data.csv

		System.out.println("Work Orders Created. Program Exiting.");
	}

	/**
	 * Iterates through both ticket queues (Tier 1 and Tier 2)
	 * and assigns tickets to employees in a round-robin fashion.
	 * Tier 2 employees are prioritized for Tier 2 tickets.
	 * The result is stored in workOrderList for export.
	 */
	public static void createWorkOrders() {
		workOrderList = new ArrayList<>();
		int totalQueueSize = tier1TicketFile.size() + tier2TicketFile.size(); // total tickets to process
		int i = 0;   // counts total tickets assigned
		int j = 0;   // index into employee list (round-robin)

		while (i < totalQueueSize) {
			// If employee is Tier 2 and Tier 2 tickets exist, assign one
			if (employeeList.get(j) instanceof Tier2Employee && !tier2TicketFile.isEmpty()) {
				Ticket ticket = tier2TicketFile.remove();
				workOrderList.add(new WorkOrder(employeeList.get(j), ticket, ticket.getCreatedAt()));

			// Otherwise, assign a Tier 1 ticket to a Tier 1 employee if available
			} else if (employeeList.get(j) instanceof Employee && !tier1TicketFile.isEmpty()) {
				Ticket ticket = tier1TicketFile.remove();
				workOrderList.add(new WorkOrder(employeeList.get(j), ticket, ticket.getCreatedAt()));
			}

			i++;                // increment tickets assigned
			j = (j + 1) % employeeList.size();  // loop over employee list in round-robin
		}
	}
}