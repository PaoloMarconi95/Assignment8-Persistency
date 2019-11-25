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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Database db = Database.getInstance();
		switch (request.getParameter("operation").toString()) {
		case "create":
			create(request, response, db);
			getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			break;
		case "login":
			login(request, response, db);
			break;
		case "update":
			update(request, response, db);
			break;
		case "delete":
			// delete(request, response, db);
			break;
		default:
			System.out.println("error");
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response, Database db)
			throws ServletException, IOException {
		String out;
		User user = User.findById(request.getParameter("id"), db);

		// If the new bestfriend does not exists, cancel the operation
		if (User.findById(request.getParameter("bestfriend"), db) == null) {
			out = "Bestfriend does not exists (id = " + request.getParameter("bestfriend") + ")";
		} else {
			if (user != null) {
				String[] param = new String[4];
				param[0] = request.getParameter("name");
				param[1] = request.getParameter("address");
				param[2] = request.getParameter("password");
				param[3] = request.getParameter("bestfriend");
				User.update(request.getParameter("id"), param, db);
				out = "User correctly updated";
			} else {
				out = "No result found with id = " + request.getParameter("id");
			}
		}
		User check = User.findById(request.getParameter("id"), db);
		request.setAttribute("loggedUser", check);
		request.setAttribute("out", out);
		getServletContext().getRequestDispatcher("/userhome.jsp").forward(request, response);
	}

	private void create(HttpServletRequest request, HttpServletResponse response, Database db) {
		User user = new User(request.getParameter("id"), request.getParameter("name"), request.getParameter("address"),
				request.getParameter("password"), request.getParameter("bestfriend"));
		String out = "User Correctly Created";
		if (!(User.insert(user, db))) {
			if (User.findById(user.getId(), db) == null) {
				out = "Cannot create the user since the bestfriend with user id =  "
						+ request.getParameter("bestfriend") + " does not exist.";
			} else {
				out = "User with id = " + request.getParameter("id") + " already exists";
			}
		}
		request.setAttribute("error", out);
	}

	private void login(HttpServletRequest request, HttpServletResponse response, Database db)
			throws ServletException, IOException {
		User result = User.lookForPassword(request.getParameter("name"), request.getParameter("password"), db);
		if (result != null) {
			// Correct login, Result found
			request.setAttribute("loggedUser", result);
			getServletContext().getRequestDispatcher("/userhome.jsp").forward(request, response);
		} else {
			// Incorrect Login
			request.setAttribute("error",
					"User not found or password incorrect for user " + request.getParameter("name"));
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}