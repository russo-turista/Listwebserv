package com.listwebserv.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.listwebserv.domain.Config;
import com.listwebserv.service.SettingsService;


@Controller
@RequestMapping(value = "/Settings")
public class SettingsController {
	
	private  final Logger logger = Logger.getLogger(SettingsController.class);
	
	@Autowired
	private Config config;
	
	@Autowired
	private SettingsService settingsService;
	
	@RequestMapping(value = "")
	public String addSettings(ModelMap model) {
		model.addAttribute("config", settingsService.getConfig());
		System.out.println("AddConfig!!!!!!!!!");
		return "addSettings";
	}
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String getSettings(ModelMap model, @ModelAttribute("config") Config config) {
		settingsService.setConfig(config);
		return "addSettings";
	}
	/*@RequestMapping(value = "/")
	public String viewSettings(ModelMap model){
		model.addAttribute("config", settingsService.getConfig());
		return "settings";
	}*/
}
