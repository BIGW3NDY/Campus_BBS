package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.impl.ReplyDaoImpl;
import com.dao.inter.ReplyDao;
import com.entity.Post;
import com.entity.Reply;
import com.entity.User;

public class ReplyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("TAG: ReplyServlet 被调用");
		
		HttpSession session = req.getSession();
		
		User user = (User) session.getAttribute("user"); 
		int postId = ((Post) this.getServletContext().getAttribute("post")).getPostId();
		Date currentDate = new Date(System.currentTimeMillis());
		Time currentTime = new Time(System.currentTimeMillis());
		String replyContent = req.getParameter("reply");
		
		Reply reply = new Reply(user.getUserId(), postId, currentDate, currentTime, replyContent);
		
		ReplyDao rd = new ReplyDaoImpl();
		rd.publish(reply);
		
		List<Reply> replyList = (List<Reply>) this.getServletContext().getAttribute("replyList");
		replyList.add(reply);
		req.setAttribute("replyList", replyList);
		
		List<User> authorList = (List<User>) this.getServletContext().getAttribute("authorList");
		authorList.add(user);
		req.setAttribute("authorList", authorList);
		
		req.getRequestDispatcher("/post.jsp").forward(req, resp);
		
	}
}
