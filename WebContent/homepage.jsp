<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>论坛主页</title>
  </head>
  
  <body>
  <table  width="600" border="1" cellpadding="0" >
  		<tr>
	  		<th>板块</th>
	  		<th>介绍</th>
  		</tr>
     <c:forEach var="U" items="${SubforumList}"  > 
      	<tr>
	       <td><a href="EnterSubforumServlet?subforum=${U.subforumId}">${U.subforumName}</a></td>
	       <td>${U.subforumInfo}</td>
	  	</tr>
    </c:forEach>  
    </table>
  </body>
</html>