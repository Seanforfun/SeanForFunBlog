package ca.seanforfun.blog.model.entity.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 14, 2018 7:29:16 PM
 * @version 1.0
 */
@Component
@Scope("prototype")
@ConfigurationProperties(prefix="com.sean.random")
@PropertySource("classpath:/properties/random.properties")
public class RandomBean {
	private String uuid;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
