package ca.seanforfun.blog.service.ebi;

import java.util.List;

import ca.seanforfun.blog.model.entity.entity.Article;
import ca.seanforfun.blog.model.entity.entity.Image;

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

	/**
	 * @Description: Get images for the index.html on carousel.
	 * @Return: List<Article>
	 */
	List<Article> getArticlesWithImages();

	/**
	 * @Description:Get article number of specific user.
	 * @Return: Integer
	 */
	Integer getCountByUid(Long id);

	/**
	 * @return 
	 * @Description:Create article or update article.
	 * @Return: Article
	 */
	Article createArticle(Article article, List<Image> imageList);

	/**
	 * @Description:Update article information according to id.
	 * @Return: void
	 */
	void updateArticle(Article article);

	/**
	 * @Description:Publish an article.
	 * @Return: void
	 */
	void publishArticle(Long id);

	/**
	 * @Description:Get current user's article number.
	 * @Return: Integer
	 */
	Integer getArticleNumByUid(Long uid);

	/**
	 * @Description:Get paginationed article list from database.
	 * @Return: List<Article>
	 */
	List<Article> getPaginationArticleByUid(Long uid, Integer numPerPage,
			Integer pageNum);

	/**
	 * @Description:Admin get article to update.
	 * @Return: Article
	 */
	Article adminGetArticleById(Long id);

	/**
	 * @Description:Delete article according to id
	 * @Return: void
	 */
	void deleteArticleById(Long id);

	/**
	 * @Description: Get archive articles by month
	 * @Return: List<Article>
	 */
	List<Article> getArchivesArticles(Long id, Integer currentPageNum,
			Integer numPerPage);

	/**
	 * @Description: Get archive article count by month
	 * @Return: Integer
	 */
	Integer getArchiveCountByMid(Long mid);
}
