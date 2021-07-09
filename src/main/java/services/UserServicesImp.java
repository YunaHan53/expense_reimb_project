package services;

import models.User;

public class UserServicesImp implements UserServices {

	// IMPLEMENTATION //
	
	// Login (String userName, String pass)

//	public static void main(String[] args) {
//		int choice = 0;
//		
//		do {
//			System.out.println("Please press 1 to test");
//			
//			Scanner sc = new Scanner(System.in);
//			choice = sc.nextInt();
//		switch(choice) {
//		case 1:
//		{
//			String QUERY = "select userId, firstName, lastName, userName, email from UserRegister";
////			User u = new User();
//			try(Connection con = ConnectionUtil.getConnection();
//					Statement stmt = con.createStatement();
//					ResultSet rs = stmt.executeQuery(QUERY))	
//			    {	
//					while(rs.next()){
//					int userId = rs.getInt("userId");
//					String firstName = rs.getString("firstName");
//					String lastName = rs.getString("lastName");
//					String email = rs.getString("email");
//					System.out.println(userId + " | " + firstName + " " + lastName  + " | " + email + " \n");} 
//			    } catch (SQLException e)
//				{
//			    	e.printStackTrace(); 
//			    }
//				break;
//		}
//		}
//	}while(choice!=6);
//}

	// Register User
	public User register(String firstName, String lastName, String userName, String email, String pass,
			String jobPosition) {
				return null;
	}	

	// Forgot Password (String userName/email)
	public void forgotPassword(String username) {
		
	}
	
	// Login
	public User login(String userName, String pass) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Logout
	public void logout() {
		
	}





}
