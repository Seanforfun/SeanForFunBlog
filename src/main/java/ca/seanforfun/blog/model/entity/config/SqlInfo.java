package ca.seanforfun.blog.model.entity.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 25, 2018 3:40:43 PM
 * @version 1.0
 */
@Component
@Scope(value="singleton")
@Configuration
@ConfigurationProperties(prefix="spring.datasource")
public class SqlInfo {
	private String url;
	private String username;
	private String password;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
