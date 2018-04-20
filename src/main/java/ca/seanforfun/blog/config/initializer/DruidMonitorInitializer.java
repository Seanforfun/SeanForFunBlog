package ca.seanforfun.blog.config.initializer;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 20, 2018 7:10:58 PM
 * @version 1.0
 */
@Configuration
public class DruidMonitorInitializer {
	private static Logger logger = LoggerFactory.getLogger(DruidMonitorInitializer.class);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean public ServletRegistrationBean druidServlet(){
		logger.info("init Druid Servlet Configuration ");
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
		servletRegistrationBean.setServlet(new StatViewServlet());
		servletRegistrationBean.addUrlMappings("/druid/*");
		Map<String, String> initParameters = new HashMap<String, String>();
		initParameters.put("loginUsername", "admin");
		initParameters.put("loginPassword", "911023");
		initParameters.put("resetEnable", "false");
		initParameters.put("allow", ""); 
		initParameters.put("deny", "");
		servletRegistrationBean.setInitParameters(initParameters);
		return servletRegistrationBean; 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean 
	public FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}
