package com.example.website.config;

import java.util.ArrayList;
import java.util.List;

import com.example.website.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		HandlerInterceptor loginInterceptor = new LoginInterceptor();
		
		InterceptorRegistration ir = registry.addInterceptor(loginInterceptor);
		
		// 黑名单
		ir.addPathPatterns("/bidding_project.html");
		ir.addPathPatterns("/bidings/create");
	}
	
	
}
