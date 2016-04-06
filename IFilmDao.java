package com.flp.fms.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.flp.fms.domain.Actor;
import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;

public interface IFilmDao {
	
	public List<Language> getLanguages();
	public List<Category> getcategory();
	public void addFilm(Film film);
	public Map<Integer, Film> getAllFilms();
	
}
