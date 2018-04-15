package ca.seanforfun.blog.config.adapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 14, 2018 8:47:09 PM
 * @version 1.0
 */
@Configuration
public class CustomMvcAdapter extends WebMvcConfigurationSupport   {

	@Override
	protected void addViewControllers(ViewControllerRegistry registry) {
		// TODO *************Add ViewController for Spring boot.*************
//		registry.addViewController("/tologin").setViewName("index.html");
//		registry.addRedirectViewController("/tologin", "/index.html");
		super.addViewControllers(registry);
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		// TODO *************Add Interceptors for Spring boot.*************
		super.addInterceptors(registry);
	}
	
}
