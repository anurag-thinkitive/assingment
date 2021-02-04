package com.thinkitive.DEMOSpringUsingHibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.thinkitive.DEMOSpringUsingHibernate.controller.HomeController;
import com.thinkitive.DEMOSpringUsingHibernate.dao.EMPLOYEEDAOIMPL;

@Configuration
@ComponentScan(basePackages="com.thinkitive.DEMOSpringUsingHibernate")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

//	@Bean
//	public ViewResolver getViewResolver(){
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/WEB-INF/views/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}
//	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
//	@Bean
//public EMPLOYEEDAOIMPL getemployeedao() {
//	return new EMPLOYEEDAOIMPL();	}
//

	
}
