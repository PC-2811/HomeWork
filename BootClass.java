package com.flp.fms.view;


import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

import com.flp.fms.domain.Film;
import java.util.Scanner;

import com.flp.fms.domain.Film;
import com.flp.fms.service.ActorServiceImpl;
import com.flp.fms.service.FilmServiceImpl;
import com.flp.fms.service.IFilmService;
public class BootClass {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		UserInteraction userinteraction=new UserInteraction();
		IFilmService filmService=new FilmServiceImpl();
		ActorServiceImpl actorService=new ActorServiceImpl();
		int option;
		String choice;
		boolean flag=false;
		
		do
		{
			menuSelection();
			System.out.println("Enter your option[1-6]=");
			option=sc.nextInt();
			switch(option)
			{
			case 1:
				Film film=userinteraction.addFilm(filmService.getLanguages(),filmService.getcategory(),actorService.getActors());
				filmService.addFilm(film);
				
				break;
			case 2:
				break;
				
			case 3:
				do
				{
				deleteMenuSelection();
				System.out.println("Enter your option=");
				int option1=sc.nextInt();
				
				switch(option1)
				{
				case 1:  System.out.println("Please enter film Id to delete film: ");
			              int filmId=sc.nextInt();
				         userinteraction.deleteFilmById(filmService.getAllFilms(),filmId);
				         break;
				case 2:
					System.out.println("Please enter film Title to delete: ");
				    String filmTitle=sc.next();
					userinteraction.deleteFilmByTitle(filmService.getAllFilms(),filmTitle);
					break;
				case 3:
					
					System.out.println("Please enter ratings to delete film: ");
				    int ratings=sc.nextInt();
					userinteraction.deleteFilmByRatings(filmService.getAllFilms(),ratings);
					break;
					    
				}
				System.out.println("Wish to do more delete?[y|n]");
				choice=sc.next();
				}while(choice.charAt(0)=='y'||choice.charAt(0)=='Y');
			      
				break;
			case 4:
				do{
					searchtMenuSelection();
					System.out.println("Enter your choice: ");
					int opt=sc.nextInt();
					
					switch(opt){
					case 1:
						System.out.println("Please enter film Id to search: ");
					    int filmId=sc.nextInt();
						userinteraction.searchFilmById(filmService.getAllFilms(),filmId);
						break;
						
					case 2:
						System.out.println("Please enter film Title to search: ");
					    String filmTitle=sc.next();
						userinteraction.searchFilmByTitle(filmService.getAllFilms(),filmTitle);
						break;
					case 3:
						
						System.out.println("Please enter ratings to search film: ");
					    int ratings=sc.nextInt();
						userinteraction.searchFilmByRatings(filmService.getAllFilms(),ratings);
						break;
						
					}
					System.out.println("Wish to do more search?[y|n]");
					choice=sc.next();
					}while(choice.charAt(0)=='y'||choice.charAt(0)=='Y');
				break;
			case 5:Map<Integer, Film>  film_lst= filmService.getAllFilms();
			     Collection<Film> lst=film_lst.values();
			    userinteraction.getAllFilm(lst);
				break;
			case 6:
				System.exit(0);
				break;
			
			}
		}while(!flag);

	}
	
	public static void menuSelection()
	{
		System.out.println("1.Add Film");
		System.out.println("2.Modify Film");
		System.out.println("3.Remove Film");
		System.out.println("4.Search Film");
		System.out.println("5.Get All Film");
		System.out.println("6.Exit");
	}
	
	public static void searchtMenuSelection(){
		System.out.println("1.Search by ID");
		System.out.println("2.Search by Title");
		System.out.println("3.Search by Ratings");
		
	}
	
	public static void deleteMenuSelection(){
		System.out.println("1.Delete by ID");
		System.out.println("2.Delete by Title");
		System.out.println("3.Delete by Ratings");
		
	}

}
