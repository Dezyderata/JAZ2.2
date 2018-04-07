<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Strona glowna</h2>
	<h3>Do strony premium:</h3>
	<form action="premium.jsp" method="get">
		<input type="submit" value="premium"/>
	</form>
	<h3>Strona do zarządzania kontami:</h3>
	<form action="/admin">
		<input type="submit" value="admin"/>
	</form>
</body>
</html>