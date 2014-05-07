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
public class MainPageController {
	
	private  final Logger logger = Logger.getLogger(MainPageController.class);
	
	@RequestMapping(value = "/")
	public String setUser(ModelMap model) {	
		model.addAttribute("currentPage", "");
		return "index";
	}
}
