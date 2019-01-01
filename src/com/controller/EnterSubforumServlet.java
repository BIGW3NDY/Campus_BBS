package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.impl.SubforumDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.dao.inter.SubforumDao;
import com.dao.inter.UserDao;
import com.entity.Subforum;
import com.entity.User;
import com.entity.Post;

//进入板块
public class EnterSubforumServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("TAG: EnterSubforumServlet 被调用");
		
		int subforumId = Integer.parseInt(req.getParameter("subforum"));
		this.getServletContext().setAttribute("subforumId", subforumId);
		SubforumDao sd = new SubforumDaoImpl();
		Subforum subforum = sd.getSubforumById(subforumId);
		
		List<Post> list = sd.getAllPost(subforum);
		
		UserDao ud = new UserDaoImpl();
		
		List<User> userList = ud.getAllUserFromPostList(list);
		
		//将postList和host列表转发到jsp
		req.setAttribute("postList", list);
		this.getServletContext().setAttribute("postList", list);
		req.setAttribute("hostList", userList);
		this.getServletContext().setAttribute("hostList", userList);
		req.getRequestDispatcher("/subforum.jsp").forward(req, resp);
		
	}

}
