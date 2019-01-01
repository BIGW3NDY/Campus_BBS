package com.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class FileToken implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String serviceToken = (String) req.getSession().getAttribute("token");
		String token = request.getParameter("token");
		req.getSession().setAttribute("token", UUID.randomUUID().toString());

		if (serviceToken == null) {
			System.out.println("serviceToken 为空！");
			filterChain.doFilter(request, response);
			return;
		}

		if (token == null) {
			System.out.println("token 为空！");
			filterChain.doFilter(request, response);
			return;
		}

		if (serviceToken.equals(token)) {
			System.out.println("没有重复提交！");
			filterChain.doFilter(request, response);
			req.getSession(false).setAttribute("token", "");
			return;

		} else {
			System.out.println("重复提交！");
			//resp.sendRedirect(req.getRequestURL().toString());
			return;
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
