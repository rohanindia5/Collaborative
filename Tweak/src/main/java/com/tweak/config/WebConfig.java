package com.tweak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.tweak.*")
public class WebConfig extends WebMvcConfigurerAdapter
{
	@Bean
	public InternalResourceViewResolver getViewResolver()
	{ 
		System.out.println("View Resolver:");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver(); 
		viewResolver.setPrefix("/WEB-INF/"); 
		viewResolver.setSuffix(".jsp"); 
		 return viewResolver; 
	 } 
	
	@Bean
	public StandardServletMultipartResolver multipartResolver1(){
	    return new StandardServletMultipartResolver();
	}
	
	  @Bean(name = "multipartResolver")
	    public CommonsMultipartResolver getMultipartResolver() {
	        return new CommonsMultipartResolver();
	    }
	  /**
	    * Supports FileUploads.
	    */
	  @Bean
	  public MultipartResolver multipartResolver() {
	      org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
	      multipartResolver.setMaxUploadSize(1000000);
	      return multipartResolver;
	  }

}
