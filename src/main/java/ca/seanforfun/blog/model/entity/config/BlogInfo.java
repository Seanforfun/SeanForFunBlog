package ca.seanforfun.blog.model.entity.config;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 25, 2018 10:32:19 AM
 * @version 1.0
 */
@Component
@Scope("singleton")
public class BlogInfo {
	public static volatile AtomicLong oneDayAccessTime = new AtomicLong(0);
	public static volatile AtomicLong oneMonthAccessTime = new AtomicLong(0);
}
