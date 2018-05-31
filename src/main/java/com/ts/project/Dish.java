package com.ts.project;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dish {
	int dish_id;
	String dish_name;
	String dish_cuisine;
	int restaurant_id;
	String imagepath;
	
	public Dish() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Dish(int dish_id2, String dish_name2, String cuisine, int res_id, String img) {
		this.dish_id=dish_id2;
		this.dish_name=dish_name2;
		this.dish_cuisine=cuisine;
		this.restaurant_id=res_id;
		this.imagepath=img;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public String getDish_cuisine() {
		return dish_cuisine;
	}

	@Override
	public String toString() {
		return "Dish [dish_id=" + dish_id + ", dish_name=" + dish_name + ", dish_cuisine=" + dish_cuisine
				+ ", restaurant_id=" + restaurant_id + ", imagepath=" + imagepath + "]";
	}

	public void setDish_cuisine(String dish_cuisine) {
		this.dish_cuisine = dish_cuisine;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public int getDish_id() {
		return dish_id;
	}

	public void setDish_id(int dish_id) {
		this.dish_id = dish_id;
	}

	public String getDish_name() {
		return dish_name;
	}

	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}

	public void setImagePath(String imagepath) {
		// TODO Auto-generated method stub
		this.imagepath=imagepath;
	}
	public String getImagePath() {
		// TODO Auto-generated method stub
		return this.imagepath;
	}

}
