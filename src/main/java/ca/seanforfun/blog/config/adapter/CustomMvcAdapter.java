package ca.seanforfun.blog.config.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 14, 2018 8:47:09 PM
 * @version 1.0
 */
@Configuration
public class CustomMvcAdapter implements WebMvcConfigurer    {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO *************Add ViewController for Spring boot.*************
		registry.addRedirectViewController("/tologin", "/admin/login.html");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO *************Add Interceptors for Spring boot.*************
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		//Add Custom view resorlver.
	}
}
