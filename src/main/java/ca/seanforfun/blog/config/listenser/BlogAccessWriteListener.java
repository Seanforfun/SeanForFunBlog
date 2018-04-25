package ca.seanforfun.blog.config.listenser;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.annotation.Configuration;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 25, 2018 10:42:19 AM
 * @version 1.0
 */
@WebListener
@Configuration
public class BlogAccessWriteListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Write Blog access data into database.
	}
}
