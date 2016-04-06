package org.capgemini.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.capgemini.pojo.Employee;
import org.capgemini.pojo.LoginUser;



public class LoginDaoImpl implements LoginDao{

	@Override
	public boolean isValidLogin(LoginUser loginUser) {
		boolean flag=false;
		Connection con=getConnection();
		String sql="select * from userlogin where username=? and userpassword=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, loginUser.getUserName());
			pst.setString(2, loginUser.getUserPwd());
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
				flag=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return flag;
	}

	
	public Connection getConnection(){
		
		Connection connection=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/CAP","root","admin");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return connection;
	}


	@Override
	public void saveEmployee(Employee employee) {
		
		Connection con=getConnection();
		
		String sql="insert into employee(firstName,lastName,address,gendar,hobbies,salary,empdob,department)"
											+ "	 values(?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, employee.getFirstName());
			pst.setString(2, employee.getLastName());
			pst.setString(3, employee.getAddress());
			pst.setString(4, employee.getGendar());
			pst.setString(5, employee.getHobbies());
			pst.setDouble(6, employee.getSalary());
			pst.setDate(7,new Date(employee.getEmpDob().getTime()));
			pst.setString(8, employee.getDepartment());
			
			
			int count=pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> employees=new ArrayList<>();
		
		String sql="select * from employee";
		Connection con=getConnection();
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()){
				Employee emp=new Employee();
				
				emp.setEmpId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setAddress(rs.getString(4));
				emp.setGendar(rs.getString(5));
				emp.setHobbies(rs.getString(6));
				emp.setSalary(rs.getDouble(7));
				
				//dd-mmm-yyyy
				emp.setEmpDob(rs.getDate(8).valueOf(rs.getDate(8).toString()));
				
				emp.setDepartment(rs.getString(9));
				
				
				//Adding the employee into arraylist
				employees.add(emp);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return employees;
	}
	
	
}
