package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestJDBCOracleOnAWS {
	public static void main(String[] args) {
		int choice=0;
		
		do {
			System.out.println("/*** Employee Menu, please input a number to select ***/ \n"
					+ "1. Display all employees\n"
					+ "2. Add new employee\n"
					+ "3. Find employee by employee ID\n"
					+ "4. Update an employee\n"
					+ "5. Display an employee's monthly salary\n"
					+ "6. Delete an employee\n"
					+ "7. Quit");
			
			Scanner sc=new Scanner(System.in);
			choice = sc.nextInt();
		switch (choice) {
		case 1:
		{  
			String QUERY = "select userId,userName,pass,email from User1";
			try(Connection con = ConnectionUtil.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(QUERY))
			    {	
					while(rs.next()){
					int userId = rs.getInt("userId");
					String userName = rs.getString("userName");
					String email = rs.getString("email");
					System.out.println("Connecting...\n"
							+ "...\n"
							+ "...\n");
					System.out.println(userId + " | " + userName + " | " + email + " \n");
				} //try
			} catch (SQLException e) {e.printStackTrace(); }
			break;
		}
//		case 2: 
//		{
//			String QUERY = "insert into user values(01, 'Kimberly123', 'Kimberly123@gmail.com')";
//			try(Connection con = ConnectionUtil.getConnection();
//					Statement stmt = con.createStatement())
//				{ int result = stmt.executeUpdate(QUERY);
//				System.out.println(" Result is :"+result);
//			     if (result==1) 
//			    	System.out.println(" Data Inserted");
//			     else
//			    	 System.out.println(" Issue in data insertion ");
//			    } catch (SQLException e) {e.printStackTrace(); }
//			break;
//		}

	}
		sc.close();		
	}while(choice!=6);
}
	
}
