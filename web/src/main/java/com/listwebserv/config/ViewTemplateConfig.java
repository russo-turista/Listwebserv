package com.listwebserv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class ViewTemplateConfig {
	
	@Bean
    public FreeMarkerConfigurer freemarkerConfig() { 
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("WEB-INF/pages/"); 
        freeMarkerConfigurer.setDefaultEncoding("UTF-8");
        return freeMarkerConfigurer;
    }
	

	@Bean
	public FreeMarkerViewResolver viewResolver() {
	    FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
	    viewResolver.setExposeRequestAttributes(true);
	    viewResolver.setExposeSessionAttributes(true);
	    viewResolver.setExposeSpringMacroHelpers(true);
	    viewResolver.setPrefix("");
	    viewResolver.setSuffix(".ftl");
	    viewResolver.setCache(true); 
	    viewResolver.setContentType("text/html;charset=UTF-8");
	    return viewResolver;
	}
	
}
