package models;

public class Manager {

	// Declaring manager variables
	private int manNo;
	private String manName;

	
	// Custom constructor
	public Manager(int manNo, String manName, double salary) {
		this.manNo = manNo;
		this.manName = manName;
	}


	// Getter/Setter for Employee ID
	public int getManNo() {
		return manNo;
	}
	public void setEmpNo(int empNo) {
		this.manNo = empNo;
	}
	
	
	// Getter/Setter for Employee Name
	public String getManName() {
		return manName;
	}
	public void setManName(String manName) {
		this.manName = manName;
	}
	
	
	@Override
	public String toString() {
		return "Manager ID: " + manNo + 
				", Name: " + manName + 
				"\n";
	}
	
}
