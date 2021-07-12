package services;

import java.util.List;

import models.Manager;
import models.Request;
import models.User;

public interface ManagerServices {

	// Declaration
	public List<User> viewAllEmployees();
	public void approveRequest(Manager m, Request r);
	public void denyRequest(Manager m, Request r);
	public void restorePassword(String userName, String email);
}
