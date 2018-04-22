package ca.seanforfun.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.seanforfun.blog.model.entity.entity.Article;
import ca.seanforfun.blog.service.ebo.ArticleService;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 21, 2018 7:36:33 PM
 * @version 1.0
 */
@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@RequestMapping(value="/article/{id}")
	public @ResponseBody Article ajaxGetArticle(@PathVariable("id") Long id){
		return articleService.getArticleById(id);
	}
}
