package org.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.capgemini.pojo.Employee;
import org.capgemini.service.LoginService;
import org.capgemini.service.LoginServiceImpl;


public class ListAllEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginService loginService=new LoginServiceImpl();
		
		ArrayList<Employee> employees=loginService.getAllEmployees();
		
		
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<head>ListAll Employee</head>"
				+ "<body>"
				+ "<table>"
				+ "<tr>"
				+ "<th>Employee Id</th>"
				+ "<th>FirstName</th>"
				+ "<th>LastName</th>"
				+ "<th>Address</th>"
				+ "<th>Gender</th>"
				+ "<th>Hobbies</th>"
				+ "<th>Salary</th>"
				+ "<th>Date Of Birth</th>"
				+ "<th>Department</th>"
				+ "</tr>");
		
			for(Employee emp:employees){
				out.println("<tr>");
				out.println("<td>"+emp.getEmpId()+"</td>");
				out.println("<td>"+emp.getFirstName()+"</td>");
				out.println("<td>"+emp.getLastName()+"</td>");
				out.println("<td>"+emp.getAddress()+"</td>");
				out.println("<td>"+emp.getGendar()+"</td>");
				out.println("<td>"+emp.getHobbies()+"</td>");
				out.println("<td>"+emp.getSalary()+"</td>");
				out.println("<td>"+emp.getEmpDob()+"</td>");
				out.println("<td>"+emp.getDepartment()+"</td>");
				out.println("</tr>");
			}
				out.println("</table></body>");
	
				out.println("</html>");
		
		
		
		
		
		
		
		
	 
	}

}
