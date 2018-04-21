package ca.seanforfun.blog.model.entity.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 14, 2018 7:10:59 PM
 * @version 1.0
 */
@Component
@Scope(value="singleton")
@Configuration
@ConfigurationProperties(prefix="com.seanforfun")
@PropertySource(value="classpath:/properties/seanforfun.properties")
public class ConfigBean {
	public static String author;
	public static String version;
	public static Integer maxArticlePerPage; 
}
