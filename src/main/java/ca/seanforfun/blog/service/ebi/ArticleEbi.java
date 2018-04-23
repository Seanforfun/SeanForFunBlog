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
	/**
	 * @Description: Get article Information according to article id.
	 * @Return: Article
	 */
	public Article getArticleById(Long id);
	/**
	 * @Description: Get article number according to category id.
	 * @Return: Integer
	 */
	Integer getArticleNumByCategory(Integer category);
	/**
	 * @Description: Get articles according to category id and pagination Information.
	 * @Return: List<Article>
	 */
	List<Article> getArticleByCategory(Integer categoryId, Integer currentPageNum, Integer numPerPage);
}