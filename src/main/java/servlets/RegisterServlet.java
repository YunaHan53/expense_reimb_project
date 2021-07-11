package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import services.UserServicesImp;

public class RegisterServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LogManager.getLogger(LoginServlet.class);

	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
		request.getRequestDispatcher("/register.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String jobPosition = request.getParameter("jobPosition");
		String pass2 = request.getParameter("passConfirm");

        
		UserServicesImp usi = new UserServicesImp();
		int id = usi.generateUserId();
		
        log.info("Registering new user...");

        try {
            

            
            if(pass.equals(pass2)) {
            	usi.register(id, firstName, lastName, userName, email, pass, jobPosition, pass2);
                out.println("You are sucessfully registered");
                log.info("Registered Successfully!!!");

                response.sendRedirect("login.html");
            } else {
                out.println("Username or Password incorrect. Please try again.");
                log.error("Registration failed... please check that all fields are filled out");

                response.sendRedirect("register.html");
            }
	    	System.out.println("Got to register servlet try block");

        
        }
        catch(Exception e) {
            e.printStackTrace();
        }
	
    }
}
