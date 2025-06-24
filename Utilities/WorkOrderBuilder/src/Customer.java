/**
 * Represents a customer who submitted a support ticket.
 * Extends Person and adds customer ID and account number.
 */
public class Customer extends Person implements Printable {
	private String customerId;     // Unique customer identifier
	private String accountNumber;  // Account number tied to the customer

	// Constructs a customer with identity and account info
	public Customer(String firstName, String lastName, String address, String phoneNumber, String email, String customerId, String accountNumber) {
		super(firstName, lastName, address, phoneNumber, email);
		setCustomerId(customerId);
		setAccountNumber(accountNumber);
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
