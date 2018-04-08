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
		<h2>This user doesn't exists!</h2>
	<%}else if(request.getParameter("error").equals("2")){%>
		<h2>Success!</h2>
	<%}} %>
		<form action="/admin" method="get">
			<h2>Insert user which privileges you want to change:</h2>
			<br>
			<label>Username:<input type="text" id="userName" name="userName" required/></label><br/>
			<input type="submit" value="Change"/>
		</form>
		<form action="/main.jsp" method="get">
			<h2>I want to go back to main:</h2>
			<br>
			<input type="submit" value="Back"/>
		</form>
</body>
</html>