package com.listwebserv.service;

import com.listwebserv.domain.Config;


public interface SettingsService {
	public Config getConfig();
	public void setConfig(Config config);
}
