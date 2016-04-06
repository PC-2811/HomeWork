package org.capgemini.service;

import java.util.ArrayList;

import org.capgemini.pojo.Employee;
import org.capgemini.pojo.LoginUser;

public interface LoginService {
	
	public boolean isValidLogin(LoginUser loginUser);
	public void saveEmployee(Employee employee);
	public ArrayList<Employee> getAllEmployees();
}
