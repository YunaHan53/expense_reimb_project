package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import con.ConnectionUtil;
import models.User;

public class UserServicesImp implements UserServices {

	// IMPLEMENTATION //
	

	// Register User
	public boolean register(int id, String firstName, String lastName, String userName, String email, String pass,  String jobPosition, String passConfirm) {
		
		String QUERY2 = "insert into userRegister values(?,?,?,?,?,?,?,?)";
		if(id == -1) {
			return false;
		}
		
	    try (Connection con = ConnectionUtil.getConnection();
		        PreparedStatement ps2 = con.prepareStatement(QUERY2);
	    	) 
	    {
						ps2.setInt(1, id);
						ps2.setString(2, firstName);
						ps2.setString(3, lastName);
						ps2.setString(4, userName);
						ps2.setString(5, email);
						ps2.setString(6, pass);
						ps2.setString(7, jobPosition);
						ps2.setString(8, passConfirm);
		    		
		    	
		    	ps2.executeUpdate();
		    	
		      
		}catch (SQLException e) {
		      e.printStackTrace();
		      return false;
		    }
		    return true;
		}
	
	
	// Login
    public User login(String userName, String pass, String jobPosition) {
    	User u = new User();

        try {
    		Connection con = ConnectionUtil.getConnection();

            PreparedStatement ps = con.prepareStatement("select * from userregister where username = ? and pass = ? ");
            ps.setString(1, userName);
            ps.setString(2, pass);
                        
            ResultSet rs =ps.executeQuery();

            while(rs.next()) {
            	u.setUserName(rs.getString("username"));
            	u.setPassword(rs.getString("pass"));
            	u.setJobPosition(rs.getString("jobPosition"));
            }
            System.out.println("USI " + userName + pass + jobPosition);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return u;                 
    }

    // Updates User Info
	public boolean updateUserInfo(User u) throws SQLException {
		
		boolean rowUpdated;
		
		String QUERY = "update userregister set userName = ?, email = ?, jobPosition = ?;";

		
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QUERY);) {
			System.out.println("User updated: " + ps);
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getJobPosition());

			rowUpdated = ps.executeUpdate() > 0;
			
		}
		return rowUpdated;
	};

	// Generate User Id
	public int generateUserId() {

			int newID = 0;

			String QUERY = "select * from userregister order by userId desc";
			String QUERY2 = "select * from userregister order by userId desc";
			
			try (Connection con = ConnectionUtil.getConnection();
		        PreparedStatement stmt = con.prepareStatement(QUERY);
				PreparedStatement stmt2 = con.prepareStatement(QUERY2);) {

	  		  	ResultSet rs = stmt.executeQuery();
	  		  	ResultSet rs2 = stmt2.executeQuery();
	  		  	rs.next();
	  		  	rs2.next();
	  		  	try {  			
	  		  		if(rs.getInt("userId") > rs2.getInt("userId")) {
	  		  			newID = rs.getInt("userId") + 1;
	  		  		}else if(rs.getInt("userId") < rs2.getInt("userId")){
	  		  			newID = rs2.getInt("userId") + 1;
	  		  		}else {
	  		  			newID = rs.getInt("userId") + 1;
	  		  		}
	  		  	}finally {
	  		  	}
	  		  
		    } catch (SQLException e) {
		      e.printStackTrace();
		      
		    }
			return newID;
	}
	
	// Select User by ID
	public User selectUser(int userId) {
    	User u = new User();
		
		String QUERY = "select * from userregister where id = ?";
		
		try (Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(QUERY);) {
			
				ps.setInt(1, userId);
				
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				u.setFirstName(rs.getString("firstName"));
				u.setLastName(rs.getString("lastName"));
            	u.setUserName(rs.getString("username"));
            	u.setPassword(rs.getString("pass"));
            	u.setJobPosition(rs.getString("jobPosition"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return u;
	}
	
	// Forgot Password (String userName/email)
	public void forgotPassword(String username) {
		
	}


}
