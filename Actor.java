package com.flp.fms.domain;


public class Actor implements Comparable<Actor>{
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actor_Id;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		if (actor_Id != other.actor_Id)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	//private fields
	private int actor_Id;
	private String firstName;
	private String lastName;
	
	//No argument constructor
	public Actor(){}
	
	//constructor with fields
	public Actor(int actor_Id,String firstName,String lastName)
	{
		super();
		this.actor_Id=actor_Id;
		this.firstName=firstName;
		this.lastName=lastName;
		
	}

	//getters and setters
	public int getActor_Id() {
		return actor_Id;
	}

	public void setActor_Id(int actor_Id) {
		this.actor_Id = actor_Id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	//toString Method
	@Override
	public String toString() {
		return "Actor [actor_Id=" + actor_Id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	@Override
	public int compareTo(Actor actor) {
        
		if(this.getActor_Id()>actor.getActor_Id())
			return 1;
		else if(this.getActor_Id()<actor.getActor_Id())
			return -1;
		else  
		return 0;
	}
	
	


}
