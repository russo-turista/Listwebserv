package com.listwebserv.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.listwebserv.domain.Server;
import com.listwebserv.domain.User;
import com.listwebserv.service.ServersService;
import com.listwebserv.service.UserService;

@Controller
public class UsersController {
	
	private  final Logger logger = Logger.getLogger(UsersController.class);
	
	@Autowired
	private User user;
	@Autowired
	private Server servers;
	@Autowired
	private UserService userService;
	@Autowired
	private ServersService seversService;
	
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
		System.out.println("addUser POST");
		return "addUser";
	}
	
	@RequestMapping(value = "/addServerToUser")
	public String setListServersAndUsers(ModelMap model){
		System.out.println("GET addServerToUser");
		model.addAttribute("listServers", seversService.getMapIdServers());
		model.addAttribute("server", servers);
		
		model.addAttribute("listUsers", userService.getMapIdUsers());
		model.addAttribute("user", user);
		return "addServerToUser";
	}
	@RequestMapping(value = "/addServerToUser", method = RequestMethod.POST)
	public String getListServersAndUsers(ModelMap model, @ModelAttribute("servers") Server servers, @ModelAttribute("user") User user ){
			System.out.println("Post addServerToUser");
			for (String item : servers.getListServers()){
				System.out.println("List server: "  + item);	
			}
			for (String item : user.getListUsers()){
				System.out.println("List user: "  + item);	
			}
			model.addAttribute("listServers", seversService.getMapIdServers());
			model.addAttribute("server", servers);
			
			model.addAttribute("listUsers", userService.getMapIdUsers());
			model.addAttribute("user", user);
		return "addServerToUser";
	}
}
