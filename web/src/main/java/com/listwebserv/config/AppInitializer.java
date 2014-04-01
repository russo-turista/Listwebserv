package com.listwebserv.config;


import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	  @Override
   public void onStartup(ServletContext servletContext) throws ServletException {
    System.out.println("Initializer");
   
    	AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    	ctx.setDisplayName("WebListServ");
    	ctx.register(WebMvcConfig.class, JdbcConfig.class, SecurityConfig.class);
  // Листенер для управления жизненным циклом корневого контекста Spring  
        servletContext.addListener(new ContextLoaderListener(ctx));
        
  // Регистрация сервлета-диспетчера Spring MVC
        //ctx.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
        
    //Filter UTF encoding
        FilterRegistration.Dynamic charEncodingFilterReg =
        		servletContext.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
        charEncodingFilterReg.setInitParameter("encoding", "UTF-8");
        charEncodingFilterReg.setInitParameter("forceEncoding", "true");
        charEncodingFilterReg.addMappingForUrlPatterns(null, false, "/*");
        
    //Filter SpringSecurity     
        
        FilterRegistration.Dynamic springSecurityFilterChain = 
  				servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
  		springSecurityFilterChain.addMappingForUrlPatterns(null, false, "/*");
        
    }

}
