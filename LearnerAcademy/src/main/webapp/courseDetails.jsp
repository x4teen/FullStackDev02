<%@page import="com.bean.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.StudentDao"%>
<%@page import="com.bean.Teacher"%>
<%@page import="com.dao.TeacherDao"%>
<%@page import="com.bean.Subject"%>
<%@page import="com.dao.SubjectDao"%>
<%@page import="com.bean.Course"%>
<%@page import="com.dao.CourseDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Details</title>
</head>
<body>

<h3>
<%	String courseId = request.getParameter("cid");
	out.println("Course Id\t: " + courseId);
	
	CourseDao cd = new CourseDao();
	int cid = Integer.parseInt(courseId);
	Course course = cd.getCourseDetails(cid);
	out.println("<br/>Title:\t\t\t" + course.getCourseTitle());
	
	SubjectDao sd = new SubjectDao();
	int sid = course.getSid();
	Subject sb = sd.getSubjectDetails(sid);
	out.println("<br/>Subject:\t\t" + sb.getSubjectName());
	
	TeacherDao td = new TeacherDao();
	int tid = course.getTid();
	Teacher tt = td.getTeachertDetails(tid);
	out.println("<br/>Teacher:\t\t" + tt.getTeacherName());
%>
</h3><br>

<h2>Student List</h2> <br>

<table border="1">
  <tr>
    <th>Id</th>
    <th>Student Name</th>
    <th>Course Id</th>
  </tr>
  
  <% StudentDao std = new StudentDao();
			List<Student> stdList = std.getStudentsCourse(cid);
			
			for (Student student: stdList){ %>
			<tr>
				<td><%=student.getId()%></td>
				<td><%=student.getName()%></td>
				<td><%=student.getCid() %></td>
			</tr>
  			<%}%>
  </table>



</body>
</html>