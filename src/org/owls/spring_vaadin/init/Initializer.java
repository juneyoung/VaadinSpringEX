package org.owls.spring_vaadin.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.owls.spring_vaadin.init.conf.RootConfiguration;
import org.owls.spring_vaadin.init.conf.ServletConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.vaadin.spring.server.SpringVaadinServlet;

public class Initializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext arg0) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(RootConfiguration.class);
		ctx.register(ServletConfiguration.class);
		
//		*with Vaadin
		arg0.addListener(new ContextLoaderListener(ctx));
		registerServlet(arg0);
		
//		*without Vaadin
//		ctx.setServletContext(arg0);
//		Dynamic servlet = arg0.addServlet("dispatcher", new DispatcherServlet(ctx));
//		servlet.addMapping("/");
//		servlet.setLoadOnStartup(1);
	}
	
	private void registerServlet(ServletContext ctx){
		ServletRegistration.Dynamic dispatcher = 
				ctx.addServlet("vaadin", SpringVaadinServlet.class);
		dispatcher.addMapping("/");
		dispatcher.setLoadOnStartup(1);
		System.out.println("===== DONE ======");
	}
};