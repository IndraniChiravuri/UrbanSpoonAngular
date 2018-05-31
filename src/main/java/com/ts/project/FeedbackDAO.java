package com.ts.project;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FeedbackDAO {

	DAOUtility util = new DAOUtility();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	int status;

	public boolean insert(Feedback feedback) {
		sql = "insert into feedback(dish_id,name,email,rating,comments) values(?, ?,?, ?, ?)";
		try {
			con = util.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, feedback.getDish_id());
			ps.setString(2, feedback.getName());
			ps.setString(3, feedback.getEmail());
			ps.setString(4, feedback.getRating());
			ps.setString(5, feedback.getComments());
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
}
