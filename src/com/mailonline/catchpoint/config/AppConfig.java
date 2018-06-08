package com.mailonline.catchpoint.config;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;







@Configuration
@ComponentScan("com.mailonline.catchpoint")
@Import({ThymeleafAutoConfiguration.class, DispatcherServlet.class, StandardServletMultipartResolver.class}) 
@EnableWebMvc
public class AppConfig  implements WebMvcConfigurer , ApplicationContextAware{
	private ApplicationContext applicationContext;
	
	
	
	@Bean 
	public JettyServletWebServerFactory jetty(){
		JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
		factory.setPort(80);	
		return factory;
	}




	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	
		this.applicationContext = applicationContext;
	  
		
	}
	
}
