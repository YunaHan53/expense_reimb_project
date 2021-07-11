package ers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import con.ConnectionUtil;

public class dbTesting {
	public static void main(String[] args) {
	int choice = 0;
	
	do {
		System.out.println("Please press 1 to test");
		
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
	switch(choice) {
	case 1:
	{
		String QUERY = "select userId, firstName, lastName, userName, email, jobPosition from UserRegister";
		try(Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY))	
		    {	
				while(rs.next()){
				int userId = rs.getInt("userId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String userName = rs.getString("username");
				String email = rs.getString("email");
				String jobPosition = rs.getString("jobposition");
				System.out.println(userId + " | " + firstName + " " + lastName  + " | " + userName + " | " + email + " | " + jobPosition + "\n");} 
		    } catch (SQLException e)
			{
		    	e.printStackTrace(); 
		    }
			break;
	}
	}
}while(choice!=2);
}
}
