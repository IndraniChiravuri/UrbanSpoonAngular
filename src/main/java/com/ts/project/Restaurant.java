package com.ts.project;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Restaurant {
	int res_id;
	String res_name;
	String res_pwd;
	String registration_name;
	String location;
	String imagepath;

	static int counter = 3;
	public Restaurant() {
		
	}

	public Restaurant(int res_id, String res_name, String res_pwd, String registration_name, String location,
			String imagepath) {
		super();
		this.res_id = counter++;

		this.res_name = res_name;
		this.res_pwd = res_pwd;
		this.registration_name = registration_name;
		this.location = location;
		this.imagepath = imagepath;
	}

	public Restaurant(String resname, String password, String regname, String location2) {
		
		this.res_name = resname;
		this.res_pwd = password;
		this.registration_name = regname;
		this.location = location2;
	}

	public int getRes_id() {
		return res_id;
	}

	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}

	public String getRes_name() {
		return res_name;
	}

	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}

	public String getRes_pwd() {
		return res_pwd;
	}

	public void setRes_pwd(String res_pwd) {
		this.res_pwd = res_pwd;
	}

	public String getRegistration_name() {
		return registration_name;
	}

	public void setRegistration_name(String registration_name) {
		this.registration_name = registration_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

}
