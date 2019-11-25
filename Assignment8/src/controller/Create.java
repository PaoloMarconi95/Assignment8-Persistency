package controller;

import design.pattern.Database;
import design.pattern.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public Create() {
		
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Sono quiiiii");
		User user = new User(request.getParameter("id"),
				request.getParameter("name"),
				request.getParameter("address"),
				request.getParameter("password"),
				request.getParameter("bestfriend"));
		Database db = Database.getInstance();
		String out = "User Correctly Created";
		if(!(User.insert(user, db))) {
			if(User.findById(user.getId(), db) == null) {
				out = "Cannot create the user since the bestfriend with user id =  " + request.getParameter("bestfriend") 
				+ " does not exist.";
		}
		else {
			out = "User with id = " + request.getParameter("id") + " already exists";
		}
		}
		request.setAttribute("error", out);
		getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
	}

}
