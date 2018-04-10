package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserRepositoryDb;

@WebServlet("/premium")
public class PremiumServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private UserRepositoryDb repository;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		repository = new UserRepositoryDb();
		request.setAttribute("allUsers", repository.getAll());
		request.getRequestDispatcher("/premium.jsp").forward(request, response);
	}

}
