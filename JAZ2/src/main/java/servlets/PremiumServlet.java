package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repositories.UserRepository;

@WebServlet("/premium")
public class PremiumServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		UserRepository repository = new UserRepository();
		request.setAttribute("allUsers", repository.returnArray());
		request.getRequestDispatcher("/premium.jsp").forward(request, response);
	}

}
