<%@page import="com.service.Permissions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
<h2>

<% String user = (String)session.getAttribute("user"); 
String role = (String)session.getAttribute("role");
out.println("Welcome to Home Page - " + user + "<br/>"); 
%>
</h2><br>

<%int authLevel = Permissions.getPermission(role);
   if (authLevel >= 4) {%>
<div class="add">
<h4>Add A Subject</h4>
	<%@include file="addSubject.jsp" %>
</div>

<div class="add">
<h4>Add A Teacher</h4>
	<%@include file="addTeacher.jsp" %>
</div>

<div class="add">
<h4>Add A Class</h4>
	<%@include file="addClass.jsp" %>
</div>

<div class="add">
<h4>Add A Student</h4>
	<%@include file="addStudent.jsp" %>
</div>

<%} else {out.println("Welcome User");} %>

<div class="view">
	<%@include file="classReport.jsp" %>
</div>

 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>

</body>
</html>