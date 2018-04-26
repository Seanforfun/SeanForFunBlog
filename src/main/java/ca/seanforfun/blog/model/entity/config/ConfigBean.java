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
	public String author;
	public String version;
	public Integer maxArticlePerPage;
	public String rememberSalt;
	public String name;
	public String getRememberSalt() {
		return rememberSalt;
	}
	public void setRememberSalt(String rememberSalt) {
		this.rememberSalt = rememberSalt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Integer getMaxArticlePerPage() {
		return maxArticlePerPage;
	}
	public void setMaxArticlePerPage(Integer maxArticlePerPage) {
		this.maxArticlePerPage = maxArticlePerPage;
	}
}
