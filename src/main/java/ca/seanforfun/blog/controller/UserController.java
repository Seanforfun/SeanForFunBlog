package ca.seanforfun.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ca.seanforfun.blog.exception.SeanForFunException;
import ca.seanforfun.blog.model.entity.entity.User;
import ca.seanforfun.blog.service.ebo.UserService;
import ca.seanforfun.blog.validator.UpdateAdminValidator;

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

	@RequestMapping("/updateAdminInfo")
	public ModelAndView updateAdminInfo(
			ModelAndView mv,
			@Validated(value = UpdateAdminValidator.class) @ModelAttribute("user") User user,
			BindingResult bindingResult) {
		// Update Admin information
		return mv;
	}

	// -----------------------------------------------AJAX----------------------------------------------------------
	@RequestMapping("/image")
	public void ajaxUploadImage(String imageInfo) {
		if (imageInfo == null) {
			throw new SeanForFunException("Upload image problem...");
		}

		userService.updateAdminPic(imageInfo);
	}
}
