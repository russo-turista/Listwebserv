package com.listwebserv.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.listwebserv.domain.User;
import com.listwebserv.service.UserService;

@Controller
public class UsersController {
	
	private  final Logger logger = Logger.getLogger(UsersController.class);
	
	@Autowired
	private User user;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/addUser")
	public String setUser(ModelMap model) {
		model.addAttribute("user", user);
		
		System.out.println("AddEUser!!!!!!!!!");
		return "addUser";
	}
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String getUser(ModelMap model, @ModelAttribute("user") User user) {
		System.out.println("user name: " + user.getName());
		System.out.println("user login: " + user.getLogin());
		System.out.println("user password: " + user.getPassword());
		System.out.println("user active: " + user.getActive());
		userService.setUser(user);
		return "addUser";
	}
}
