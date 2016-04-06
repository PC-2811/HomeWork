package com.flp.fms.service;

import java.util.Set;
import java.util.TreeSet;

import com.flp.fms.dao.ActorDaoImplForList;
import com.flp.fms.dao.FilmDaoImplForList;
import com.flp.fms.dao.IActorDao;
import com.flp.fms.dao.IFilmDao;
import com.flp.fms.domain.Actor;

public class ActorServiceImpl implements IActorService{

	private IActorDao actorDao=new ActorDaoImplForList();
	@Override
	public Set<Actor> getActors() {
		// TODO Auto-generated method stub
		return actorDao.getActors();
	}
	
	

}
