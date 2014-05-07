package com.listwebserv.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	private Server server;
	@Autowired
	private UserService userService;
	@Autowired
	private ServersService seversService;
	
	@RequestMapping(value = "/addUser")
	public String setUser(ModelMap model) {
		model.addAttribute("user", user);
		
		System.out.println("AddEUser!!!!!!!!!");
		model.addAttribute("currentPage", "addUser");
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
		model.addAttribute("currentPage", "addUser");
		return "addUser";
	}
	
	@RequestMapping(value = "/addServerToUser")
	public String setListServersAndUsers(ModelMap model){
		System.out.println("GET addServerToUser");
		model.addAttribute("listServers", seversService.getMapIdServers());
		model.addAttribute("server", server);
		
		model.addAttribute("listUsers", userService.getMapIdUsers());
		model.addAttribute("user", user);
		model.addAttribute("currentPage", "addServerToUser");
		return "addServerToUser";
	}
	@RequestMapping(value = "/addServerToUser", method = RequestMethod.POST)
	public String getListServersAndUsers(ModelMap model, @ModelAttribute("server") Server server, @ModelAttribute("user") User user ){
		System.out.println("Post addServerToUser");
		for (String item : server.getListServers()){
			System.out.println("List server: "  + item);	
		}
		for (String item : user.getListUsers()){
			System.out.println("List user: "  + item);	
		}
		seversService.setServerToUsers(server.getListServers(), user.getListUsers());
		model.addAttribute("listServers", seversService.getMapIdServers());
		model.addAttribute("server", server);
		
		model.addAttribute("listUsers", userService.getMapIdUsers());
		model.addAttribute("user", user);
		model.addAttribute("currentPage", "addServerToUser");
		return "addServerToUser";
	}
	
	@RequestMapping(value = "/listUsers")
	public String getListUsers(ModelMap model){
		model.addAttribute("listUsers", userService.getListUsers());
		model.addAttribute("currentPage", "listUsers");
		return "listUsers";
	}
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public String getEmployee(@PathVariable Long userId, Model model) {
		model.addAttribute("user", userService.getUser(userId));
		model.addAttribute("userServerList", seversService.getServersToUser(userId));
		for (Server item :  seversService.getServersToUser(userId)){
			System.out.println(item.getHostName());
		}
		model.addAttribute("currentPage", "user");
		return "userpage";
	  
	}
	  
}
