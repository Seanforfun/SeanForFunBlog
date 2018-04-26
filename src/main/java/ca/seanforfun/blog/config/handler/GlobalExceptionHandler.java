package ca.seanforfun.blog.config.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import ca.seanforfun.blog.exception.SeanForFunException;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 26, 2018 3:46:43 PM
 * @version 1.0
 */
public class GlobalExceptionHandler implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		if(ex instanceof SeanForFunException){
			System.out.println(ex.getStackTrace());
		}
		else{
			// Check the state of server and redirect to error page.
			System.out.println(ex.getStackTrace());
		}
		return null;
	}
}
