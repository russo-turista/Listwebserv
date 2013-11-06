package com.listwebserv.controllers;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.listwebserv.logic.*;

@Controller
@Service
public class ListHostsNameController {
	
	@Inject
	private HostServers servers;
	private ArrayList<String> hostNameList = new ArrayList<String>();
	private String urlConnect = "";
	//private String socketConnect = "";
	private String hostPort = "";

	//private ArrayList hostNameList = new ArrayList<E>();
	/**
	 * Saves the static list of users in model and renders it via freemarker
	 * template.
	 * 
	 * @param model
	 * @return The index view (FTL)
	 */
	@RequestMapping(value = "/hostname", method = RequestMethod.GET)
	public String addHostName(/*@ModelAttribute("model")*/ ModelMap model, HttpServletRequest request,HttpServletResponse response) {

		return "hostname";
	}
	
	/**
	 * Add a new user into static user lists and display the same into FTL via
	 * redirect
	 * 
	 * @param user
	 * @return Redirect to /index page to display user list
	 * @throws Exception 
	 * @throws Exception 
	 *//*
	@RequestMapping(value = "/addHostName", method = RequestMethod.POST)
	public String add( @ModelAttribute("model") ModelMap model, @RequestParam(value = "hostName") String hostName, @RequestParam(value = "hostPort") String hostPort,  HttpServletRequest request,HttpServletResponse response ) throws Exception {

		
		if (firstname != null && lastname != null) {
			synchronized (userList) {
				userList.add(new User(lastname, firstname));
				System.out.println("userList.size= " + userList.size());
			}
			
		}
		response.setHeader("Refresh", "5");
		try {
			model.addAttribute("hostNameList", servers.getServersName(hostName));
		   // model.addAttribute("socketConnect", servers.createScketConnect(hostName, hostPort));
		    model.addAttribute("urlConnect", servers.httpUrlServers(hostName, hostPort));
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
		return "hostsInfoList";
	}*/
	@RequestMapping(value = "/hostsInfoList", method = RequestMethod.GET)
	public String hostsInfoList (ModelMap model, @RequestParam(value = "hostName") String hostName, @RequestParam(value = "hostPort") String hostPort,  HttpServletRequest request,HttpServletResponse response) throws Exception {

		
		
		Calendar calendar = new GregorianCalendar();
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		model.addAttribute("currentDate",hour + ":" + minute + ":" + second);
		/*model.addAttribute("hostNameList", hostNameList);
		model.addAttribute("hostPort", hostPort);
		model.addAttribute("urlConnect", urlConnect);*/
		hostNameList.add(hostName);
		
		response.setHeader("Refresh", "30");
		try {
			// model.addAttribute("socketConnect", servers.createScketConnect(hostName, hostPort));
		    model.addAttribute("urlConnect", servers.httpUrlServers(hostName, hostPort));
		    model.addAttribute("hostNameList", servers.getAddressIP());
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
		
		return "hostsInfoList";
	}

}
