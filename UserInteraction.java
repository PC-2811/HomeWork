package com.flp.fms.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.flp.fms.domain.Actor;
import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;
import com.flp.fms.util.Validate;

public class UserInteraction {
	Scanner sc=new Scanner(System.in);

	//Return fully qualified film object
	public Film addFilm(List<Language> languages,List<Category> categories,Set<Actor> actors)
	{
		Film film=new Film();
	
		//Enter Description
				System.out.println("Enter Description");
				String descreption=sc.nextLine();
				film.setDescreption(descreption);
		
		//Film_Title Validation
		String filmName;
		boolean flag=false;
		
		do
		{
			System.out.println("Enter Film Name=");
			filmName=sc.nextLine();
			flag=Validate.isValidFilmTitle(filmName);
			if(!flag)
			   System.out.println("Invalid Film Name.Please Enter valid Film Name");	
				
		}while(!flag);
		film.setFilm_Title(filmName);
		
		
		
		//Release Date Validation
		String releaseDate;
		Date release_Date=null;
		boolean date_flag=false;
		do
		{
		do
		{
			System.out.println("Enter Release Date=");
			releaseDate=sc.nextLine();
			flag=Validate.isValidReleaseDate(releaseDate);
			if(!flag)
				System.out.println("Please enter date in this Format(dd-MMM-yyyy)!");
				
		}while(!flag);
		
		Date today=new Date();
		release_Date=new Date(releaseDate);
	    if(release_Date.before(today)||release_Date.equals(today))
	    	date_flag=true;
	    if(!date_flag)
			System.out.println("Invalid Date! Date should be current date or Past Date!");
		}while(!date_flag);
		film.setRelease_Year(release_Date);
		
		//Validation for Rental Duration
		
		String rentalDuration;
		Date rental_Duration=null;
		boolean date_flag1=false;
		do
		{
		do
		{
			System.out.println("Enter Rental Duration=");
			rentalDuration=sc.nextLine();
			flag=Validate.isValidRentalDuration(rentalDuration);
			if(!flag)
				System.out.println("Please enter date in this Format(dd-MMM-yyyy)!");
				
		}while(!flag);
		
		//Date today=new Date();
		rental_Duration=new Date(rentalDuration);
	    if(rental_Duration.after(release_Date))
	    	date_flag1=true;
	    if(!date_flag1)
			System.out.println("Invalid Date! Rental duration should be greater!");
		}while(!date_flag1);
		film.setRental_Duration(rental_Duration);
		
		//Validation for Ratings
		int ratings;
		do
		{
			System.out.println("Enter Ratings=");
			ratings=sc.nextInt();
			flag=Validate.isValidRatings(ratings);
			if(!flag)
			   System.out.println("Invalid Ratings.Please Enter ratings between 1 to 5");	
				
		}while(!flag);
		film.setRatings(ratings);
		
		
		
	
				
		
		//Validation for length
		int length;
		do
		{
			System.out.println("Enter length=");
			length=sc.nextInt();
			flag=Validate.isValidLength(length);
			if(!flag)
			   System.out.println("Invalid Ratings.Please Enter valid length");	
				
		}while(!flag);
		film.setLength(length);
		
		//Enter Replacement cost
		System.out.println("Enter replacement cost=");
		double replacement_Cost=sc.nextDouble();
		film.setReplacement_Cost(replacement_Cost);
		
		////Choose Language
		System.out.println("Choose Original Language");
		Language language= addLanguage(languages);
		film.setOriginal_Language(language);
		
		
		//Add all languages
				List<Language> languages2=new ArrayList<>();
				String choice;
				boolean flag_langs;
				do{
					System.out.println("Choose All Languages for the Film:");
					Language language1= addLanguage(languages);
					
					
					flag_langs=Validate.checkDuplicateLanguage(languages2, language1);
					if(!flag_langs)
						languages2.add(language1);
					else
						System.out.println("Language already Exists. Please try other languages!");
					
					
					System.out.println("Wish to add More Languages?[y|n]");
					choice=sc.next();
				}while(choice.charAt(0)=='y'||choice.charAt(0)=='Y');
				film.setLanguages(languages2);
				
				
				
		
	////Choose Category
				System.out.println("Choose Category");
				Category category= selectCategory(categories);
				film.setCategory(category);
				
			//Choose Actors from list for the film
				TreeSet<Actor> actors1=new TreeSet<>();
				
				String choice1=null;
				boolean flag_actors;
				do
				{
					System.out.println("Choose all actors from list");
					 Actor actors2=addActors(actors);
					actors1.add(actors2);
					
					System.out.println("Wish to add More Actors?[y|n]");
					choice1=sc.next();
				}while(choice1.charAt(0)=='y'||choice1.charAt(0)=='Y');
				film.setActors(actors1);
				
				//Enter special features
				System.out.println("Enter Special Features=");
				String special_Features=sc.next();
				film.setSpecial_Features(special_Features);
				
				

		return film;
		
	}

	//Choose Valid Actor Object from the list of Actors
	   private Actor addActors(Set<Actor> actors) {

        Actor sel_Actors=null;
        boolean flag_actor1=false;
        for(Actor actor:actors)
        	System.out.println(actor.getActor_Id()+"\t"+actor.getFirstName()+"\t"+actor.getLastName());
        
        System.out.println("Choose the Actor:");
		int option=sc.nextInt();
		
		flag_actor1=false;
		do
		{
		for(Actor actor:actors)
		{
			if(option==actor.getActor_Id())
			{
				sel_Actors=actor;
				flag_actor1=true;
				break;
			}
		}
		//Print Error Message
				if(!flag_actor1)
					System.out.println("Please select valid Actor Id");
				}while(!flag_actor1);	
				
		return sel_Actors;
	}

	//Choose valid category object from the list of category
		private Category selectCategory(List<Category> categories) {
		Category sel_category=null;
		boolean flag;
		do{	
			//Print category Details
			for(Category category:categories)
				System.out.println(category.getCategory_Id() + "\t" + category.getCategory_Name());
			
			System.out.println("Choose the category:");
			int option=sc.nextInt();
			
			flag=false;
			
			//Check the category Object
			for(Category category: categories)
			{
				if(option==category.getCategory_Id())
				{
					sel_category=category;
					flag=true;
					break;
				}
			}
			
			//Print Error Message
			if(!flag)
				System.out.println("Please select valid Category Id");
		}while(!flag);	
		
		return sel_category;
	}
		
	


		//Choose Valid Language Object from the list of Languages
		public Language addLanguage(List<Language>  languages){
			
			Language sel_language=null;
			boolean flag;
			do{	
				//Print Langauge Details
				for(Language language:languages)
					System.out.println(language.getLanguage_Id() + "\t" + language.getLanguage_Name());
				
				System.out.println("Choose the Language:");
				int option=sc.nextInt();
				
				flag=false;
				
				//Check the Language Object
				for(Language language: languages)
				{
					if(option==language.getLanguage_Id())
					{
						sel_language=language;
						flag=true;
						break;
					}
				}
				
				//Print Error Message
				if(!flag)
					System.out.println("Please select valid Language Id");
			}while(!flag);	
			
			return sel_language;
			
			
			
		}
		
		//Get All Film 
		public void getAllFilm(Collection<Film> lst) {
			
			System.out.println("Film Id"+"\t"+"Film Title"+"\t"+"Release Year"+"\t\t\t\t"+"Rental Duration"+"\t\t\t"+"Repalcement Cost"+"\t\t"+"Ratings"+"\t\t"+"Special Features"+"\t\t"+"Languages"+"\t\t\t"+"Actors"+"\t\t\t"+"Category");
			
			for(Film film:lst){
				String languages="";
				String actors="";
				
				for(Language language:film.getLanguages())
					languages=languages+language.getLanguage_Name()+",";
				
				for(Actor actor:film.getActors())
					actors=actors+actor.getFirstName()+" "+actor.getLastName();
				
				
				
				
				
				System.out.println(film.getFilm_Id()+"\t"+film.getFilm_Title()+"\t\t"+film.getRelease_Year()+"\t\t"+film.getRental_Duration()+"\t\t"+film.getReplacement_Cost()+"\t\t\t"+film.getRatings()+"\t\t"+film.getSpecial_Features()+"\t\t\t\t"+languages+"\t\t\t"+actors+"\t\t"+film.getCategory());
			
				
				}
			
		}
		
	//search film by id
		public void searchFilmById(Map<Integer, Film> film_lst1,int filmId)
		{
			//Map<Integer, Film>  film_lst1 = (Map<Integer, Film>) lst;
			Set<Integer> keys=film_lst1.keySet();
			Iterator<Integer> itr=keys.iterator();
			if(film_lst1.containsKey(filmId)){
			while(itr.hasNext()){
				if(filmId==itr.next())
				{
					System.out.println(film_lst1.get(filmId));
				}
			}
			}
			else
				System.out.println("Key not found!!");
		}
		
		
		//search film by title
		public void searchFilmByTitle(Map<Integer,Film> filmlist,String filmTitle)
		{
			
			
			Set<Integer> keys=filmlist.keySet();
			Iterator<Integer> itr=keys.iterator();
			while(itr.hasNext()){
			      Integer key=itr.next();
				if(filmTitle.equals(filmlist.get(key).getFilm_Title()))
				{
					System.out.println(filmlist.get(key));
				}
			
			
			else
				System.out.println("Key not found!!");
		}
		}	
			//search film by ratings
			
			
			public void searchFilmByRatings(Map<Integer,Film> filmlist,int ratings)
			{
				
				
				Set<Integer> keys=filmlist.keySet();
				Iterator<Integer> itr=keys.iterator();
				while(itr.hasNext()){
				      Integer key=itr.next();
					if(ratings==(filmlist.get(key).getRatings()))
					{
						System.out.println(filmlist.get(key));
					}
				
				
				else
					System.out.println("Key not found!!");
			}
				
			}	
			
			//delete film by id
				
				public void deleteFilmById(Map<Integer, Film> film_lst2,int filmId)
				{
					//Map<Integer, Film>  film_lst1 = (Map<Integer, Film>) lst;
					Set<Integer> keys=film_lst2.keySet();
					Iterator<Integer> itr=keys.iterator();
					if(film_lst2.containsKey(filmId)){
					while(itr.hasNext()){
						if(filmId==itr.next())
						{
							itr.remove();
							//System.out.println("Remove="+film_lst2.get(filmId));
							break;
						}
					}
					}
					else
						System.out.println("Key not found!!");
				}
				
				
          //delete film by title
				public void deleteFilmByTitle(Map<Integer,Film> filmlist,String filmTitle)
				{
					
					
					Set<Integer> keys=filmlist.keySet();
					Iterator<Integer> itr=keys.iterator();
					while(itr.hasNext()){
					      Integer key=itr.next();
						if(filmTitle.equals(filmlist.get(key).getFilm_Title()))
						{
							itr.remove();
							//System.out.println("Remove="+filmlist.get(key));
							break;
						}
					
					
					else
						System.out.println("Key not found!!");
				}
				}		
				
				//delete film by ratings
				
				
				public void deleteFilmByRatings(Map<Integer,Film> filmlist,int ratings)
				{
					
					
					Set<Integer> keys=filmlist.keySet();
					Iterator<Integer> itr=keys.iterator();
					while(itr.hasNext()){
					      Integer key=itr.next();
						if(ratings==(filmlist.get(key).getRatings()))
						{
							itr.remove();
							//System.out.println("Remove="+filmlist.get(key));
							break;
						}
					
					
					else
						System.out.println("Key not found!!");
				}
					
				}	
				
	
		}
	

