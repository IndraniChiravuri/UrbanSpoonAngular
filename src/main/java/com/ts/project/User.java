package com.ts.project;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", uname=" + uname + ", pwd=" + pwd + ", email=" + email + ", phno=" + phno
				+ "]";
	}

	int user_id;
	String uname;
	String pwd;
	String email;
	String phno;


	
	public User( String uname, String pwd, String email, String phno) {
		//super();
		//this.user_id = user_id;
		this.uname = uname;
		this.pwd = pwd;
		this.email = email;
		this.phno = phno;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

}
