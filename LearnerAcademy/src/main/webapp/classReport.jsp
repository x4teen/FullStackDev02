<%@page import="com.bean.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.CourseDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Class Report</h2>

<table border="1">
  <tr>
    <th>Course Id</th>
    <th>Course Title</th>
    <th>Subject Id</th>
    <th>Teacher Id</th>
  </tr>
  
  <% CourseDao cd = new CourseDao();
			List<Course> cList = cd.getCourses();
			
			for (Course course: cList){ %>
			<tr>
				<td><a href="courseDetails.jsp?cid=<%=course.getCid()%>"><%=course.getCid()%></a></td>
				<td><%=course.getCourseTitle() %></td>
				<td><%=course.getSid() %></td>
				<td><%=course.getTid() %></td>
			</tr>
  			<%}%>
  
  </table>

</body>
</html>