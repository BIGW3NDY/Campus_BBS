<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>My JSP 'BB.jsp' starting page</title>
</head>
<body>
<form action="RegisterServlet" method="post" style="padding-top:-700px;">
	输入用户名：<input name="name" type="text"><br><br>
	输入密码：<input name="pwd" type="password"><br><br>
	选择性别：<input type="radio" name="sex" value="男" checked>男
		<input type="radio" name="sex" value="女">女<br><br>
	选择学院：<select name="college">
		<option value="信工" selected>信息工程学院</option>
		<option value="理学院" >理学院</option>
		<option value="经管">经济管理学院</option>
	</select><br>
	输入班级：<input name="class" type="text"><br><br>
	<input type="reset" value="重置"><input type="submit" value="注册">
</form>	

</body>
</html>