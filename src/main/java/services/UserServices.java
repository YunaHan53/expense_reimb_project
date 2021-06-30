package services;

public interface UserServices {

	// Declaration
	public void login(String username, String password);
	public void forgotPassword(String username);
	public void logout();
}
