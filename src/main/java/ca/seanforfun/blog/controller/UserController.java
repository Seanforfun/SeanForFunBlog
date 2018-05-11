package ca.seanforfun.blog.controller;

import javax.servlet.http.HttpSession;

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
import ca.seanforfun.blog.utils.MD5Utils;
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
			BindingResult bindingResult, String oldPassword, HttpSession session) {
		if(bindingResult.hasErrors()){
			session.setAttribute("alertMessage", "alertMessage");
			mv.setViewName("redirect:/admin/toPersionalInfo");
			return mv;
		}
		
		User userInfo = userService.getUserById(user.getId());
		System.out.println(MD5Utils.md5(oldPassword));
		System.out.println(userInfo.getPassword());
		if(!MD5Utils.md5(oldPassword).equals(userInfo.getPassword())){
			session.setAttribute("passwordError", "passwordError");
			mv.setViewName("redirect:/admin/toPersionalInfo");
			return mv;
		}
		
		userInfo.setFirstName(user.getFirstName());
		userInfo.setLastName(user.getLastName());
		userInfo.setNickname(user.getNickname());
		if(user.getPassword() != null && user.getPassword().trim().length() != 0){
			userInfo.setPassword(MD5Utils.md5(user.getPassword()));
		}
		if(null != user.getCountry()){
			userInfo.setCountry(user.getCountry());
		}
		if(null != user.getProvince()){
			userInfo.setProvince(user.getProvince());
		}
		if(null != user.getBio()){
			userInfo.setBio(user.getBio());
		}
		userInfo.setIntro(user.getIntro());
		if(!userInfo.getEmail().equals(user.getEmail())){
			//Send verify email
			userInfo.setActivestatus(User.USER_ACTIVED);
		}
		userService.updateUserInfo(userInfo);
		session.setAttribute("SuccessInfo", "SuccessInfo");
		mv.setViewName("redirect:/admin/toPersionalInfo");
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
