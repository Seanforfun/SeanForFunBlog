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
@PropertySource(value="classpath:/properties/seanforfun.properties ")
public class ConfigBean {
	private String author;
	private String version;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
