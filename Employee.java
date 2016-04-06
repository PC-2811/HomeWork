package org.capgemini.pojo;

import java.util.Date;

public class Employee {
	
	private int empId;
	private String firstName;
	private String lastName;
	private String address;
	private String gendar;
	private String hobbies;
	private String department;
	private Date empDob;
	private double salary;
	
	
	public Employee(){}
	
	
	public Employee(int empId, String firstName, String lastName, String address, String gendar, String hobbies,
			String department, Date empDob, double salary) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.gendar = gendar;
		this.hobbies = hobbies;
		this.department = department;
		this.empDob = empDob;
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGendar() {
		return gendar;
	}
	public void setGendar(String gendar) {
		this.gendar = gendar;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getEmpDob() {
		return empDob;
	}
	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", gendar=" + gendar + ", hobbies=" + hobbies + ", department=" + department + ", empDob="
				+ empDob + ", salary=" + salary + "]";
	}
	
	
	
	
	
	
	
	
	
}
