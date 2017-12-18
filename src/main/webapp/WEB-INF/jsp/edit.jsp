<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="update" modelAttribute="employeeInfo"  method="post">
		<table>			
			<tr>
				<td>Id :</td>
				<td><input type="hidden" name="id" value="${employeeInfo.id}" /></td>
			</tr>
			<tr>
				<td>User Name :</td>
				<td><input type="text" name="uname" value="${employeeInfo.uname}" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="text" name="password" value="${employeeInfo.password}" /></td>
			</tr>
			<tr>
				<td>Employee Name :</td>
				<td><input type="text" name="empname" value="${employeeInfo.empname}" /></td>
			</tr>
			<tr>
				<td>empaddress :</td>
				<td><input type="text" name="empaddress" value="${employeeInfo.empaddress}" /></td>
			</tr>
			<tr>
				<td>Salary :</td>
				<td><input type="text" name="salary" value="${employeeInfo.salary}" /></td>
			</tr>
			<tr>
				<td>BOD :</td>
				<td><input type="text" name="birthdate" value="${employeeInfo.birthdate}" /></td>
			</tr>
			<tr>
				<td>Designation :</td>
				<td><input type="text" name="designation" value="${employeeInfo.designation}" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>