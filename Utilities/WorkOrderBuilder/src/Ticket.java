/**
 * Represents a support ticket submitted by a customer.
 * Each ticket has a customer, timestamp, and unique ticket ID.
 */
public class Ticket implements Printable {
	private Customer customer;
	private String createdAt;  
	private String ticketId;   

	// Constructs a ticket with customer, timestamp, and ID
	public Ticket(Customer customer, String createdAt, String ticketId) {
		setCustomer(customer);
		setCreatedAt(createdAt);
		setTicketId(ticketId);
	}

	// Returns a placeholder string (not used for CSV output)
	public String getFileData() {
		return customer + "," + createdAt + "," + ticketId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
}
