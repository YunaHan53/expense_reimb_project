package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import con.ConnectionUtil;
import models.User;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID =1L;

	private static final Logger log = LogManager.getLogger(LoginServlet.class);
	
//	public static void main(String[] args) {
//	int choice = 0;
//	
//	do {
//		System.out.println("Please press 1 to test");
//		
//		Scanner sc = new Scanner(System.in);
//		choice = sc.nextInt();
//	switch(choice) {
//	case 1:
//	{
//		String QUERY = "select userId, firstName, lastName, userName, email, jobPosition from UserRegister";
//		try(Connection con = ConnectionUtil.getConnection();
//				Statement stmt = con.createStatement();
//				ResultSet rs = stmt.executeQuery(QUERY))	
//		    {	
//				while(rs.next()){
//				int userId = rs.getInt("userId");
//				String firstName = rs.getString("firstName");
//				String lastName = rs.getString("lastName");
//				String userName = rs.getString("username");
//				String email = rs.getString("email");
//				String jobPosition = rs.getString("jobposition");
//				System.out.println(userId + " | " + firstName + " " + lastName  + " | " + userName + " | " + email + " | " + jobPosition + "\n");} 
//		    } catch (SQLException e)
//			{
//		    	e.printStackTrace(); 
//		    }
//			break;
//	}
//	}
//}while(choice!=6);
//}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
		request.getRequestDispatcher("/login.html").forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String userName = request.getParameter("username");
        String pass = request.getParameter("pass");
        
//        User u = new User();
//        
//        u.setUserName(userName);
//        u.setPassword(pass);
        
        System.out.println(userName + " " + pass);

        
        log.info("Validating credentials...");
        
        try {

            if(Validate.checkUser(userName, pass))
            {
                response.sendRedirect("welcome.html");
                out.println("Signed in Successfully!");

                log.info("Validated!!!");
                
                System.out.println("Success! " + userName + " " + pass);

            }
            else
            {
               response.sendRedirect("index.html");
               out.println("Username or Password incorrect. Please try again.");
               
               log.error("Validation error, please check your username and password.");

            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

    }  

}

