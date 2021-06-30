package models;

public class Employee {

	// Declaring employee variables
	private int empNo;
	private String empName;

	
	// Custom constructor
	public Employee(int empNo, String empName) {
		// TODO Auto-generated constructor stub
		this.empNo = empNo;
		this.empName = empName;
	}

	public Employee() {
		
	}


	// Getter/Setter for Employee ID
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	
	
	// Getter/Setter for Employee Name
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	
	@Override
	public String toString() {
		return "Employee ID: " + empNo + 
				", Name: " + empName + 
				"\n";
	}
	
}

