package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.impl.PostDaoImpl;
import com.dao.impl.SubforumDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.dao.inter.PostDao;
import com.dao.inter.SubforumDao;
import com.dao.inter.UserDao;
import com.entity.Post;
import com.entity.Subforum;
import com.entity.User;

//发帖
public class PostServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("TAG: PostServlet 被调用");
		
		//获取新帖信息
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user"); 
		String title = req.getParameter("title");
		String body = req.getParameter("body");
		int subforumId = (int) this.getServletContext().getAttribute("subforumId");
		
		//发帖
		Post post = new Post(title,user.getUserId(),body,subforumId);
		PostDao pd = new PostDaoImpl();
		pd.publish(post);
		
//		resp.sendRedirect("subforum.jsp");
		
		//从数据库获取该板块信息（Post和发帖人）
		SubforumDao sd = new SubforumDaoImpl();
		Subforum subforum = sd.getSubforumById(subforumId);
		
		List<Post> list = sd.getAllPost(subforum);
		
		UserDao ud = new UserDaoImpl();
		
		List<User> userList = ud.getAllUserFromPostList(list);
		
		//传值给subforum
		req.setAttribute("postList", list);
		this.getServletContext().setAttribute("postList", list);
		req.setAttribute("hostList", userList);
		this.getServletContext().setAttribute("hostList", userList);
		req.getRequestDispatcher("/subforum.jsp").forward(req, resp);
		System.out.println("what's wrong?");
	}

}
