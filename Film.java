package com.flp.fms.domain;


import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Film {
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (descreption == null) {
			if (other.descreption != null)
				return false;
		} else if (!descreption.equals(other.descreption))
			return false;
		if (film_Id != other.film_Id)
			return false;
		if (film_Title == null) {
			if (other.film_Title != null)
				return false;
		} else if (!film_Title.equals(other.film_Title))
			return false;
		if (languages == null) {
			if (other.languages != null)
				return false;
		} else if (!languages.equals(other.languages))
			return false;
		if (length != other.length)
			return false;
		if (original_Language == null) {
			if (other.original_Language != null)
				return false;
		} else if (!original_Language.equals(other.original_Language))
			return false;
		if (ratings != other.ratings)
			return false;
		if (release_Year == null) {
			if (other.release_Year != null)
				return false;
		} else if (!release_Year.equals(other.release_Year))
			return false;
		if (rental_Duration == null) {
			if (other.rental_Duration != null)
				return false;
		} else if (!rental_Duration.equals(other.rental_Duration))
			return false;
		if (Double.doubleToLongBits(replacement_Cost) != Double.doubleToLongBits(other.replacement_Cost))
			return false;
		if (special_Features == null) {
			if (other.special_Features != null)
				return false;
		} else if (!special_Features.equals(other.special_Features))
			return false;
		return true;
	}

	//private fields
	private int film_Id;
	private String descreption;
	private String film_Title;
    private Date release_Year;
	private List<Language> languages;
	private Language original_Language;
	private Date rental_Duration;
	private int length;
	private double replacement_Cost;
	private int ratings;
	private String special_Features;
	private Set<Actor> actors;
	private Category category;
	
	//No argument constructor
	public Film(){}

	//Connstructor with fields
	public Film(int film_Id, String descreption, String film_Title, Date release_Year, List<Language> languages,
			Language original_Language, Date rental_Duration, int length, double replacement_Cost, int ratings,
			String special_Features, Set<Actor> actors, Category category) {
		super();
		this.film_Id = film_Id;
		this.descreption = descreption;
		this.film_Title = film_Title;
		this.release_Year = release_Year;
		this.languages = languages;
		this.original_Language = original_Language;
		this.rental_Duration = rental_Duration;
		this.length = length;
		this.replacement_Cost = replacement_Cost;
		this.ratings = ratings;
		this.special_Features = special_Features;
		this.actors = actors;
		this.category = category;
	}

	//getters and setters
	public int getFilm_Id() {
		return film_Id;
	}

	public void setFilm_Id(int film_Id) {
		this.film_Id = film_Id;
	}

	public String getDescreption() {
		return descreption;
	}

	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}

	public String getFilm_Title() {
		return film_Title;
	}

	public void setFilm_Title(String film_Title) {
		this.film_Title = film_Title;
	}

	public Date getRelease_Year() {
		return release_Year;
	}

	public void setRelease_Year(Date release_Year) {
		this.release_Year = release_Year;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public Language getOriginal_Language() {
		return original_Language;
	}

	public void setOriginal_Language(Language original_Language) {
		this.original_Language = original_Language;
	}

	public Date getRental_Duration() {
		return rental_Duration;
	}

	public void setRental_Duration(Date rental_Duration) {
		this.rental_Duration = rental_Duration;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacement_Cost() {
		return replacement_Cost;
	}

	public void setReplacement_Cost(double replacement_Cost) {
		this.replacement_Cost = replacement_Cost;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public String getSpecial_Features() {
		return special_Features;
	}

	public void setSpecial_Features(String special_Features) {
		this.special_Features = special_Features;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((descreption == null) ? 0 : descreption.hashCode());
		result = prime * result + film_Id;
		result = prime * result + ((film_Title == null) ? 0 : film_Title.hashCode());
		result = prime * result + ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + length;
		result = prime * result + ((original_Language == null) ? 0 : original_Language.hashCode());
		result = prime * result + ratings;
		result = prime * result + ((release_Year == null) ? 0 : release_Year.hashCode());
		result = prime * result + ((rental_Duration == null) ? 0 : rental_Duration.hashCode());
		long temp;
		temp = Double.doubleToLongBits(replacement_Cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((special_Features == null) ? 0 : special_Features.hashCode());
		return result;
	}
   
	//toString method
	@Override
	public String toString() {
		return "Film [film_Id=" + film_Id + ", descreption=" + descreption + ", film_Title=" + film_Title
				+ ", release_Year=" + release_Year + ", languages=" + languages + ", original_Language="
				+ original_Language + ", rental_Duration=" + rental_Duration + ", length=" + length
				+ ", replacement_Cost=" + replacement_Cost + ", ratings=" + ratings + ", special_Features="
				+ special_Features + ", actors=" + actors + ", category=" + category + "]";
	}
	
	
	

}
