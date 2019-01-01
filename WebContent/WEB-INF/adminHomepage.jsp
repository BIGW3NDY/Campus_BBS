<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员主页</title>
  </head>
 
  <body>
  <input type="button" value="subforumManager" onclick="window.location.href('WEB-INF/subforumManager.jsp')"/>
  <input type="button" value="userManager" onclick="window.location.href('WEB-INF/userManager.jsp')"/>
  <input type="button" value="addAdmin" onclick="window.location.href('WEB-INF/addAdmin.jsp')"/>
  </body>
</html>