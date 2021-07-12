package services;


import java.sql.SQLException;

import models.User;

public interface UserServices {

	// Declaration
	public boolean register(int userId, String firstName, String lastName, String userName, String email, String pass, String jobPosition, String passConfirm);
	public User login(String userName, String pass, String jobPosition);
	public boolean updateUserInfo(User u) throws SQLException;
	public int generateUserId();
	public User selectUser(int userId);
	public void forgotPassword(String userName);
}
