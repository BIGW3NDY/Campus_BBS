package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.impl.SubforumDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.dao.inter.SubforumDao;
import com.dao.inter.UserDao;
import com.entity.Subforum;
import com.entity.User;


public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("TAG: LoginServlet 被调用");
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		UserDao ud = new UserDaoImpl();
		User newUser = ud.login(name, pwd);
		System.out.println(name+" "+pwd);
		
		if(newUser!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", newUser);
			
			request.setAttribute("message", "welcom " + name);
			
			if(newUser.getIsAdmin()==0) {
				SubforumDao sd = new SubforumDaoImpl();
				List<Subforum> list = sd.getAllSubforum();
				System.out.print(list.size());
			
				request.setAttribute("SubforumList", list);
			
				request.getRequestDispatcher("/homepage.jsp").forward(request, response);
			}
			else if(newUser.getIsAdmin()==1){
				request.getRequestDispatcher("/WEB-INF/adminHomepage.jsp").forward(request, response);
				//response.sendRedirect("WEB-INF/adminHomepage.jsp");
			}
		}
		else {
			request.setAttribute("message", "login failed");
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}
	}
}
