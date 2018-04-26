package ca.seanforfun.blog.aspect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ca.seanforfun.blog.exception.UserNotLoginException;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 26, 2018 2:51:46 PM
 * @version 1.0
 */
public class AdminAspect {
	@Pointcut("execution(public * ca.seanforfun.blog.controller.AdminController.*(..))")
	public void AdminOperations(){};
	
	@Before("AdminOperations()")
	public void checkLogin(JoinPoint jp) throws IOException, ServletException, UserNotLoginException{
		System.out.println("=======================================");
		System.out.println("=======================================");
		System.out.println("=======================================");
		System.out.println("=======================================");
		System.out.println("=======================================");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession session = attributes.getRequest().getSession();
		if(null == session.getAttribute("loginUser")){
			throw new UserNotLoginException();
		}
	}
}
