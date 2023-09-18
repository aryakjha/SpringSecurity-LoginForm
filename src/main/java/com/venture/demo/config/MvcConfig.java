package com.venture.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/home")
		.addResourceLocations("file:///C:\\Users\\ARYA K JHA\\Desktop\\UDEMY\\MERN_Projects\\UserLoginAppliation\\index.html");
		
		
		registry.addResourceHandler("/register")
				.addResourceLocations("file:///C:\\Users\\ARYA K JHA\\Desktop\\UDEMY\\MERN_Projects\\UserLoginAppliation\\register.html");
		
		registry.addResourceHandler("/login_page")
		.addResourceLocations("file:///C:\\Users\\ARYA K JHA\\Desktop\\UDEMY\\MERN_Projects\\UserLoginAppliation\\login.html");
		
		registry.addResourceHandler("/content")
				.addResourceLocations("file:///C:\\Users\\ARYA K JHA\\Desktop\\UDEMY\\MERN_Projects\\UserLoginAppliation\\content.html");
	}
	
	
	public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/").setViewName("redirect:/home");
	 }

}
