package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import con.ConnectionUtil;

public class RegisterServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
		request.getRequestDispatcher("/register.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
        int userId = Integer.parseInt(request.getParameter("userId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String jobPosition = request.getParameter("jobPosition");
        
        try {
    		Connection con = ConnectionUtil.getConnection();
    		String QUERY = "insert into UserRegister(userId,firstName,lastName,userName,email,pass,jobPosition) values (?,?,?,?,?,?,?) ";

            PreparedStatement ps = con.prepareStatement(QUERY);

            ps.setInt(1, userId);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, userName);
            ps.setString(5, email);
            ps.setString(6, pass);
            ps.setString(7, jobPosition);

            int i = ps.executeUpdate();
            
            if(i > 0) {
                out.println("You are sucessfully registered");
            }
        
        }
        catch(Exception se) {
            se.printStackTrace();
        }
	
    }
}

//public class RegisterServlet extends HttpServlet {
//  private static final long serialVersionUID = 1L;
//
//  public RegisterServlet() {
//	  super();
//  }
//  
//  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
//		  throws ServletException, IOException {
//	  response.setContentType("text/html");
//	  	int userId = Integer.parseInt(request.getParameter("userId"));
//		String firstName = request.getParameter("firstName");
//		String lastName = request.getParameter("lastName");
//		String userName = request.getParameter("userName");
//		String email = request.getParameter("email");
//		String pass = request.getParameter("pass");
//		String jobPosition = request.getParameter("jobPosition");
//
//		
//		User u = new User(userId, firstName, lastName, userName, email, pass, jobPosition);
//		UserDAO dao = new UserDAO();
//		String result = dao.Registerindb(u);
//
//	    if (result.equals("User is registered")) {
//	        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
//	        dispatcher.include(request, response);
//	      } else {
//	        RequestDispatcher dispatcher = request.getRequestDispatcher("register.html");
//	        dispatcher.include(request, response);
//	      }
//		  }
//}
