package services;

import models.User;

public interface UserServices {

	// Declaration
	public User login(String userName, String pass);
	
//	public void updateDatabase(ArrayList<String> information);

	public void forgotPassword(String userName);
	public void logout();
}
