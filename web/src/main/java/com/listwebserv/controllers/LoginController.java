package com.listwebserv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.listwebserv.logic.RequestServers;
import com.listwebserv.logic.ScheduledRequestServers;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	RequestServers requestServers;
    @RequestMapping(method = RequestMethod.GET)
    public String loginPage(Model model){
    	requestServers.startRequest();;
        return "login";
    }
}    