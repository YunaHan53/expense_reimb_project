package services;

import models.Employee;

public interface EmployeeServices {

	// Declaration
	public void changeName(Employee e);
	public void changeRequest(Employee e);
	public void createRequest(Employee e);
	public void deleteRequest(Employee e);
}
