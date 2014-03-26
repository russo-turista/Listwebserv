package com.listwebserv.settings.initializer;

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
    
   // Листенер для управления жизненным циклом корневого контекста Spring   
    	WebApplicationContext context = getContext();
        servletContext.addListener(new ContextLoaderListener(context));
        
  // Регистрация сервлета-диспетчера Spring MVC
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        
    //Filter UTF encoding
        FilterRegistration charEncodingFilterReg =
        		servletContext.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
        charEncodingFilterReg.setInitParameter("encoding", "UTF-8");
        charEncodingFilterReg.setInitParameter("forceEncoding", "true");
        charEncodingFilterReg.addMappingForUrlPatterns(null, false, "/*");
        
    //Filter SpringSecurity     
        FilterRegistration springSecurityFilterReg =
        		servletContext.addFilter("securityFilter", DelegatingFilterProxy.class);
        springSecurityFilterReg.addMappingForUrlPatterns(null, false, "/*");
        
    }

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.listwebserv.settings.config");
        return context;
    }

}
