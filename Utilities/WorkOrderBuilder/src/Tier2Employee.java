/**
 * Represents a Tier 2 employee with additional certification.
 * Inherits all base employee data and adds a certification field.
 */
public class Tier2Employee extends Employee implements Printable {
	private String certification;  // Specialized qualification for Tier 2 employees

	// Constructs a Tier2Employee with all base and certification fields
	public Tier2Employee(String firstName, String lastName, String address, String phoneNumber, String email, String employeeId, String clockedIn, String hiredDate, String certification) {
		super(firstName, lastName, address, phoneNumber, email, employeeId, clockedIn, hiredDate);
		setCertification(certification);
	}

	// Returns Tier 2 employee details formatted for CSV output
	public String getFileData() {
		return super.getEmployeeId() + "," + super.getFirstName() + "," + super.getLastName() + "," +
		       super.getClockedIn() + "," + super.getHiredDate() + "," + certification;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}
}