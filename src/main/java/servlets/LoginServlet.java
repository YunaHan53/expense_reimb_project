package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import services.UserServicesImp;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID =1L;

	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
		request.getRequestDispatcher("/login.html").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
		User u = new User(11, "Homer", "Simpson","IlikeDonuts512", "HJSimpson@springfield.com", "1234", "employee");
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("userName");  
	    String p=request.getParameter("pass");  
	    UserServicesImp usi = new UserServicesImp();
	    User attempt = usi.login(n,p);
	    System.out.println(attempt.getUserName() + " : " + attempt.getPassword());
	          if(attempt.getUserName() != null) {
	        	  if(attempt.getJobPosition().equalsIgnoreCase("employee")) {
	        		  RequestDispatcher rd=request.getRequestDispatcher("/Employee.jsp");  
	                  rd.forward(request, response);  
	        	  }else if(attempt.getJobPosition().equalsIgnoreCase("manager")) {
	        		  RequestDispatcher rd=request.getRequestDispatcher("/Manager.jsp");  
	                  rd.forward(request, response);  
	        	  }
	          } else{  
	              out.print("Sorry UserName or Password Error!");  
	              RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
	              rd.include(request, response);  
	                            
	              }  
	    }  
}

