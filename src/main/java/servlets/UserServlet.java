package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import models.User;
import services.ManagerServiceImp;
import services.UserServicesImp;

public class UserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private UserServicesImp usi;
	private ManagerServiceImp msi;
	
	public void init() throws ServletException {
		usi = new UserServicesImp();
		msi = new ManagerServiceImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listAllUsers(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void showNewForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
		dispatcher.forward(request, response);
	}
	
	// Edit User
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
	{
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		
		try {
			User existingUser = usi.selectUser(userId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
			request.setAttribute("user", response);
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Update User
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		int userId = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String jobPosition = request.getParameter("jobPosition");
		
		User u = new User(userId, firstName, lastName, userName, pass, email, jobPosition);
		usi.updateUserInfo(u);
		response.sendRedirect("list");
	}
	
	// Default - List all Users
	private void listAllUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		
		try {
			List<User> listAllUsers = msi.viewAllEmployees();
			request.setAttribute("listAllUsers", listAllUsers);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}

			}
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		doGet(request, response);
	
    }
}
