package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserRepositoryDb;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserRepositoryDb repository;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		repository = new UserRepositoryDb();
		try {
			repository.updateUser(request.getParameter("userName"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	response.sendRedirect("admin.jsp?error=2");
	}

}
