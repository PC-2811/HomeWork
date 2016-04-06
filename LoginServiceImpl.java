package org.capgemini.service;

import java.util.ArrayList;

import org.capgemini.dao.LoginDao;
import org.capgemini.dao.LoginDaoImpl;
import org.capgemini.pojo.Employee;
import org.capgemini.pojo.LoginUser;

public class LoginServiceImpl implements LoginService {
	
	
	private LoginDao loginDao=new LoginDaoImpl();

	@Override
	public boolean isValidLogin(LoginUser loginUser) {
		
		/*boolean flag=false;
		
		if(loginUser.getUserName().equals("tom") && 
				loginUser.getUserPwd().equals("12345"))
			flag=true;
		*/
		return loginDao.isValidLogin(loginUser);
	}

	@Override
	public void saveEmployee(Employee employee) {
		loginDao.saveEmployee(employee);
	}

	@Override
	public ArrayList<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return loginDao.getAllEmployees();
	}

}
