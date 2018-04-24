package ca.seanforfun.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ca.seanforfun.blog.model.entity.entity.User;
import ca.seanforfun.blog.model.entity.vo.Alert;
import ca.seanforfun.blog.service.ebo.UserService;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 24, 2018 12:58:51 PM
 * @version 1.0
 */
@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/tologin")
	public ModelAndView toLoginPage(ModelAndView mv) {
		// Dispatcher to login page.
		mv.setViewName("/admin/login.html");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute User user, ModelAndView mv,
			String remember, HttpSession session) {
		//Check user information from database.
		User loginUser = userService.checkUserInfo(user);
		if(loginUser == null){
			mv.addObject("alert", new Alert("Name or password incorrect."));
			mv.setViewName("/admin/login.html");
		}
		// Save user information into Session for remember me.
		if (null != remember) {
			session.setAttribute("loginUser", loginUser);
		}
		return mv;
	}
}
