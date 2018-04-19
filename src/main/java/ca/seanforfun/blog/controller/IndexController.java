package ca.seanforfun.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ca.seanforfun.blog.exception.SeanForFunException;
import ca.seanforfun.blog.model.entity.entity.Category;
import ca.seanforfun.blog.model.entity.entity.User;
import ca.seanforfun.blog.model.entity.vo.UserVo;
import ca.seanforfun.blog.service.ebo.CategoryService;
import ca.seanforfun.blog.service.ebo.UserService;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 13, 2018 5:20:44 PM
 * @version 1.0
 */
@Controller
public class IndexController {
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv) throws Exception {
		/**
		 * Get user information according to url
		 */
		String requestUrl = request.getRequestURL().toString();
		UserVo userInfo = userService.getUserByUrl(requestUrl);

		if (null == userInfo) {
			throw new SeanForFunException("Current url is not registered...");
		}
		if (null == userInfo.getActivestatus()
				|| userInfo.getActivestatus() == UserVo.USER_NOT_ACTIVED) {
			throw new SeanForFunException("Blogger's e-mail is not verified...");
		}

		/**
		 * TODO Get user avatar and carousel pictures from third party database.
		 */
		if (null == userInfo.getPic()) {
			userInfo.setDefaultAvatar();
		}

		mv.addObject("userInfo", userInfo);

		/**
		 * TODO Get primary front categories from database.
		 */
		List<Category> primaryFrontCategories = categoryService.getPrimaryFrontCategories();
		if(null == primaryFrontCategories || primaryFrontCategories.size() <= 0){
			throw new SeanForFunException("Blog Category setting error....");
		}else{
			mv.addObject("pfcategory", primaryFrontCategories);
		}
		/**
		 * TODO Get 10 new blogs from database.
		 */

		/**
		 * TODO Blog access statistic update
		 */
		mv.setViewName("front/index.html");
		return mv;
	}
}
