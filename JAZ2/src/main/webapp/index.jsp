<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(request.getParameter("error")!=null){
		if(request.getParameter("error").equals("1")){%>
		<h2>This user already exists!</h2>
	<%}else if(request.getParameter("error").equals("2")){ %>
		<h2>You don't have access to this site!</h2>
	<%}}%>
	<form action="/login" method="get">
		<h2>Sign in:</h2>
		<br>
		<label>Username:<input type="text" id="name" name="name" required/></label><br/>
		<label>Password:<input type="password" id="psw" name="psw" required/></label><br/>
		<input type="submit" value="login"/>
	</form>
	<form action="/registration.jsp">
		<br>
		<h2>Or sign up:</h2>
		<br>
		<input type="submit" value="sign up"/>
	</form>
</body>
</html>