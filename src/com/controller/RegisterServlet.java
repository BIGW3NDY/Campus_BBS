package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.dao.impl.UserDaoImpl;
import com.dao.inter.UserDao;

public class RegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("TAG: RegisterServlet 被调用");
		
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		String college = req.getParameter("college");
		String Class = req.getParameter("class");
		
		User newUser = new User(name, pwd, sex, college, Class, 0);
		UserDao ud = new UserDaoImpl();
		if(ud.register(newUser)==true) {
			req.setAttribute("message", "welcome");
			req.setAttribute("User", newUser);
			req.getRequestDispatcher("/success.jsp");
		}
		else {
			req.setAttribute("message", "register failed");
			req.getRequestDispatcher("/success.jsp");
		}
		
	}

}
