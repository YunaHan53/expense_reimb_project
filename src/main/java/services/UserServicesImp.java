package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import con.ConnectionUtil;
import models.User;

public class UserServicesImp implements UserServices {

	// IMPLEMENTATION //
	
	// Login (String userName, String pass)
//	public User login(String userName, String pass) {
//		String QUERY = "select * from emp where USERNAME=? and PASSWORD=?";
//		User emp = new User();
//
//	    try (Connection con = ConnectionUtil.getConnection();
//	        java.sql.PreparedStatement stmt = con.prepareStatement(QUERY);) {
//	    	stmt.setString(1, userName);
//  		  	stmt.setString(2, pass);
//  		  	ResultSet rs = stmt.executeQuery();
//	        while(rs.next()) {
//	        emp.setUserName(rs.getString("userName"));
//	        emp.setPassword(rs.getString("pass"));
//	        emp.setUserId(rs.getInt("userId"));
//	        emp.setFirstName(rs.getString("firstName"));
//	       // employ.add(emp);
//	        }
//	    } catch (SQLException e) {
//	      e.printStackTrace();
//	    }
//		return emp;
//	}
//	public User login(String userName, String pass) {
	public static void main(String[] args) {
		int choice = 0;
		
		do {
			System.out.println("Please press 1 to test");
			
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
		switch(choice) {
		case 1:
		{
			String QUERY = "select userId, firstName, lastName, userName, email from UserRegister";
//			User u = new User();
			try(Connection con = ConnectionUtil.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(QUERY))	
			    {	
					while(rs.next()){
					int userId = rs.getInt("userId");
					String firstName = rs.getString("firstName");
					String lastName = rs.getString("lastName");
					String email = rs.getString("email");
					System.out.println(userId + " | " + firstName + " " + lastName  + " | " + email + " \n");} 
			    } catch (SQLException e)
				{
			    	e.printStackTrace(); 
			    }
				break;
		}
		}
	}while(choice!=6);
}

	// Register User
	public User register(String firstName, String lastName, String userName, String email, String pass,
			String jobPosition) {
				return null;
	}	

	// Forgot Password (String userName/email)
	public void forgotPassword(String username) {
		
	}
	
	// Logout
	public void logout() {
		
	}

	@Override
	public User login(String userName, String pass) {
		// TODO Auto-generated method stub
		return null;
	}


}
