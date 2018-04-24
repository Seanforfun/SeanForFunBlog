package ca.seanforfun.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 24, 2018 5:28:20 PM
 * @version 1.0
 */
@Controller
public class AdminController {
	
	@RequestMapping("/toAdmin")
	public ModelAndView toAdminPage(ModelAndView mv){
		mv.setViewName("admin/admin.html");
		return mv;
	}
}
