package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repositories.UserRepository;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String name = request.getParameter("userName");
    	UserRepository repository = new UserRepository();
    	repository.setPrivilages(name);
    	response.sendRedirect("admin.jsp?error=2");
	}

}
