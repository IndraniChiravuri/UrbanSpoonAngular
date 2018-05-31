package com.ts.project;

import javax.ws.rs.core.*;

//import org.glassfish.jersey.media.multipart.FormDataParam;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import javax.ws.rs.Produces;

@Path("/api/customer/")
public class WebController {

	Restaurant restaurant = new Restaurant();
	RestaurantDAO restaurantDAO = new RestaurantDAO();
	Dish dish = new Dish();
	DishDAO dishDAO = new DishDAO();
	UserDAO userDAO = new UserDAO();
	User user = new User();
	FeedbackDAO f = new FeedbackDAO();
	Feedback feedback = new Feedback();
	@GET
	@Path("/getRestaurants")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Restaurant> getAll() {
		List<Restaurant> p = new ArrayList<Restaurant>();
		p = restaurantDAO.getAll();
		
		return p;
	}

	@GET
	@Path("/getRestaurants/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Restaurant getCustomer(@PathParam(value = "id") String id) {
		return restaurantDAO.getRestaurant(id);
	}

	@GET
	@Path("/getDishes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Dish> getDishes() {
		List<Dish> p = new ArrayList<Dish>();
		p = dishDAO.getDishes();
		return p;
	}

	@GET
	@Path("/getDishes/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Dish> getDish(@PathParam(value = "id") int id) {
		return dishDAO.getDish(id);
	}

	@POST
	@Path("/signup")
	public Response signup(@FormParam("uname") String username, @FormParam("email") String email,
			@FormParam("password") String password, @FormParam("phno") String phno) {
		user = new User(username, email, password, phno);
		boolean b = userDAO.insert(user);
		System.out.println(b);
		return Response.ok().entity("{Success}").header("Access-Control-Allow-Origin", "*").build();
	}
	
	@POST
	@Path("/res/signup")
	public Response ressignup(@FormParam("rname") String resname, @FormParam("password") String password,
			@FormParam("regname") String regname, @FormParam("location") String location,@FormParam("img") String img) {
		System.out.println(resname+password+location+img);
		restaurant = new Restaurant(resname, password, regname, location);
		boolean b = restaurantDAO.insert(restaurant);
		System.out.println(b);
		return Response.ok().entity("{Success}").header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Path("/getUsers/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam(value = "name") String email) {
		return userDAO.getUser(email);
	}

	@POST
	@Path("/usignin")
	@Produces(MediaType.TEXT_PLAIN)
	public String signIn(@FormParam("email") String email, @FormParam("password") String password) {
		int b = userDAO.loginValidation(email, password);
		//return Response.ok().entity("{Success}").header("Access-Control-Allow-Origin", "*").build();
		if(b>0)
			return b+"";
		else
			return "false";
	
	}
	
	@POST
	@Path("/signin")
	@Produces(MediaType.TEXT_PLAIN)
	public String usignIn(@FormParam("email") String email, @FormParam("password") String password) {
		int b = restaurantDAO.loginValidation(email, password);
		//return Response.ok().entity("{Success}").header("Access-Control-Allow-Origin", "*").build();
		if(b>0)
			return b+"";
		else
			return "false";
	
	}

	@POST
	@Path("/feedback")
	
	public Response feedback(@FormParam("name") String name, @FormParam("email") String email,@FormParam("rating") String rating,@FormParam("comments") String comments) {
		int dish_id = 1;
		feedback = new Feedback(dish_id,name,email,rating,comments);
		boolean b = f.insert(feedback);
		return Response.ok().entity("{Success}").header("Access-Control-Allow-Origin", "*").build();
	}
	@POST
	@Path("/addDish")
	public Response adddDish(@FormParam("uname") String dish_name, @FormParam("cuisine") String cuisine,
			@FormParam("img") String img) {
		int dish_id = 4;
		int res_id = 1;
		System.out.println(img);
		dish = new Dish(dish_id,dish_name, cuisine,res_id, img);
		boolean b = dishDAO.insert(dish);
		System.out.println(b);
		return Response.ok().entity("{Success}").header("Access-Control-Allow-Origin", "*").build();
	}


}
