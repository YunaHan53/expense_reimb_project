package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import models.User;
import services.UserServicesImp;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID =1L;

	private static final Logger log = LogManager.getLogger(LoginServlet.class);
	
	
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
        String jobPosition = request.getParameter("jobPosition");
        
//        System.out.println(userName + " " + pass);
		UserServicesImp usi = new UserServicesImp();
		User u = new User();

        
        log.info("Validating credentials...");
        
        try {

            if(usi.login(userName, pass, jobPosition) != null)
            {
            	if(u.getJobPosition().equalsIgnoreCase("manager")) {
                    response.sendRedirect("managerpage.html");
                    out.println("Signed in Successfully!");

                    log.info("Validated Manager!!!");
            	} else {
                    response.sendRedirect("employeepage.html");
                    out.println("Signed in Successfully!");

                    log.info("Validated Employee!!!");
            	}
         
//                System.out.println("Success! " + userName + " " + pass);

            }
            else
            {
               response.sendRedirect("login.html");
               out.println("Username or Password incorrect. Please try again.");
               
               log.error("Validation error, please check your username and password.");

            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

    }

}



