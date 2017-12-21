<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Employees List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>UserName</th>
			<th>password</th>
			<th>Name</th>
			<th>Address</th>
			<th>Salary</th>
			<th>birthdate</th>
			<th>Designation</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="emp" items="${list}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.uname}</td>
				<td>${emp.password}</td>
				<td>${emp.empname}</td>
				<td>${emp.empaddress}</td>
				<td>${emp.salary}</td>
				<td>${emp.birthdate}</td>
				<td>${emp.designation}</td>
				<td><a href="deleteemp?id=${emp.id}">Delete</a></td>
				<td><a href="edit?id=${emp.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="empform">Add New Employee</a>
</body>
</html>