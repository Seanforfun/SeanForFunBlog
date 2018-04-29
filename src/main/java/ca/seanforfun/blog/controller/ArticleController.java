package ca.seanforfun.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ca.seanforfun.blog.exception.SeanForFunException;
import ca.seanforfun.blog.model.entity.config.ConfigBean;
import ca.seanforfun.blog.model.entity.entity.Article;
import ca.seanforfun.blog.model.entity.entity.Link;
import ca.seanforfun.blog.model.entity.vo.PaginationVo;
import ca.seanforfun.blog.model.entity.vo.UserVo;
import ca.seanforfun.blog.service.ebo.ArticleService;
import ca.seanforfun.blog.service.ebo.LinkService;
import ca.seanforfun.blog.service.ebo.UserService;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 21, 2018 7:36:33 PM
 * @version 1.0
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ConfigBean configBean;
	@Autowired
	private PaginationVo paginationVo;
	@Autowired
	private UserService userService;
	@Autowired
	private LinkService linkService;
	
	@RequestMapping("/category/{category}/{pagenum}")
	public @ResponseBody PaginationVo getArticlesByCategory(@PathVariable("pagenum") Integer index, @PathVariable("category") Integer category, ModelAndView mv){
		paginationVo.setCurrentPageNum(index);
		Integer numPerPage = configBean.getMaxArticlePerPage();
		paginationVo.setNumPerPage(numPerPage);
		Integer totalArticleNumByCategory = articleService.getArticleNumByCategory(category);
		paginationVo.calculationMaxPage(totalArticleNumByCategory, numPerPage);
		List<Article> articleByCategory = articleService.getArticleByCategory(category, index, numPerPage);
		paginationVo.setArticles(articleByCategory);
		/**
		 * Get admin user information.
		 */
		UserVo userInfo = userService.getAdmin();

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
		paginationVo.setUserVo(userInfo);
		/**
		 * Get links from database
		 */
		List<Link> friendsLinks = linkService.getAllFriendsLinks();
		paginationVo.setLinks(friendsLinks);
		return paginationVo;
	}
	
	//---------------------------------------AJAX---------------------------------------------------------
	@RequestMapping(value = "/{id}")
	public @ResponseBody Article ajaxGetArticle(@PathVariable("id") Long id) {
		//Update article hit information
		Article article = articleService.getArticleById(id);
		return article;
	}

	@RequestMapping(value = "/page/{pagenum}")
	public @ResponseBody PaginationVo ajaxGetArticleByPageindex(
			@PathVariable("pagenum") Integer index, ModelAndView mv) {
		/**
		 * Set information about pagination.
		 */
		Integer articleTotalNum = articleService.getArticleTotalNum();
		Integer articlePerPage = configBean.getMaxArticlePerPage();
		paginationVo.setCurrentPageNum(index);
		paginationVo.setNumPerPage(articlePerPage);
		paginationVo.calculationMaxPage(articleTotalNum, articlePerPage);
		/**
		 * Get new Articles.
		 */
		List<Article> articles = articleService.getIndexPublicArticlesPagination(index, articlePerPage);
		paginationVo.setArticles(articles);
		return paginationVo;
	}
}
