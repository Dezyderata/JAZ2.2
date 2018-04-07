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

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		HttpSession session = request.getSession();

		User user = retrieveUserFromRequest(request);
		UserRepository repository = new UserRepository();
		if(repository.count()==0) {
			repository.add(new User("admin", "123", "admin@admin.com", true, true));
		}
		session.setAttribute("conf", user);
		
		repository.add(user);
		response.sendRedirect("main.jsp");
		
	}
	private User retrieveUserFromRequest(HttpServletRequest request) {
		User result = new User();
		result.setName(request.getParameter("name"));
		result.setPassword(request.getParameter("psw"));
		result.setEmail(request.getParameter("email"));
		result.setAdmin(false);
		result.setPremium(false);
		return result;
	}

}
