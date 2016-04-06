package com.flp.fms.dao;

import java.util.HashSet;
import java.util.Set;

import com.flp.fms.domain.Actor;

public class ActorDaoImplForList implements IActorDao{

	@Override
	public Set<Actor> getActors() {
		
		Set<Actor> actors=new HashSet<>();
		actors.add(new Actor(001,"Hrithik","Roshan"));
		actors.add(new Actor(102,"Shahrukh","Khan"));
		actors.add(new Actor(103,"Salman","Khan"));
		actors.add(new Actor(104,"varun","Dhavan"));
		actors.add(new Actor(105,"Aditya","Kapoor"));
		return actors;
	}
}
