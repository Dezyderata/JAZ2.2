package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import dao.UserRepositoryDb;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private UserRepositoryDb repository;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		try {
			repository = new UserRepositoryDb();
			checkUser(retrieveUserFromRequest(request), request, response, session);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private User retrieveUserFromRequest(HttpServletRequest request) {
		User result = new User();
		result.setName(request.getParameter("name"));
		result.setPassword(request.getParameter("psw"));
		return result;
	}
	private void checkUser(User user, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException, SQLException {
			if(repository.searchForUser(user.getName(), user.getPassword())) {
	        	session.setAttribute("conf", repository.getUserInformationByName(user.getName()));   
	        	response.sendRedirect("main.jsp");
	        } else {
	         	response.sendRedirect("index.jsp");
	        }
	}

}
