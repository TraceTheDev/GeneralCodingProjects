/**
 * Represents a basic employee who may be assigned to work orders.
 * Inherits general personal info from Person and adds employee-specific data.
 */
public class Employee extends Person implements Printable {
	private String employeeId;  
	private String clockedIn;  
	private String hiredDate; 

	// Constructs an employee with all required details
	public Employee(String firstName, String lastName, String address, String phoneNumber, String email, String employeeId, String clockedIn, String hiredDate) {
		super(firstName, lastName, address, phoneNumber, email);
		setEmployeeId(employeeId);
		setClockedIn(clockedIn);
		setHiredDate(hiredDate);
	}

	// Returns a string formatted for CSV output
	public String getFileData() {
		return employeeId + "," + super.getFirstName() + "," + super.getLastName() + "," + clockedIn + "," + hiredDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getClockedIn() {
		return clockedIn;
	}

	public void setClockedIn(String clockedIn) {
		this.clockedIn = clockedIn;
	}

	public String getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(String hiredDate) {
		this.hiredDate = hiredDate;
	}
}