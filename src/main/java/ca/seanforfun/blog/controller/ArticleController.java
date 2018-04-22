package ca.seanforfun.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ca.seanforfun.blog.model.entity.config.ConfigBean;
import ca.seanforfun.blog.model.entity.config.PaginationBean;
import ca.seanforfun.blog.model.entity.entity.Article;
import ca.seanforfun.blog.service.ebo.ArticleService;

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
	private PaginationBean paginationBean;

	@RequestMapping(value = "/{id}")
	public @ResponseBody Article ajaxGetArticle(@PathVariable("id") Long id) {
		return articleService.getArticleById(id);
	}

	@RequestMapping(value = "/page/{pagenum}")
	public @ResponseBody List<Article> ajaxGetArticleByPageindex(
			@PathVariable("pagenum") Integer index, ModelAndView mv) {
		/**
		 * Set information about pagination.
		 */
		Integer articleTotalNum = articleService.getArticleTotalNum();
		Integer articlePerPage = configBean.getMaxArticlePerPage();
		paginationBean.setCurrentPageNum(index);
		paginationBean.setNumPerPage(articlePerPage);
		paginationBean.calculationMaxPage(articleTotalNum, articlePerPage);
		mv.addObject("pagination", paginationBean);
		/**
		 * Get new Articles.
		 */
		return articleService.getIndexPublicArticlesPagination(index, articlePerPage);
	}
}
