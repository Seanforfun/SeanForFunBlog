package ca.seanforfun.blog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ca.seanforfun.blog.config.runner.CategoryRunner;
import ca.seanforfun.blog.exception.SeanForFunException;
import ca.seanforfun.blog.model.entity.config.ConfigBean;
import ca.seanforfun.blog.model.entity.entity.Article;
import ca.seanforfun.blog.model.entity.entity.Category;
import ca.seanforfun.blog.model.entity.vo.UserVo;
import ca.seanforfun.blog.service.ebo.ArticleService;
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
	private ArticleService articleService;
	@Autowired
	private ConfigBean configBean;

	@RequestMapping(value={"", "/{pageIndex}"})
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv, @PathVariable(required=false) Integer pageIndex) throws Exception {
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
		 * Get user avatar and carousel pictures from third party database.
		 */
		if (null == userInfo.getPic()) {
			userInfo.setDefaultAvatar();
		}

		mv.addObject("userInfo", userInfo);

		/**
		 * Get primary front category map.
		 */
		Map<Category, List<Category>> frontCategoryMap = CategoryRunner.getFrontCategoryMap();
		if(null == frontCategoryMap || frontCategoryMap.size() <= 0){
			throw new SeanForFunException("Blog Category setting error....");
		}else {
			mv.addObject("pfcategory", frontCategoryMap);
		}
		/**
		 * Get pagination info
		 */
		if(null == pageIndex){
			pageIndex = 1;
		}
		Integer articlePerPage = configBean.getMaxArticlePerPage();
		mv.addObject("pageIndex", pageIndex);
		/**
		 * Get 5 new blogs from database.
		 */
		List<Article> articles = articleService.getIndexPublicArticlesPagination(pageIndex, articlePerPage);
		mv.addObject("articles", articles);
		/**
		 * Blog access statistic update
		 */
		mv.setViewName("front/index.html");
		return mv;
	}
}
