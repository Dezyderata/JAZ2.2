<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(request.getParameter("error")!=null){ %>
		<h2>Password doesn't match confirmation!</h2>
	<%} %>
	<form method="get" action="/registration">
		<h2>Sign in:</h2>
		<br>
		<label>Username:<input type="text" id="name" name="name" required/></label><br/>
		<label>Password:<input type="password" id="psw" name="psw" required/></label><br/>
		<label>Password:<input type="password" id="psw2" name="psw2" required/></label><br/>
		<label>Email:<input type="text" id="email" name="email" required/></label>
		<input type="submit" value="sign in"/>	
	</form>
</body>
</html>