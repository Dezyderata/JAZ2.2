package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import repositories.UserRepository;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		checkUser(retrieveUserFromRequest(request), request, response, session);
	}
	private User retrieveUserFromRequest(HttpServletRequest request) {
		User result = new User();
		result.setName(request.getParameter("name"));
		result.setPassword(request.getParameter("psw"));
		return result;
	}
	private void checkUser(User user, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
	        if (user.getName() == null || user.getName().isEmpty()) {
	        	response.sendRedirect("index.jsp");
	        }else if (user.getPassword() == null || user.getPassword().isEmpty()) {
	        	response.sendRedirect("index.jsp");
	        }else{
	        	UserRepository repository = new UserRepository();
	            if(repository.searchForUser(user.getName(), user.getPassword())) {
	            	session.setAttribute("conf", repository.getUserInformationByName(user.getName()));
	            	response.sendRedirect("main.jsp");
	            } else {
	            	response.sendRedirect("index.jsp");
	            }  
	        }
	}

}
