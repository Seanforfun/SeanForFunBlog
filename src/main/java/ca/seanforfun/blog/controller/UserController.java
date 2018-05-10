package ca.seanforfun.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.seanforfun.blog.exception.SeanForFunException;
import ca.seanforfun.blog.service.ebo.UserService;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date May 9, 2018 10:10:13 PM
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//-----------------------------------------------AJAX----------------------------------------------------------
	@RequestMapping("/image")
	public void ajaxUploadImage(String imageInfo){
		if(imageInfo == null){
			throw new SeanForFunException("Upload image problem...");
		}
		
		userService.updateAdminPic(imageInfo);
	}
}
