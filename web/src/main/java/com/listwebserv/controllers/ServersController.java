package com.listwebserv.controllers;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





import com.listwebserv.domain.Servers;
import com.listwebserv.logic.ServersThread;
import com.listwebserv.service.ServersService;
import com.listwebserv.service.SettingsService;


@Controller
public class ServersController {
	
	private final Logger logger = Logger.getLogger(ServersController.class);
	
	@Autowired 
	private Servers servers;
	
	@Autowired 
	private ServersService seversService;
	
	@Autowired
	private SettingsService settingsService;

	private Map<String, Integer> listHosts = new HashMap<String, Integer>();

	
	@RequestMapping(value = "/addServer")
	public String addServer(ModelMap model) {
		model.addAttribute("servers", servers);
		
		System.out.println("hostNameSET!!!!!!!!!!!!!!!!!!!!!");
		return "addServer";
	}	
	
	@RequestMapping(value = "/addServer", method = RequestMethod.POST)
	public String saveServer(ModelMap model, @ModelAttribute("servers") Servers servers, HttpServletRequest request,HttpServletResponse response) {
		logger.info("hostName= " + servers.getHostName());
		logger.info("hostPort= " + servers.getHostPort());
		if (servers.getHostName() != null){
			if (servers.getHostPort() == null){
				servers.setHostPort(80);
				seversService.setServers(servers);
			}
		}
		return "addServer";
	}	
	@RequestMapping(value = "/hostsInfoList" /*, method = RequestMethod.POST*/)
	public String hostsInfoList (ModelMap model, HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		Calendar calendar = new GregorianCalendar();
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		model.addAttribute("currentDate",hour + ":" + minute + ":" + second);
		
		response.setHeader("Refresh", String.valueOf(settingsService.getConfig().getTimeUpdate()));
		model.addAttribute("hostNameList", seversService.getListServ());
		    
		return "hostsInfoList";
	}
	
	
	

}
