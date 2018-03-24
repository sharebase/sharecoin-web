package com.sharebaseinc.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.web3j.spring.autoconfigure.Web3jAutoConfiguration;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(Web3jAutoConfiguration.class);
		ctx.setServletContext(servletContext);
		ctx.close();
	}
}
