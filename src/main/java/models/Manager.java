package models;

import java.util.List;

public class Manager extends User{

	// Declaring manager variables
	private int userId;
	private List<Employee> managedEmployees;
	
	// Custom constructor
	public Manager(int userId, String manName) {
		this.userId = userId;
	}


	// Getter/Setter for Employee ID
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	// Getter/Setter for Employee Name
	public List<Employee> getManagedEmployee() {
		return managedEmployees;
	}
	public void setManagedEmployees(List<Employee> managedEmployees) {
		this.managedEmployees = managedEmployees;
	}
	
	
	@Override
	public String toString() {
		return "Manager ID: " + userId + 
				", Managed Employees:  " + managedEmployees   + 
				"\n";
	}
	
}
