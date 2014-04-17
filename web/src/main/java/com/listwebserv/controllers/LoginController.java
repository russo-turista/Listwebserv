package com.listwebserv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.listwebserv.logic.ServersThread;

@Controller
@RequestMapping("/login")
public class LoginController {
	 private ServersThread serversThread = new ServersThread();
    @RequestMapping(method = RequestMethod.GET)
    public String loginPage(Model model){
    	    	serversThread.startThread();
        return "login";
    }
}    