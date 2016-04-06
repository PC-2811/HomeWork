package com.flp.fms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.flp.fms.dao.FilmDaoImplForList;
import com.flp.fms.dao.IFilmDao;
import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;

public class FilmServiceImpl implements IFilmService{
	

	private IFilmDao filmDao=new FilmDaoImplForList();

	@Override
	public List<Language> getLanguages() {
		
		return filmDao.getLanguages();
	}

	@Override
	public List<Category> getcategory() {
		
		return filmDao.getcategory();
		
	}
public int generate_Film_Id(){
		
		int filmId=0;
		
		//Verify filmId has been Duplicated or not
		do{
			double fid=Math.random()*1000;
			filmId=(int)fid;
		}while(checkDuplicateFilmId(filmId));
		
		
		return filmId;
	}

	private boolean checkDuplicateFilmId(int filmId) {
		Set<Integer> keys= getAllFilms().keySet();
		boolean flag=false;
		if(keys.isEmpty() || keys==null){
			flag= false;
		}else{
			for(Integer key:keys){
				if(key==filmId){
					flag=true;
					break;
				}
			}
		}
		
		return flag;
}

	@Override
	public Map<Integer, Film> getAllFilms() {

		return filmDao.getAllFilms();
		
	}

	@Override
	public void addFilm(Film film) {

		film.setFilm_Id(generate_Film_Id());
		filmDao.addFilm(film);
		
	}

/*	@Override
	public Map<Integer, Film> searchFilms() {
		
		return filmDao.searchFilms();
	}*/

}
