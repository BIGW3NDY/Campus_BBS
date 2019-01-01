<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>发帖</title>
</head>
<body>
	<form action="PostServlet" method="post" style="padding-top:-700px;">
		标题：<input type="text" name="title" value=""><br><br>
		正文：<input type="text" name="body" value=""><br><br>
		<input type="submit" value="发帖" name="post"><input type="reset" value="重置"><br>
	</form>
</body>
</html>