package com.ts.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	DAOUtility util = new DAOUtility();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	int status;

	public boolean insert(User user) {
		sql = "insert into user(name,password,email,phonenumber) values(?,?,?,?)";
		try {
			con = util.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPwd());
			ps.setString(4, user.getPhno());
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
	public User getUser(String email) {
		User user = new User();
		sql = "select * from user where email = ?";
		try {
			con = util.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setUser_id(rs.getInt(1));
				user.setUname(rs.getString(2));
				
				user.setEmail(rs.getString(3));
				user.setPwd(rs.getString(4));
				user.setPhno(rs.getString(5));
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(user);
		return user;
		
	}
	public int loginValidation(String email, String password) {
		con = util.getConnection();
		
		try {
			ps = con.prepareStatement("select * from user where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				if(rs.getString(4).equals(password)){
					System.out.println("true");
					return 1;
				}
			}
		
		} catch (Exception e) {
			
			System.out.println(e.toString());
		}
		return 0;

	}

	
}
