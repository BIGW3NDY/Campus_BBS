<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome</title>
</head>
<body>
	<form action="LoginServlet" method="post" style="padding-top:-700px;">
		用户名：<input type="text" name="name" value=""><br><br>
		密码：<input type="password" name="pwd" value=""><br><br>
		<input type="submit" value="登陆" name="Login"><input type="reset" value="重置"><br>
	</form>
	<form action="register.jsp">
		<input type="submit" value="新用户注册">
	</form>	
</body>
</html>