<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>论坛主页</title>
  </head>
 
  <body>
  <input type="button" value="post" onclick="window.location.href('editor.jsp')"/>
  <table  width="600" border="1" cellpadding="0" >
  		<tr>
	  		<th>标题</th>
	  		<th>发帖人</th>
	  		<th>时间</th>
  		</tr>
     <c:forEach var="P" items="${postList}" varStatus="loop" > 
      	<tr>
	       <td><a href="BrowsePostServlet?postIndex=${loop.count-1}">${P.postTitle}</a></td>
	       <td>${hostList[loop.count-1].userName}</td>
	       <td>${P.postDate} ${P.postTime}</td>
	  	</tr>
    </c:forEach>  
    </table>
  </body>
</html>