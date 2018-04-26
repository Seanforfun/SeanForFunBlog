package ca.seanforfun.blog.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 26, 2018 3:30:29 PM
 * @version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		if(null == session.getAttribute("loginUser")){
			request.getRequestDispatcher("/tologin").forward(request, response);
			return false;
		}
		return true;
	}
}
