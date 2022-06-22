package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Student;
import com.service.StudentService;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		HttpSession hs = request.getSession();
		String role = (String)hs.getAttribute("role");
		
		//create the JavaBean class object and save the value
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int cid = Integer.parseInt(request.getParameter("cid"));
		Student student = new Student(id, name, cid);

		//Service class
		StudentService sts = new StudentService();
		String result = sts.addStudent(student, role);
		pw.println(result);
		
		RequestDispatcher rd1 = request.getRequestDispatcher("home.jsp");
		rd1.include(request, response);;
	}

}
