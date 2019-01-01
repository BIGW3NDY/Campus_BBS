<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${post.postTitle}</title>
  </head>
  
  <body>
  <table  width="600" border="1" cellpadding="0" >
  		<tr>
  			<th>test</th>
  		<tr>
  			<td>${post.postTitle}</td>
  		<tr>
	  		<td>${host}</td>
	  		<td>${post.postBody}</td>
  		</tr>
  	<c:forEach var="R" items="${replyList}" varStatus="loop" > 
      	<tr>
	       <td>${authorList[loop.count-1].userName}</td>
	       <td>${R.replyContent}</td>
	       <td><input type="button" value="回复"/></td>
	  	</tr>
    </c:forEach>  
  </table>
  
  <form action = "ReplyServlet" method = "post">
  	<div>UUID:${token}</div>
  	<h4>回复</h4>
  	<textarea rows="4" cols="50" wrap="virtual" name="reply"></textarea>
  	<input type = "submit" value="提交" name="addReply">
  </form> 
   
  </body>
</html>