<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="TeacherController" method="post">
		<label>Teacher Id : </label>
		<input type="number" name="tid"/><br/>
		
		<label>Teacher Name : </label>
		<input type="text" name="teacherName"/><br/>

		<input type="submit" value="Add">
		<input type="reset" value="reset">
	</form>
	<br/>

</body>
</html>