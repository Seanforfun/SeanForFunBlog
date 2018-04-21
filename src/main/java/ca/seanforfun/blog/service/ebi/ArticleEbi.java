package ca.seanforfun.blog.service.ebi;

import java.util.List;

import ca.seanforfun.blog.model.entity.entity.Article;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 20, 2018 9:46:24 PM
 * @version 1.0
 */
public interface ArticleEbi {
	/**
	 * @Description: Get totel article number.
	 * @Return: Integer
	 */
	public Integer getArticleTotalNum();
	
	/**
	 * @Description:Get public articles for articles on index page with pagination.
	 * @Return: List<Article>
	 */
	public List<Article> getIndexPublicArticlesPagination(Integer pageIndex, Integer articlePerPage);
}
