package ca.seanforfun.blog.config.runner;

import java.util.Properties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import ca.seanforfun.blog.model.entity.config.BlogInfo;
import ca.seanforfun.blog.utils.PropertiesUtil;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 25, 2018 11:03:33 AM
 * @version 1.0
 */
@Configuration
public class AccessTimeRunner implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		//Read access statistic data from properties file.
		Properties statistic = PropertiesUtil.getClasspathProperties("properties/access.properties");
		BlogInfo.oneDayAccessTime.set(new Long((String)statistic.get("com.seanforfun.blog.access.day")));
		BlogInfo.oneMonthAccessTime.set(new Long((String)statistic.get("com.seanforfun.blog.access.month")));
	}

}
