package services;

import models.Manager;
import models.Request;

public interface ManagerServices {

	// Declaration
	public void viewEmployees();
	public void approveRequest(Manager m, Request r);
	public void denyRequest(Manager m, Request r);
	public void restorePassword(String userName, String email);
}
