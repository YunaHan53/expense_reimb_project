package models;

import java.util.List;

public class User {

	// Declaring user variables
	private int userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String pass;
	private String email;
	public List<Mail> mailbox;

	
	// Custom constructor
	public User(int userId, String firstName, String lastName, String userName, String pass, String email) {
		this.userId = userId;
		this.setFirstName(firstName);
		this.lastName = lastName;
		this.userName = userName;
		this.pass = pass;
		this.email = email;
	}



	// Getter/Setter for User ID
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	// Getter/Setter for User Name
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	// Getter/Setter for password
	public String getPassword() {
		return userName;
	}
	public void setPassword(String pass) {
		this.pass = pass;
	}
	
	// Getter/Setter for password
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Getter/Setter for firstName
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String toString() {
		return "Employee ID: " + userId + 
				", Name: " + firstName + " " + lastName +
				", Username: " + userName + 
				", Password" + pass + 
				", Email: " + email + "\n";
	}

}
