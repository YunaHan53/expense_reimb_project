package services;

import models.User;

public interface UserServices {

	// Declaration
	public User register(String firstName, String lastName, String userName, String email, String pass, String jobPosition);
	public User login(String userName, String pass);
	
//	public void updateDatabase(ArrayList<String> information);

	public void forgotPassword(String userName);
	public void logout();
}
