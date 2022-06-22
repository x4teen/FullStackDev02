<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="SubjectController" method="post">
		<label>Subject Id : </label>
		<input type="number" name="sid"/><br/>
		
		<label>Subject Name : </label>
		<input type="text" name="subjectName"/><br/>

		<input type="submit" value="Add">
		<input type="reset" value="reset">
	
	</form>
	<br/>

</body>
</html>