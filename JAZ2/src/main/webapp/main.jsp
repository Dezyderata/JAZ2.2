<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page session="true" %>
    <%@ page import="domain.User" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Main site</h2>
	<h3>You are:</h3>
	<c:out value="${conf.getName()}"/>
	<h3>Your password is:</h3>
	<c:out value="${conf.getPassword()}"/>
	<h3>Your email is:</h3>
	<c:out value="${conf.getEmail()}"/>
	<h3>Premium privileges:</h3>
	<c:out value="${conf.isPremium()}"/>
	<h3>Admin privileges:</h3>
	<c:out value="${conf.isAdmin()}"/>
	<br>
	<h3>Do strony premium:</h3>
	<form action="premium.jsp" method="get">
		<input type="submit" value="premium"/>
	</form>
	<h3>Strona do zarządzania kontami:</h3>
	<form action="/admin.jsp">
		<input type="submit" value="admin"/>
	</form>
</body>
</html>