package org.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.capgemini.pojo.LoginUser;
import org.capgemini.service.LoginService;
import org.capgemini.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String userName=request.getParameter("uname");
		String userPwd=request.getParameter("upwd");
		
		LoginUser loginUser=new LoginUser();
		loginUser.setUserName(userName);
		loginUser.setUserPwd(userPwd);
		
		
		LoginService loginService=new LoginServiceImpl();
		
		
		
		if(loginService.isValidLogin(loginUser))
			//response.sendRedirect("pages/success.html");
			request.getRequestDispatcher("pages/success.html").forward(request, response);
		else
			response.sendRedirect("pages/login.html");
		
	}

}
