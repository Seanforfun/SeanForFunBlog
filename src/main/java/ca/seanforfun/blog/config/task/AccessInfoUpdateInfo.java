package ca.seanforfun.blog.config.task;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ca.seanforfun.blog.model.entity.config.BlogInfo;
import ca.seanforfun.blog.service.ebo.AccessService;
import ca.seanforfun.blog.utils.PropertiesUtil;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 25, 2018 12:08:45 PM
 * @version 1.0
 */
@Component
public class AccessInfoUpdateInfo {
	@Autowired
	private AccessService accessService;
	/**
	 * @Description: Update the daily access information to properties file every 30 minutes.
	 * @Return: void
	 */
	@Scheduled(cron="* 0/30 * * * ?")
	public void updateDailyAccessToProperties() throws IOException{
		Properties statistic = PropertiesUtil.getClasspathProperties("properties/access.properties");
		PropertiesUtil.setClasspathProperties(statistic, "properties/access.properties", "com.seanforfun.blog.access.day", BlogInfo.oneDayAccessTime.toString());
	}
	
	/**
	 * @Description: Write daily access information to db every night at 12:00:00.
	 * @Return: void
	 */
	@Scheduled(cron="0 0 0 * * ?")
	public void updateDailyAccessToDb(){
		// TODO Write value to database.
		accessService.createDailyAccess(BlogInfo.oneDayAccessTime.get());
		BlogInfo.oneDayAccessTime.set(0L);
		Properties statistic = PropertiesUtil.getClasspathProperties("properties/access.properties");
		//Clear values in properties file.
		PropertiesUtil.setClasspathProperties(statistic, "properties/access.properties", "com.seanforfun.blog.access.day", "0");
	}
}
