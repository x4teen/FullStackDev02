package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Subject;
import com.service.SubjectService;

/**
 * Servlet implementation class SubjectServlet
 */
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		Subject sb = new Subject();
		int sid = Integer.parseInt(request.getParameter("sid"));
		String subjectName = request.getParameter("subjectName");
		sb.setSid(sid);
		sb.setSubjectName(subjectName);

		//Service class
		SubjectService sbs = new SubjectService();
		String result = sbs.addSubject(sb, role);
		pw.println(result);
		
		RequestDispatcher rd1 = request.getRequestDispatcher("home.jsp");
		rd1.include(request, response);
	}

}
