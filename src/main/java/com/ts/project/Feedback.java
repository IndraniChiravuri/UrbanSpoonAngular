package com.ts.project;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Feedback {
	int id;
	int dish_id;
	
	String name;
	String email;
	String rating;
	String comments;
	static int c = 1;
	public Feedback() {
	
	}
	public Feedback(int id, int dish_id, String name, String email, String rating, String comments) {

		this.id = c++;
		this.dish_id = dish_id;
		this.name = name;
		this.email = email;
		this.rating = rating;
		this.comments = comments;
	}
	public Feedback( int dish_id, String name, String email, String rating, String comments) {

		this.dish_id = dish_id;
		this.name = name;
		this.email = email;
		this.rating = rating;
		this.comments = comments;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDish_id() {
		return dish_id;
	}
	public void setDish_id(int dish_id) {
		this.dish_id = dish_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

}
