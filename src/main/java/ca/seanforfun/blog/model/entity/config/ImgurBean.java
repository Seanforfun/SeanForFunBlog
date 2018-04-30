package ca.seanforfun.blog.model.entity.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 30, 2018 3:04:27 PM
 * @version 1.0
 */
@Component
@Scope(value="singleton")
@Configuration
@ConfigurationProperties(prefix="com.seanforfun.imgur.client")
public class ImgurBean {
	private String id;
	private String secret;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
}
