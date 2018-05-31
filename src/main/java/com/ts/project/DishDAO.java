package com.ts.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DishDAO {

	DAOUtility util = new DAOUtility();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	int status;

	public boolean insert(Dish dish) {
		sql = "insert into dish(dish_name ,dish_cuisine ,restaurant_id,imagepath) values(?,?,?,?)";
		try {
			con = util.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dish.getDish_name());
			ps.setString(2, dish.getDish_cuisine());
			ps.setInt(3, dish.getRestaurant_id());
			ps.setString(4, dish.getImagePath());
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

	public List<Dish> getDishes() {
		Dish c;
		List<Dish> dishes = new ArrayList<Dish>();
		sql = "select * from dish";
		try {
			con = util.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				c = new Dish();
				c.setDish_id(rs.getInt(1));
				c.setDish_name(rs.getString(2));
				c.setDish_cuisine(rs.getString(3));
				c.setRestaurant_id(rs.getInt(4));
				c.setImagePath(rs.getString(5));
				System.out.println(c);
				dishes.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(dishes);
		return dishes;
	}
	
	public List<Dish> getDish(int dish_id) {
		Dish dish = new Dish();
		List<Dish> dishes = new ArrayList<Dish>();
		sql = "select * from dish where restaurant_id=?";
		try {
			con = util.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, dish_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				dish.setDish_id(rs.getInt(1));
				dish.setDish_name(rs.getString(2));
				dish.setDish_cuisine(rs.getString(3));
				dish.setRestaurant_id(rs.getInt(4));
				dish.setImagePath(rs.getString(5));
				dishes.add(dish);
				System.out.println(dish);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(dish);
		return dishes;

	}
}
