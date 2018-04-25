package ca.seanforfun.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ca.seanforfun.blog.model.entity.config.ConfigBean;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 24, 2018 5:28:20 PM
 * @version 1.0
 */
@Controller
public class AdminController {
	@Autowired
	private ConfigBean configBean;
	
	@RequestMapping("/toAdmin")
	public ModelAndView toAdminPage(ModelAndView mv){
		//Get yesterday's blog access data.
		
		//Get blog articles infromation.
		
		//Get comments information.
		
		//Get Friend's link information.
		
		//Get Blog information.
		
		mv.setViewName("admin/admin.html");
		return mv;
	}
	
	@RequestMapping("/adminSignout")
	public ModelAndView signOut(ModelAndView mv, HttpSession session){
		session.removeAttribute("remember");
		mv.setViewName("redirect:/");
		return mv;
	}
}
