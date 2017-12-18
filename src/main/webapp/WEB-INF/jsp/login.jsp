<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form id="loginForm" method="post" action="login"
		modelAttribute="login">
		<form:label path="uname">Enter your user-name</form:label>
		<form:input id="username" name="uname" path="uname" />
		<br>
		<form:label path="password">Please enter your password</form:label>
		<form:password id="password" name="password" path="password" />
		<br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>