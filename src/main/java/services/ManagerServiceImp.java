package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import con.ConnectionUtil;
import models.Manager;
import models.Request;
import models.User;

public class ManagerServiceImp implements ManagerServices {
	
	// IMPLEMENTATION //
	
	// View all Employees
	public void viewEmployees() {
		System.out.println("Viewing all employees\n");
		
		String QUERY = "select userId, firstName, lastName, userName, email from UserRegister";
		try(Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY))	
		    {	
				while(rs.next()){
				int userId = rs.getInt("userId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String userName = rs.getString("userName");
				String email = rs.getString("email");
				System.out.println(userId + " | " + firstName + " " + lastName  + " | " + userName + " | " + email + " \n");} 
		    } catch (SQLException e)
			{
		    	e.printStackTrace(); 
		    }
	}
	// Approve Requests (Manager m, Request r)
	public void approveRequest(Manager m, Request r) {
		
	}
	// Deny Requests (Manager m, Request r)
	public void denyRequest(Manager m, Request r) {
		
	}
	// Restore Password (String userName/email)
	public void restorePassword(String userName, String email) {
		
	}
}
