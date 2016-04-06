package org.capgemini.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.capgemini.pojo.Employee;
import org.capgemini.service.LoginService;
import org.capgemini.service.LoginServiceImpl;

/**
 * Servlet implementation class SaveEmployeeServlet
 */
public class SaveEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginService loginService=new LoginServiceImpl();
		
		Employee employee=new Employee();
		
		employee.setFirstName(request.getParameter("fname"));
		employee.setLastName(request.getParameter("lname"));
		employee.setAddress(request.getParameter("address"));
		employee.setGendar(request.getParameter("gendar"));
		
		String[] hobby=request.getParameterValues("hobbies");
		String myhobby="";	
		
		for(String str:hobby)
			myhobby=myhobby+str+",";
		
		String hobbies=myhobby.substring(0, myhobby.length()-1);
		employee.setHobbies(hobbies);
		
		double sal=Double.parseDouble(request.getParameter("salary"));
		employee.setSalary(sal);
		
		String dob=request.getParameter("empdob");
		Date empdob=new Date(dob);
		employee.setEmpDob(empdob);
		
		String depart=request.getParameter("department");
		employee.setDepartment(depart);
		
		System.out.println(employee);
		
		//Persist employee Object into DataBase
		loginService.saveEmployee(employee);
		
		//response.sendRedirect("SaveEmployeeServlet");
		request.getRequestDispatcher("pages/employee.html").forward(request, response);
		
	}

}













