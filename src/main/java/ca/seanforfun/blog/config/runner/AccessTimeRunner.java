package ca.seanforfun.blog.config.runner;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import ca.seanforfun.blog.model.entity.config.BlogInfo;

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
		Properties statistic = new Properties();
		ClassPathResource resource = new ClassPathResource("properties/access.properties");
		File accessFile = resource.getFile();
		FileInputStream is = new FileInputStream(accessFile);
		statistic.load(is);
		BlogInfo.oneDayAccessTime.set(new Long((String)statistic.get("com.seanforfun.blog.access.day")));
		BlogInfo.oneMonthAccessTime.set(new Long((String)statistic.get("com.seanforfun.blog.access.month")));
	}

}
