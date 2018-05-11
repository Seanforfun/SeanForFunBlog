package ca.seanforfun.blog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ca.seanforfun.blog.exception.SeanForFunException;
import ca.seanforfun.blog.model.entity.config.ConfigBean;
import ca.seanforfun.blog.model.entity.entity.Article;
import ca.seanforfun.blog.model.entity.entity.Badge;
import ca.seanforfun.blog.model.entity.entity.Image;
import ca.seanforfun.blog.model.entity.entity.Link;
import ca.seanforfun.blog.model.entity.entity.Month;
import ca.seanforfun.blog.model.entity.entity.User;
import ca.seanforfun.blog.model.entity.vo.PaginationVo;
import ca.seanforfun.blog.model.entity.vo.UserVo;
import ca.seanforfun.blog.service.ebo.ArticleService;
import ca.seanforfun.blog.service.ebo.LinkService;
import ca.seanforfun.blog.service.ebo.MonthService;
import ca.seanforfun.blog.service.ebo.UserService;
import ca.seanforfun.blog.validator.ArticleWriteValidateGroup;

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
	@Autowired
	private MonthService monthService;

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateArticle(
			ModelAndView mv,
			@Validated(value = { ArticleWriteValidateGroup.class }) @ModelAttribute(value = "article") Article article,
			BindingResult bindingResult, String isPublic, String allowCmts,
			String badgeInfo, HttpSession session, Long article_id,
			String picInfo, String requestMethod) {
		String[] tokens = null;
		List<Image> imageList = null;
		
		if (picInfo != null) {
			tokens = picInfo.split("&&&");
			if (null != tokens && tokens.length >= 2) {
				imageList = new ArrayList<>();
				for (int i = 1; i < tokens.length; i++) {
					String token = tokens[i];
					String[] imagesInfo = token.split(";;;;");
					Image image = new Image();
					image.setName(imagesInfo[0]);
					image.setPath(imagesInfo[1]);
					image.setRemoveHash(imagesInfo[2]);
					imageList.add(image);
				}
			}
		}
		// Validation check
		if (bindingResult.hasFieldErrors()) {
			mv.addObject("article", article);
			mv.addObject("badgeInfo", badgeInfo);
			mv.addObject("isPublic", isPublic);
			mv.addObject("allowComments", allowCmts);
			mv.addObject("imageList", imageList);
			mv.addObject("picInfo", picInfo);
			mv.addObject("alertMessage", "Validation check error!");
			mv.setViewName("forward:/admin/toWrite");
			return mv;
		}
		// Toggle switch information save.
		if (isPublic != null && isPublic.equals("on")) {
			article.setType(Article.ARTICAL_PUBLIC);
		} else {
			article.setType(Article.ARTICAL_PRIVATE);
		}

		if (allowCmts != null && allowCmts.equals("on")) {
			article.setAllowComments(Article.ARTICLE_ALLOW_COMMENTS);
		} else {
			article.setAllowComments(Article.ARTICLE_DONT_ALLOW_COMMENTS);
		}

		// Resolve badge infomation
		if (null != badgeInfo && badgeInfo.trim().length() != 0) {
			String[] badges = badgeInfo.split(" ");
			Integer badgeLength = badges.length;
			if (badgeLength % 2 != 0) {
				mv.addObject("article", article);
				mv.addObject("badgeInfo", badgeInfo);
				mv.addObject("isPublic", isPublic);
				mv.addObject("allowComments", allowCmts);
				mv.addObject("imageList", imageList);
				mv.addObject("picInfo", picInfo);
				mv.addObject("alertMessage", "Validation check error!");
				mv.setViewName("forward:/admin/toWrite");
				return mv;
			}
			List<Badge> badgeList = new ArrayList<Badge>();
			for (int i = 0; i < badgeLength; i += 2) {
				Badge badge = new Badge();
				badge.setName(badges[i]);
				if (!Badge.colorMap.values().contains(
						badges[i + 1].toUpperCase())) {
					// If color doesn't exist, set to COLOR_INFO
					badge.setColor(Badge.COLOR_INFO);
				} else {
					badge.setColor(Badge.colorReverseMap.get(badges[i + 1]
							.toUpperCase()));
				}
				badgeList.add(badge);
			}
			article.setBadges(badgeList);
		} else {
			article.setBadges(null);
		}

		// Current article is only saved not published.
		article.setPublish(Article.ARTICLE_NOT_PUBLISH);
		article.setAuthor((User) session.getAttribute("loginUser"));

		if (null == article_id) {
			article = articleService.createArticle(article, imageList);
			mv.addObject("article", article);
		} else {
			article.setId(article_id);
			articleService.updateArticle(article);
		}
		
		if(requestMethod != null && requestMethod.equals("publish")){
			articleService.publishArticle(article.getId());
			mv.setViewName("redirect:/admin/toManageBlog/1");
			return mv;
		}

		// Save success, go back to writing page.
		mv.addObject("SaveSuccess", "SaveSuccess");
		mv.setViewName("forward:/admin/toWrite/" + article.getId());
		return mv;
	}
	
	@RequestMapping("/publish/{id}")
	public ModelAndView publishAricle(ModelAndView mv, @PathVariable("id") Long id){
		articleService.publishArticle(id);
		mv.setViewName("redirect:/admin/toManageBlog/1");
		return mv;
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteArticle(ModelAndView mv, @PathVariable("id") Long id){
		articleService.deleteArticleById(id);
		mv.setViewName("redirect:/admin/toManageBlog/1");
		return mv;
	}
	
	// ---------------------------------------AJAX---------------------------------------------------------
	@RequestMapping("/category/{category}/{pagenum}")
	public @ResponseBody PaginationVo getArticlesByCategory(
			@PathVariable("pagenum") Integer index,
			@PathVariable("category") Integer category, ModelAndView mv) {
		paginationVo.setCurrentPageNum(index);
		Integer numPerPage = configBean.getMaxArticlePerPage();
		paginationVo.setNumPerPage(numPerPage);
		Integer totalArticleNumByCategory = articleService
				.getArticleNumByCategory(category);
		paginationVo.calculationMaxPage(totalArticleNumByCategory, numPerPage);
		List<Article> articleByCategory = articleService.getArticleByCategory(
				category, index, numPerPage);
		paginationVo.setArticles(articleByCategory);
		List<Month> months = monthService.getArchiveInfo();
		paginationVo.setMonths(months);
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

	@RequestMapping(value = "/{id}")
	public @ResponseBody Article ajaxGetArticle(@PathVariable("id") Long id) {
		// Update article hit information
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
		List<Article> articles = articleService
				.getIndexPublicArticlesPagination(index, articlePerPage);
		paginationVo.setArticles(articles);
		return paginationVo;
	}
	
	@RequestMapping("/archives/{id}/{pageNum}")
	public @ResponseBody PaginationVo ajaxArchivesArticles(ModelAndView mv, @PathVariable("id") Long id, @PathVariable(value="pageNum",required=false) Integer pageNum){
		if(null == pageNum){
			paginationVo.setCurrentPageNum(1);
		}else{
			paginationVo.setCurrentPageNum(pageNum);
		}
		Integer numPerPage = configBean.getMaxArticlePerPage();
		paginationVo.setNumPerPage(numPerPage);
		Integer totalCount = articleService.getArchiveCountByMid(id);
		paginationVo.calculationMaxPage(totalCount, numPerPage);
		List<Article> articles = articleService.getArchivesArticles(id, paginationVo.getCurrentPageNum(), numPerPage);
		paginationVo.setArticles(articles);
		paginationVo.setArchiveId(id);
		return paginationVo;
	}
}
