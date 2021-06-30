package models;

import java.util.List;

public class User {

	// Declaring user variables
	private int userNo;
	private String userName;
	private String password;
	private String email;
	public List<Mail> mailbox;

	
	// Custom constructor
	public User(int userNo, String userName, String password, String email) {
		this.userNo = userNo;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}



	// Getter/Setter for User ID
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
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
	public void setPassword(String password) {
		this.password = password;
	}
	
	// Getter/Setter for password
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "Employee ID: " + userNo + 
				", Name: " + userName + 
				", Password" + password + 
				", Email: " + email + "\n";
	}
}
