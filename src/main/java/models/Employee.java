package models;

import java.util.List;

public class Employee extends User{

	// Declaring employee variables
	private int empNo;
	private String empName;
	private String jobTitle;
	private double salary;
	public List<Request> requests;

	
	// Custom constructor
	public Employee(int empNo, String empName, String jobTitle, double salary) {
		// TODO Auto-generated constructor stub
		this.empNo = empNo;
		this.empName = empName;
		this.jobTitle = jobTitle;
		this.salary = salary;
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
	
	// Getter/Setter for Job Title
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	// Getter/Setter for Salary
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	@Override
	public String toString() {
		return "Employee ID: " + empNo + 
				", Name: " + empName + 
				"\n";
	}
	
}

