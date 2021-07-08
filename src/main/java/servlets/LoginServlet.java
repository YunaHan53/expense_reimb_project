package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID =1L;

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
        
        if(Validate.checkUser(userName, pass))
        {
            RequestDispatcher rs = request.getRequestDispatcher("Welcome");
            rs.forward(request, response);
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
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

