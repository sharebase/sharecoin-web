package com.sharebaseinc.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		appContext.setConfigLocation("sharebase-web.xml");
//		ServletRegistration.Dynamic registration = container.addServlet("spring-dispatcher",new DispatcherServlet(appContext));
//		registration.setLoadOnStartup(1);
//		registration.addMapping("/");
	}
}
