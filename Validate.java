package com.flp.fms.util;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.flp.fms.domain.Language;

public class Validate {

	public static boolean isValidFilmTitle(String title)
	{
		return title.matches("[A-Za-z0-9,! ]+");      
	}
	public static boolean isValidReleaseDate(String  date)
	{
		return date.matches("[0123][0-9]-(jan|feb|mar|apr|may|june|july|aug|sept|oct|nov|dec)-[12][890]\\d{2}");
	}
	
	public static boolean isValidRentalDuration(String date)
	{
		return date.matches("[0123][0-9]-(jan|feb|mar|apr|may|june|july|aug|sept|oct|nov|dec)-[12][890]\\d{2}");
	}
	
	public static boolean isValidRatings(int ratings)
	{
		boolean flag=false;
		if(ratings>=1 && ratings<=5)
			flag=true;
			return flag;
		
	}
	
	public static boolean isValidLength(int length)
	{
		boolean flag=false;
		
		if(length>=0 && length<=1000)
			flag=true;
			return flag;
		
	}
	public static boolean checkDuplicateLanguage(List<Language> languages2, Language language1) {
             boolean flag=false;
		
		Iterator<Language> it= languages2.iterator();
		if(languages2.isEmpty())
		{
			flag=false;
		}else{
			while(it.hasNext()){
				Language language2=it.next();
				if(language1.equals(language2))
				{
					flag=true;
					break;
				}
			}
		}
		return flag;
	}
}

