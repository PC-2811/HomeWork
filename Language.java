package com.flp.fms.domain;


public class Language {

	//Private fields
	private int language_Id;
	private String language_Name;
	
	//No-argument constructor
	public Language(){}
	
	//constructor with fields
	public Language(int language_Id,String language_Name)
	{
		this.language_Id=language_Id;
		this.language_Name=language_Name;
	}

	//Getter and setter
	public int getLanguage_Id() {
		return language_Id;
	}

	public void setLanguage_Id(int language_Id) {
		this.language_Id = language_Id;
	}

	public String getLanguage_Name() {
		return language_Name;
	}

	public void setLanguage_Name(String language_Name) {
		this.language_Name = language_Name;
	}
	
    //toString Method
	@Override
	public String toString() {
		return "Language [language_Id=" + language_Id + ", language_Name=" + language_Name + "]";
	}

	
	
	
}

