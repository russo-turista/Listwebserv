package com.listwebserv.controllers;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.listwebserv.logic.*;

@Controller

public class UserController {
	

	/**
	 * Static list of users to simulate Database
	 */
	private static List<User> userList = new ArrayList<User>();

	// Initialize the list with some data for index screen
	static {
		userList.add(new User("Bill", "Gates"));
		userList.add(new User("Steve", "Jobs"));
		userList.add(new User("Larry", "Page"));
		userList.add(new User("Sergey", "Brin"));
		userList.add(new User("Larry", "Ellison"));
	}

	/**
	 * Saves the static list of users in model and renders it via freemarker
	 * template.
	 * 
	 * @param model
	 * @return The index view (FTL)
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(@ModelAttribute("model") ModelMap model) {

		model.addAttribute("userList", userList);

		return "index";
	}

	/**
	 * Add a new user into static user lists and display the same into FTL via
	 * redirect
	 * 
	 * @param user
	 * @return Redirect to /index page to display user list
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add( @ModelAttribute("model") ModelMap model, @RequestParam(value = "firstname") String firstname , @RequestParam (value = "lastname") String lastname) {

		/*
		 * if (null != user && null != user.getFirstname() && null !=
		 * user.getLastname() && !user.getFirstname().isEmpty() &&
		 * !user.getLastname().isEmpty()) {
		 */
		model.addAttribute("userList", userList);
		if (firstname != null && lastname != null) {
			synchronized (userList) {
				userList.add(new User(lastname, firstname));
				System.out.println("userList.size= " + userList.size());
			}
			
		}
		
		return "index";
	}

}
