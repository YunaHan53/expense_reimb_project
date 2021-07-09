package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID =1L;

	private static final Logger log = LogManager.getLogger(LoginServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
		request.getRequestDispatcher("/login.html").forward(request, response);
	}

		 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String userName = request.getParameter("userName");
        String pass = request.getParameter("pass");
        
        log.info("Validating credentials...");
        
        try {
            if(Validate.checkUser(userName, pass))
            {
                out.println("Signed in Successfully!");
                response.sendRedirect("welcome.html");
                log.info("Validated!!!");
            }
            else
            {
               out.println("Username or Password incorrect. Please try again.");
               response.sendRedirect("index.html");
               
               log.error("Validation error, please check your username and password.");

               System.out.println(userName + " " + pass);

            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

    }  


//	public void doPost(HttpServletRequest request, HttpServletResponse response)  
//	        throws ServletException, IOException {  
//		User u = new User(11, "Homer", "Simpson","IlikeDonuts512", "HJSimpson@springfield.com", "1234", "employee");
//	    response.setContentType("text/html");  
//	    PrintWriter out = response.getWriter();  
//	          
//	    String un=request.getParameter("userName");  
//	    String p=request.getParameter("pass");  
//	    UserServicesImp usi = new UserServicesImp();
//	    User attempt = usi.login(un,p);
//	    System.out.println(attempt.getUserName() + " : " + attempt.getPassword());
//	          if(attempt.getUserName() != null) {
//
//	          } else{  
//	              out.print("Sorry UserName or Password Error!");  
//	              RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
//	              rd.include(request, response);  
//	                            
//	              }  
//	    }  
}

