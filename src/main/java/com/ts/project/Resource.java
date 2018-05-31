package com.ts.project;

import javax.ws.rs.core.*;

import com.sun.jersey.multipart.FormDataParam;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/res1")
public class Resource {

	User user = new User();
	UserDAO userDAO = new UserDAO();

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getAll() {
		System.out.println("hai in get");
		// return profileDAO.getAll();
		User users = userDAO.getUser("chaitra");
		String Text = "";

		Text = "<table><thead><th>Name</th><th>Phone</th></thead>";
		Text += "<tr><td>" + users.getUname() + "</td> <td> " + users.getEmail() + "</td></tr>";
		Text += "</table>";
		return Text;
	}

	
}
