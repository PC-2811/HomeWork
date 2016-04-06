
package com.flp.fms.domain;

public class Category {
	
	//private fields
	private int category_Id;
	private String category_Name;
	
	//No argument constructor
	public Category(){}
	
	//Constructor with fields
	public Category(int category_Id,String category_Name)
	{
		this.category_Id=category_Id;
		this.category_Name=category_Name;
	}

	//getters and setters
	public int getCategory_Id() {
		return category_Id;
	}

	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}

	public String getCategory_Name() {
		return category_Name;
	}

	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}

	//toString Method
	@Override
	public String toString() {
		return "Category [category_Id=" + category_Id + ", category_Name=" + category_Name + "]";
	}

	
	
	
	

}
