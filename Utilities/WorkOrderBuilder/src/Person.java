/**
 * Base class for anyone in the system (e.g., employees, customers).
 * Stores shared personal information like name, address, and contact.
 */
public class Person implements Printable {
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;

	// Initializes all personal attributes
	public Person(String firstName, String lastName, String address, String phoneNumber, String email)  {
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setPhoneNumber(phoneNumber);
		setEmail(email);
	}

	// Returns personal info as a CSV-formatted string
	public String getFileData() {
		return firstName + "," + lastName + "," + address + "," + phoneNumber + "," + email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}