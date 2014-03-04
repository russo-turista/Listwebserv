package com.listwebserv.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.listwebserv.domain.Servers;
import com.listwebserv.logic.CreateThreadPool;

@Controller
@Service
public class ListHostsNameController {
	
	@Inject
	private CreateThreadPool createThereadPool;
	@Inject 
	private Servers servers;
	
	public ArrayList<String> hostNameList = new ArrayList<String>();
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
	@RequestMapping(value = "/hostname")
	public String addHost(/*@ModelAttribute("model")*/ ModelMap model/*, @RequestParam( value = "hostName", required = false) String hostName, @RequestParam( value = "hostPort", required = false) Integer hostPort */) {
		model.addAttribute("servers", servers);
		
		System.out.println("hostNameSET!!!!!!!!!!!!!!!!!!!!!");
		return "hostname";
	}
	/*@RequestMapping(value = "/hostname", method = RequestMethod.GET)
	public String getHostName(ModelMap model, @RequestParam(value = "hostName") String hostName, @RequestParam(value = "hostPort") String hostPort) {
		System.out.println("hostNameGET!!!!!!!!!!!!!!!!!!!!!");
		createThereadPool.setListHosts(hostName, hostPort);
		return "hostname";
	}*/
	
	
	@RequestMapping(value = "/hostsInfoList", method = RequestMethod.POST)
	public String hostsInfoList (ModelMap model, @ModelAttribute("servers") Servers servers, HttpServletRequest request,HttpServletResponse response) throws Exception {

		
		
		Calendar calendar = new GregorianCalendar();
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		model.addAttribute("currentDate",hour + ":" + minute + ":" + second);
		//hostNameList.add(hostName);
//		requestServers.getListHosts(hostName, hostPort);
		
		response.setHeader("Refresh", "30");
//		try {
			// model.addAttribute("socketConnect", servers.createScketConnect(hostName, hostPort));
		   
		   // model.addAttribute("urlConnect", servers.httpUrlServers(hostName, hostPort));
		System.out.println("hostName= " + servers.getHostName());
		System.out.println("hostPort= " + servers.getHostPort());
		
		createThereadPool.setListHosts(servers.getHostName(), servers.getHostPort());
		model.addAttribute("hostNameList", createThereadPool.getListHosts());
		    
		/*} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
		*/
		return "hostsInfoList";
	}

}
