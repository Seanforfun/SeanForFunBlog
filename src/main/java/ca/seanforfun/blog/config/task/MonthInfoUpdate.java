package ca.seanforfun.blog.config.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ca.seanforfun.blog.service.ebo.MonthService;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date May 5, 2018 3:57:16 PM
 * @version 1.0
 */
@Component
public class MonthInfoUpdate {
	@Autowired
	private MonthService monthService;
	
	@Scheduled(cron="0 0 0 1 * ?")
	public void addMonthInfo(){
		monthService.createMonth();
	}
}
