<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.User" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List of all users:</h1>
		<table border=1>
		<tr>
		<td>Username</td>
		<td>Premium account</td>
		</tr>
		<c:forEach items="${allUsers}" var="users">
			<tr>
				<td>${users.getName()}</td>
				<td>${users.isPremium()}</td>
			</tr>
		</c:forEach>
		</table>
		<form action="/main.jsp" method="get">
			<h2>I want to go back to main:</h2>
			<br>
			<input type="submit" value="Back"/>
		</form>
	
</body>
</html>