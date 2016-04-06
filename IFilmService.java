package com.flp.fms.service;

import java.util.List;
import java.util.Map;

import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;

public interface IFilmService {
	
	
		public List<Language> getLanguages();
		public List<Category> getcategory();
		public void addFilm(Film film);
		public Map<Integer, Film> getAllFilms();
}
