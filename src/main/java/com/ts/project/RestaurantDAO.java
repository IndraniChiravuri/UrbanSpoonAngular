package com.ts.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO {

	DAOUtility util = new DAOUtility();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	int status;

	public boolean insert(Restaurant restaurant) {
		sql = "insert into restaurant(restaurant_name, password, registration_name, location) values(?, ?, ?, ?)";
		try {
			con = util.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, restaurant.getRes_name());
			ps.setString(2, restaurant.getRes_pwd());
			ps.setString(3, restaurant.getRegistration_name());
			ps.setString(4, restaurant.getLocation());
			// ps.setString(5, restaurant.getImagepath());
			status = ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (status > 0) {
			System.out.println("Success");
		}

		return false;
	}

	public List<Restaurant> getAll() {
		Restaurant c;
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		sql = "select * from restaurant";
		try {
			con = util.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				c = new Restaurant();
				c.setRes_id(rs.getInt(1));
				c.setRes_name(rs.getString(2));
				c.setRes_pwd(rs.getString(3));
				c.setRegistration_name(rs.getString(4));
				c.setLocation(rs.getString(5));
				c.setImagepath(rs.getString(6));
				System.out.println(c);
				restaurants.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(restaurants);
		return restaurants;
	}

	public Restaurant getRestaurant(String registration_name) {
		Restaurant restaurant = new Restaurant();
		sql = "select * from restaurant where registration_name = ?";
		try {
			con = util.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, registration_name);
			rs = ps.executeQuery();
			if (rs.next()) {
				restaurant.setRes_id(rs.getInt(1));
				restaurant.setRes_name(rs.getString(2));
				restaurant.setRes_pwd(rs.getString(3));
				restaurant.setRegistration_name(rs.getString(4));
				restaurant.setLocation(rs.getString(5));
				restaurant.setImagepath(rs.getString(6));
				System.out.println(restaurant);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(restaurant);
		return restaurant;

	}

	public int loginValidation(String email, String password) {
		con = util.getConnection();
		System.out.println("in login validation");
		try {
			ps = con.prepareStatement("select * from restaurant where registration_name=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				if (rs.getString(3).equals(password)) {
					System.out.println("true");
					return rs.getInt(1);
				}
			}

		} catch (Exception e) {

			System.out.println(e.toString());
		}
		System.out.println("false");
		return -1;

	}

}
