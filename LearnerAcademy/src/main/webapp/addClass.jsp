<%@page import="com.bean.Subject"%>
<%@page import="com.dao.SubjectDao"%>
<%@page import="com.bean.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.TeacherDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="CourseController" method="post">
		<label>Course Id : </label>
		<input type="number" name="cid"/><br/>
		
		<label>Course Title : </label>
		<input type="text" name="courseTitle"/><br/>
		
		<label for="subject">Subject Id : </label>
		<select id="subject" name="sid">
		
			<% 	SubjectDao sd = new SubjectDao();
			List<Subject> sList = sd.getSubjects();
			
			for (Subject subject: sList){ %>
				<option value="<%=subject.getSid()%>"> <%=subject.getSubjectName()%></option>
			<%}%>
		</select>
		<br/>
		
		<label for="teacher">Teacher Id : </label>
		<select id="teacher" name="tid">
		<% 	TeacherDao td = new TeacherDao();
			List<Teacher> tList = td.getTeachers();
			
			for (Teacher teacher: tList){ %>
				<option value="<%=teacher.getTid()%>"> <%=teacher.getTeacherName()%></option>
			<%}%>
		</select>
		<br/>
		
		<input type="submit" value="Add">
		<input type="reset" value="reset">
	</form>
	<br/>

</body>
</html>