package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Login;
import com.service.LoginService;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter pw = response.getWriter();
//		response.setContentType("text/html");
//		
//		//create the JavaBean class object and save the value
//		Login ll = new Login();
//		ll.setEmail(request.getParameter("email"));
//		ll.setPassword(request.getParameter("password"));
//		
//		//Service class
//		LoginService ls = new LoginService();
//		
//		String result = ls.createUser(ll);
//		pw.println(result);
//		
//		RequestDispatcher rd1 = request.getRequestDispatcher("index.jsp");
//		
//		rd1.include(request, response);
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		HttpSession hs = request.getSession();
		
		//create the JavaBean class object and save the value
		Login ll = new Login();
		ll.setEmail(request.getParameter("email"));
		ll.setPassword(request.getParameter("password"));
		ll.setName("");
		ll.setRole("");

		//Service class
		LoginService ls = new LoginService();
		
		Login user = ls.checkUser(ll);

		RequestDispatcher rd1 = request.getRequestDispatcher("home.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("index.jsp");
		
		if (user != null) {
			hs.setAttribute("user", user.getName());
			hs.setAttribute("role", user.getRole());
			rd1.forward(request, response);
		} else {
			pw.println("Invalid username or password");
			rd2.include(request, response);
		}
		
	}

}
