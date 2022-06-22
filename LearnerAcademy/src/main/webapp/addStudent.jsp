<%@page import="com.bean.Course"%>
<%@page import="com.dao.CourseDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="StudentController" method="post">
		<label>Student Id : </label>
		<input type="number" name="id"/><br/>
		
		<label>Student Name : </label>
		<input type="text" name="name"/><br/>
		
		<label for="course">Subject Id : </label>
		<select id="course" name="cid">
		
			<% 	CourseDao cd = new CourseDao();
			List<Course> cList = cd.getCourses();
			
			for (Course course: cList){ %>
				<option value="<%=course.getCid()%>"> <%=course.getCourseTitle()%></option>
			<%}%>
		</select>
		<br/>
		
		<input type="submit" value="Add">
		<input type="reset" value="reset">
	</form>
	<br/>

</body>
</html>