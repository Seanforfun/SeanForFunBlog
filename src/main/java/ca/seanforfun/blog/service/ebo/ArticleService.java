package ca.seanforfun.blog.service.ebo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.seanforfun.blog.dao.ArticleMapper;
import ca.seanforfun.blog.exception.SeanForFunException;
import ca.seanforfun.blog.model.entity.entity.Article;
import ca.seanforfun.blog.service.ebi.ArticleEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 20, 2018 9:47:59 PM
 * @version 1.0
 */
@Service
public class ArticleService implements ArticleEbi{
	@Autowired
	private ArticleMapper articleMapper;
	
	@Override
	public Integer getArticleTotalNum() {
		return articleMapper.getArticalCount();
	}

	@Override
	public List<Article> getIndexPublicArticlesPagination(Integer pageIndex,
			Integer articlePerPage) {
		Integer currentPageIndex = (pageIndex - 1) * articlePerPage;
		List<Article> articles = articleMapper.getArticlePaginationByType(currentPageIndex, articlePerPage, Article.ARTICAL_PUBLIC);
		if(null == articles){
			throw new SeanForFunException("Article not read error....");
		}
		return articles;
	}

	@Override
	@Transactional
	public Article getArticleById(Long id) {
		// Get Ariticle information.
		Article article =  articleMapper.getArticleById(id);
		if(null == article){
			throw new SeanForFunException("Article not read error....");
		}
		
		//Update Article accessTime.
		Long articleId = article.getId();
		if(null == articleId){
			throw new SeanForFunException("Article id error...");
		}
		articleMapper.updateAccesstimeById(articleId);
		return article;
	}

	@Override
	public List<Article> getArticleByCategory(Integer categoryId, Integer currentPageNum, Integer numPerPage) {
		Integer currentIndex = (currentPageNum - 1) * numPerPage;
		return articleMapper.getArticalByCategoryId(categoryId, currentIndex, numPerPage, Article.ARTICAL_PUBLIC);
	}

	@Override
	public Integer getArticleNumByCategory(Integer category) {
		return articleMapper.getArticalCountByCategoryId(category);
	}

	@Override
	public List<Article> getArticlesWithImages() {
		List<Article> articles = articleMapper.getArticalsWithImage();
		return articles;
	}

}
