package services;

import models.User;

public interface UserServices {

	// Declaration
	public boolean register(int userId, String firstName, String lastName, String userName, String email, String pass, String jobPosition, String passConfirm);
	public User login(String userName, String pass);
	
//	public void updateDatabase(ArrayList<String> information);
	public int generateUserId();
	public void forgotPassword(String userName);
	public void logout();
}
