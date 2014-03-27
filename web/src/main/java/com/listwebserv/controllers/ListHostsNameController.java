package com.listwebserv.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.listwebserv.domain.Servers;
import com.listwebserv.logic.RequestServers;
import com.listwebserv.service.ServListService;

@Controller
public class ListHostsNameController {
	
	private static final Logger logger = Logger.getLogger(ListHostsNameController.class);
	
	@Autowired 
	private Servers servers;
	
	@Autowired 
	private RequestServers requestServers;
	
	@Autowired 
	private ServListService servListService;
	
	private Map<String, Integer> listHosts = new HashMap<String, Integer>();

	
	@RequestMapping(value = "/hostname")
	public String addHost(/*@ModelAttribute("model")*/ ModelMap model/*, @RequestParam( value = "hostName", required = false) String hostName, @RequestParam( value = "hostPort", required = false) Integer hostPort */) {
		model.addAttribute("servers", servers);
		
		System.out.println("hostNameSET!!!!!!!!!!!!!!!!!!!!!");
		return "hostname";
	}	
	
	@RequestMapping(value = "/hostsInfoList" /*, method = RequestMethod.POST*/)
	public String hostsInfoList (ModelMap model, @ModelAttribute("servers") Servers servers, HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Calendar calendar = new GregorianCalendar();
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		model.addAttribute("currentDate",hour + ":" + minute + ":" + second);
		
		response.setHeader("Refresh", "30");
		/*System.out.println("hostName= " + servers.getHostName());
		System.out.println("hostPort= " + servers.getHostPort());*/
		logger.info("hostName= " + servers.getHostName());
		logger.info("hostPort= " + servers.getHostPort());
		
		if (servers.getHostName() != null && servers.getHostPort() != null){
			listHosts.put(servers.getHostName(),servers.getHostPort());
			requestServers.listsServers(listHosts);
		}	
		model.addAttribute("hostNameList", servListService.getListServ());
		    
		return "hostsInfoList";
	}

}
