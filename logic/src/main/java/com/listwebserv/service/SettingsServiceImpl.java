package com.listwebserv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.listwebserv.dao.SettingsDAO;
import com.listwebserv.domain.Config;

@Service
public class SettingsServiceImpl implements SettingsService{
	@Autowired
	SettingsDAO settingsDAO;
	public Config getConfig(){
		return settingsDAO.getConfigDB();		
	};
	public void setConfig(Config config){
		settingsDAO.setConfigDB(config);
	}
}
