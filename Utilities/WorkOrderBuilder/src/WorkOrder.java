import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The WorkOrder class models the assignment of a ticket to an employee,
 * along with the timestamp when that assignment (work order) is created.
 * This serves as the operational link between customer-reported issues
 * and internal employee actions.
 */
public class WorkOrder {
	private Employee employee;       // The employee assigned to handle the ticket
	private Ticket ticket;           // The ticket containing customer issue info
	private String createdAt;        // The time the work order was issued (derived from ticket time)

	/**
	 * Constructs a WorkOrder by binding an employee to a ticket.
	 * It also computes the work order creation time as a function of the ticket's time.
	 *
	 * @param employee The employee assigned to the ticket
	 * @param ticket The ticket submitted by a customer
	 * @param ticketCreatedAt The timestamp when the ticket was created
	 */
	public WorkOrder(Employee employee, Ticket ticket, String ticketCreatedAt) {
		setEmployee(employee);              // store assigned employee
		setTicket(ticket);                  // store ticket details
		setCreatedAt(ticketCreatedAt);      // calculate work order creation time
	}

	// Standard getter/setter methods
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * Calculates the creation time of the work order by adding 20 minutes to the ticket's time.
	 * This models a realistic delay between the time a ticket is submitted and when an employee begins work.
	 *
	 * If the ticket's timestamp is malformed, the current system time is used as fallback.
	 *
	 * @param ticketCreatedAt The original creation timestamp of the ticket
	 */
	public void setCreatedAt(String ticketCreatedAt) {
	    try {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date ticketTime = sdf.parse(ticketCreatedAt);

	        // Add 20 minutes (20 * 60 * 1000 ms) to simulate processing delay
	        Date workOrderTime = new Date(ticketTime.getTime() + 1_200_000L);
	        this.createdAt = sdf.format(workOrderTime);
	    } catch (Exception e) {
	        // Fallback: use current system time if parsing fails
	        this.createdAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	    }
	}

	/**
	 * Returns a string representing all the relevant data for this work order in CSV format.
	 * The output includes both customer info (from the ticket), ticket info, and employee assignment.
	 * If the employee is Tier 2, certification is also included.
	 *
	 * @return A comma-separated string suitable for writing to a CSV file.
	 */
	public String getFileData() {
	    Customer customer = ticket.getCustomer();

	    // Extract and clean customer fields
	    String customerId = escape(customer.getCustomerId());
	    String customerFirstName = escape(customer.getFirstName());
	    String customerLastName = escape(customer.getLastName());

	    // Ticket metadata
	    String ticketId = escape(ticket.getTicketId());
	    String ticketCreatedAt = escape(ticket.getCreatedAt());
	    String workOrderCreatedAt = escape(createdAt);  // this.createdAt is 20 mins after ticket

	    // Employee metadata
	    String employeeId = escape(employee.getEmployeeId());
	    String empFirstName = escape(employee.getFirstName());
	    String empLastName = escape(employee.getLastName());
	    String clockedIn = escape(employee.getClockedIn());

	    // Tier 2 employees may include a certification field
	    String certification = "";
	    if (employee instanceof Tier2Employee) {
	        certification = escape(((Tier2Employee) employee).getCertification());
	    }

	    // Compose CSV row
	    return String.join(",", customerId, customerFirstName, customerLastName,
	                       ticketId, ticketCreatedAt, workOrderCreatedAt,
	                       employeeId, empFirstName, empLastName, clockedIn, certification);
	}

	/**
	 * Helper method to sanitize strings before writing to CSV.
	 * This prevents double-quotes from corrupting the CSV format.
	 *
	 * @param value The raw string
	 * @return The cleaned string with quotes removed
	 */
	private String escape(String value) {
	    if (value == null) return "";
	    return value.replace("\"", "");
	}
}