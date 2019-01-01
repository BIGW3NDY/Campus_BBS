package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.impl.PostDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.dao.inter.PostDao;
import com.dao.inter.UserDao;
import com.entity.Post;
import com.entity.Reply;
import com.entity.User;

// only two person can understand the code 
// the god and the one who wrote it

// now there's only one person can understand it

//浏览某条帖子
public class BrowsePostServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("TAG: BrowsePostServlet 被调用");
		
		//根据EnterSubforumServlet转发的属性获得相应post和发帖人（host）
		int postIndex = Integer.parseInt(req.getParameter("postIndex"));    
		List<Post> postList = (List<Post>) this.getServletContext().getAttribute("postList");
		System.out.println(postList.get(postIndex).getPostTitle());
		List<User> hostList = (List<User>) this.getServletContext().getAttribute("hostList");
		
		Post post = postList.get(postIndex);
		req.setAttribute("post",postList.get(postIndex));
		req.setAttribute("host",hostList.get(postIndex).getUserName());
	
		//根据postId找到该条帖子下的所有回复reply并转发到jsp页面
		PostDao pd = new PostDaoImpl();
		List<Reply> replyList = pd.getAllReply(post.getPostId());
		UserDao ud = new UserDaoImpl();
		List<User> authorList = ud.getAllUserFromReplyList(replyList);
		
		//将post信息转发到ReplyServlet
		this.getServletContext().setAttribute("post", post);
		this.getServletContext().setAttribute("replyList", replyList);
		this.getServletContext().setAttribute("authorList", authorList);
		req.setAttribute("replyList", replyList);
		req.setAttribute("authorList", authorList);
		req.getRequestDispatcher("/post.jsp").forward(req, resp);
	}

}
