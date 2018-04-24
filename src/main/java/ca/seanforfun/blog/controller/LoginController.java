package ca.seanforfun.blog.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ca.seanforfun.blog.model.entity.config.ConfigBean;
import ca.seanforfun.blog.model.entity.entity.User;
import ca.seanforfun.blog.model.entity.vo.Alert;
import ca.seanforfun.blog.service.ebo.UserService;
import ca.seanforfun.blog.utils.MD5Utils;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 24, 2018 12:58:51 PM
 * @version 1.0
 */
@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private ConfigBean configBean;
	
	private String getIpAddr(HttpServletRequest request){
		String loginIp = request.getHeader("x-forwarded-for");
		if (loginIp == null || loginIp.length() == 0
				|| "unknown".equalsIgnoreCase(loginIp)) {
			loginIp = request.getHeader("Proxy-Client-IP");
		}
		if (loginIp == null || loginIp.length() == 0
				|| "unknown".equalsIgnoreCase(loginIp)) {
			loginIp = request.getHeader("WL-Proxy-Client-IP");
		}
		if (loginIp == null || loginIp.length() == 0
				|| "unknown".equalsIgnoreCase(loginIp)) {
			loginIp = request.getRemoteAddr();
		}
		return loginIp;
	}

	@RequestMapping("/tologin")
	public ModelAndView toLoginPage(ModelAndView mv, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		// If session scope saved user information direct to admin page directly.
		String rememberToken = (String) session.getAttribute("remember");
		String loginIp = getIpAddr(request);
		//Set a token and check the token
		if(null != rememberToken && rememberToken.equals(MD5Utils.md5(loginIp + configBean.getRememberSalt()))){
			mv.setViewName("redirect:/toAdmin");
			return mv;
		}
		// Dispatcher to login page.
		mv.setViewName("/admin/login.html");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,
			@ModelAttribute User user, ModelAndView mv, String remember,
			HttpSession session) {
		// Check user information from database.
		User loginUser = userService.checkUserInfo(user);
		if (loginUser == null) {
			mv.addObject("alert", new Alert("Name or password incorrect."));
			mv.setViewName("/admin/login.html");
		}
		if (loginUser.getActivestatus() == User.USER_NOT_ACTIVED) {
			mv.addObject("alert", new Alert(
					"Please verify your e-mail before login."));
			mv.setViewName("/admin/login.html");
		}

		// Get login ip address
		String loginIp = getIpAddr(request);

		// Save user information into Session for remember me.
		session.setAttribute("loginUser", loginUser);
		
		if (null != remember) {
			//Save a remember me token, using ip address and salt
			String saltedIp = loginIp + configBean.getRememberSalt();
			session.setAttribute("remember", MD5Utils.md5(saltedIp));
		}

		// Update user information
		userService.loginUpdate(loginUser.getId(), loginIp);
		mv.setViewName("redirect:/toAdmin");
		return mv;
	}
}
