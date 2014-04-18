package com.listwebserv.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.listwebserv.logic.RequestServers;
import com.listwebserv.logic.ScheduledRequestServers;
import com.listwebserv.service.UserDetailsServiceImpl;

@Configuration
@EnableWebMvc
@Import({ViewTemplateConfig.class})
@ComponentScan(basePackages = "com.listwebserv.*")
class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	//same in XML <mvc:resources mapping="/resources/**" location="/public-resources/"/>
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LocaleChangeInterceptor());
	}
	
    @Bean
    public UserDetailsService getUserDetailsService(){
        return new UserDetailsServiceImpl();
    }
    
    @Bean
    public ShaPasswordEncoder passwordEncoder(){
        return new ShaPasswordEncoder(256);
    }
}