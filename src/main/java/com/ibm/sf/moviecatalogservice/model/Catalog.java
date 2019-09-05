package com.ibm.sf.moviecatalogservice.model;

public class Catalog {
	
	private String title;
	private String overview;
	private int rating;
	
	
	public Catalog() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public Catalog(String title, String overview, int rating) {
		super();
		this.title = title;
		this.overview = overview;
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

}
