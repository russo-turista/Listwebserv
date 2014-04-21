package com.listwebserv.config;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.listwebserv.logic.RequestServers;
import com.listwebserv.service.SettingsService;

/*public class SpringScheduled {
 @Bean
 public DemoServiceBasicUsageFixedDelay exucute(){
 return new DemoServiceBasicUsageFixedDelay();
 }
 }*/
@Configuration
@EnableScheduling
@ComponentScan(basePackages = "com.listwebserv.logic*")
public class SpringScheduled implements SchedulingConfigurer {

	private static final Logger logger = Logger
			.getLogger(SpringScheduled.class);
	@Autowired
	private SettingsService settingsService;
	@Autowired
	RequestServers requestServers;

	@Bean(destroyMethod = "shutdown")
	public Executor taskExecutor() {
		return Executors.newSingleThreadScheduledExecutor();
	}

	

	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskExecutor());
		taskRegistrar.addTriggerTask(new Runnable() {
			@Override
			public void run() {
				logger.info("Ruquest servers is active:" + settingsService.getConfig().getActiveRuquest());
				if (settingsService.getConfig().getActiveRuquest()) {
					requestServers.startRequest();
				}
			}
		}, new Trigger() {
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				Calendar nextExecutionTime = new GregorianCalendar();
				nextExecutionTime.setTime(triggerContext
						.lastActualExecutionTime() == null ? new Date()
						: triggerContext.lastActualExecutionTime());
				nextExecutionTime.add(Calendar.SECOND, settingsService
						.getConfig().getTimeRequest()); // you can get the value
														// from wherever you
														// want
				logger.info("TimeRequest in Trigger: "
						+ settingsService.getConfig().getTimeRequest());
				return nextExecutionTime.getTime();
			}
		});
	}
}