package ca.seanforfun.blog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ca.seanforfun.blog.config.runner.CategoryRunner;
import ca.seanforfun.blog.exception.SeanForFunException;
import ca.seanforfun.blog.model.entity.config.BlogInfo;
import ca.seanforfun.blog.model.entity.config.ConfigBean;
import ca.seanforfun.blog.model.entity.config.PaginationBean;
import ca.seanforfun.blog.model.entity.entity.Article;
import ca.seanforfun.blog.model.entity.entity.Category;
import ca.seanforfun.blog.model.entity.entity.Link;
import ca.seanforfun.blog.model.entity.entity.Month;
import ca.seanforfun.blog.model.entity.vo.UserVo;
import ca.seanforfun.blog.service.ebo.ArticleService;
import ca.seanforfun.blog.service.ebo.LinkService;
import ca.seanforfun.blog.service.ebo.MonthService;
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
	@Autowired
	private LinkService linkService;
	@Autowired
	private PaginationBean paginationBean;
	@Autowired
	private MonthService monthService;

	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv) throws Exception {
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
		if (null == userInfo.getPic() || userInfo.getPic().trim().length() == 0) {
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
		Integer articleTotalNum = articleService.getArticleTotalNum();
		Integer pageIndex = 1;
		Integer articlePerPage = configBean.getMaxArticlePerPage();
		paginationBean.setCurrentPageNum(pageIndex);
		paginationBean.setNumPerPage(articlePerPage);
		paginationBean.calculationMaxPage(articleTotalNum, articlePerPage);
		mv.addObject("pagination", paginationBean);
		/**
		 * Get 5 new blogs from database.
		 */
		List<Article> articles = articleService.getIndexPublicArticlesPagination(pageIndex, articlePerPage);
		mv.addObject("articles", articles);
		/**
		 * Load 3 new blogs with images.
		 */
		List<Article> imageArticles = articleService.getArticlesWithImages();
		mv.addObject("imageArticles", imageArticles);
		/**
		 * Get links from database
		 */
		List<Link> friendsLinks = linkService.getAllFriendsLinks();
		mv.addObject("links", friendsLinks);
		
		/**
		 * Get archive information from database.
		 */
		List<Month> months = monthService.getArchiveInfo();
		mv.addObject("months", months);
		
		/**
		 * Blog access statistic update
		 */
		BlogInfo.oneDayAccessTime.getAndIncrement();
		mv.setViewName("front/index.html");
		return mv;
	}
}
