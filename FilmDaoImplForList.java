package com.flp.fms.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.flp.fms.domain.Actor;
import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;

public class FilmDaoImplForList implements IFilmDao{
	
	private Map<Integer,Film> film_Repository=new HashMap<>();
	@Override
	public List<Language> getLanguages() {
		List<Language> languages=new ArrayList<>();
		languages.add(new Language(1, "English"));
		languages.add(new Language(2, "Hindi"));
		languages.add(new Language(3, "Telegu"));
		languages.add(new Language(4, "Marati"));
		languages.add(new Language(5, "Kananta"));
		languages.add(new Language(6, "Tamil"));
		languages.add(new Language(7, "Malayalam"));
		
		
		return languages;
	}

	@Override
	public List<Category> getcategory() {
		
		List<Category> category=new ArrayList<>();
		category.add(new Category(1, "Comedy"));
		category.add(new Category(2, "Adventures"));
		category.add(new Category(3, "Action"));
		category.add(new Category(4, "Thriller"));
		category.add(new Category(5, "Romantic"));
		return category;
	}

	@Override
	public void addFilm(Film film) {
		
		film_Repository.put(film.getFilm_Id(), film);
	}

	@Override
	public Map<Integer, Film> getAllFilms() {
		
		return film_Repository;
	}

	

}
