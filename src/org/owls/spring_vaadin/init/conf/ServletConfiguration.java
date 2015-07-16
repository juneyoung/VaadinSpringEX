package org.owls.spring_vaadin.init.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.vaadin.spring.annotation.EnableVaadin;

// @EnableWebMvc 에 대한 참조문서 : http://docs.spring.io/autorepo/docs/spring/4.1.4.RELEASE/javadoc-api/org/springframework/web/servlet/config/annotation/EnableWebMvc.html
// @EnableAsync 에 대한 참조 문서 : http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/annotation/EnableAsync.html
@Configuration
@EnableWebMvc
@EnableAsync
@EnableVaadin
@ComponentScan(basePackages={
	"org.owls.spring_vaadin.dao"
	, "org.owls.spring_vaadin.service"
	, "org.owls.spring_vaadin.controller"
	, "org.owls.spring_vaadin.ui"
}, excludeFilters=@ComponentScan.Filter(Configuration.class))
public class ServletConfiguration extends WebMvcConfigurerAdapter {
	
	//views 페이지에 대한 패턴 정의
	@Bean
	public ViewResolver viewResolver () {
		InternalResourceViewResolver irv = new InternalResourceViewResolver();
		irv.setPrefix("/WEB-INF/views/");
		irv.setSuffix(".jsp");
		return irv;
	}

	//resources 폴더를 정의함.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
	}
};