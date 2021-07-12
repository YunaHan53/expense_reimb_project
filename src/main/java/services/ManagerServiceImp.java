package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import con.ConnectionUtil;
import models.Manager;
import models.Request;
import models.User;

public class ManagerServiceImp implements ManagerServices {
	
	// IMPLEMENTATION //
	
	// View all Employees
	public List<User> viewAllEmployees() {
		System.out.println("Viewing all employees\n");
		
		List<User> u = new ArrayList<User>();
		String QUERY = "select * from userregister order by id asc";
					
		try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QUERY);
				ResultSet rs = ps.executeQuery())	
		    {	
			while (rs.next()) {
				int userId = rs.getInt("id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String userName = rs.getString("userName");
				String pass = rs.getString("pass");
				String email = rs.getString("email");
				String jobPosition = rs.getString("jobPosition");
				u.add(new User(userId, firstName, lastName, userName, email, pass, jobPosition));
							
				} 
		    } catch (SQLException e)
			{
		    	e.printStackTrace(); 
		    }
		return u;
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
