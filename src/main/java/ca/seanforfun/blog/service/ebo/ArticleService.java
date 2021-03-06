package ca.seanforfun.blog.service.ebo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.seanforfun.blog.dao.ArticleMapper;
import ca.seanforfun.blog.dao.BadgeMapper;
import ca.seanforfun.blog.dao.ImageMapper;
import ca.seanforfun.blog.dao.MonthMapper;
import ca.seanforfun.blog.exception.SeanForFunException;
import ca.seanforfun.blog.model.entity.entity.Article;
import ca.seanforfun.blog.model.entity.entity.Badge;
import ca.seanforfun.blog.model.entity.entity.Image;
import ca.seanforfun.blog.service.ebi.ArticleEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 20, 2018 9:47:59 PM
 * @version 1.0
 */
@Service
public class ArticleService implements ArticleEbi {
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private BadgeMapper badgeMapper;
	@Autowired
	private ImageMapper imageMapper;
	@Autowired
	private MonthMapper monthMapper;

	@Override
	public Integer getArticleTotalNum() {
		return articleMapper.getArticalCount(Article.ARTICLE_INUSE);
	}

	@Override
	public List<Article> getIndexPublicArticlesPagination(Integer pageIndex,
			Integer articlePerPage) {
		Integer currentPageIndex = (pageIndex - 1) * articlePerPage;
		List<Article> articles = articleMapper.getArticlePaginationByType(
				currentPageIndex, articlePerPage, Article.ARTICAL_PUBLIC,
				Article.ARTICLE_INUSE);
		if (null == articles) {
			throw new SeanForFunException("Article not read error....");
		}
		return articles;
	}

	@Override
	@Transactional
	public Article getArticleById(Long id) {
		// Get Ariticle information.
		Article article = articleMapper.getArticleById(id);
		if (null == article) {
			throw new SeanForFunException("Article not read error....");
		}

		// Update Article accessTime.
		Long articleId = article.getId();
		if (null == articleId) {
			throw new SeanForFunException("Article id error...");
		}
		articleMapper.updateAccesstimeById(articleId);
		return article;
	}

	@Override
	public Article adminGetArticleById(Long id) {
		// Get Ariticle information.
		Article article = articleMapper.getArticleById(id);
		if (null == article) {
			throw new SeanForFunException("Article not read error....");
		}
		return article;
	}

	@Override
	public List<Article> getArticleByCategory(Integer categoryId,
			Integer currentPageNum, Integer numPerPage) {
		Integer currentIndex = (currentPageNum - 1) * numPerPage;
		return articleMapper.getArticalByCategoryId(categoryId, currentIndex,
				numPerPage, Article.ARTICAL_PUBLIC, Article.ARTICLE_INUSE);
	}

	@Override
	public Integer getArticleNumByCategory(Integer category) {
		return articleMapper.getArticalCountByCategoryId(category, Article.ARTICLE_INUSE);
	}

	@Override
	public List<Article> getArticlesWithImages() {
		List<Article> articles = articleMapper.getArticalsWithImage();
		return articles;
	}

	@Override
	public Integer getCountByUid(Long id) {
		Long count = articleMapper.getArticleCountByUid(id, Article.ARTICLE_INUSE);
		if (null == count) {
			throw new SeanForFunException("Get article information error...");
		}
		return count.intValue();
	}

	@Override
	@Transactional
	public Article createArticle(Article article, List<Image> imageList) {
		// Create new Article object in database.
		articleMapper.createArticle(article.getTitle(), article.getCid(),
				article.getType(), 0L, System.currentTimeMillis(), article
						.getAuthor().getId(), article.getAbst(), article
						.getContent(), 0L, Article.ARTICLE_NOT_PUBLISH, article
						.getAllowComments());
		Long articleId = articleMapper.findLastInsertId();
		article.setId(articleId);

		if (imageList != null && imageList.size() > 0) {
			for (Image image : imageList) {
				imageMapper.createImageByAid(image.getPath(),
						image.getRemoveHash(), articleId, image.getName());
			}
		}

		// Save badges information in article_badge table.
		if (null != article.getBadges()) {
			List<Badge> badges = article.getBadges();
			for (Badge b : badges) {
				String name = b.getName();
				Integer color = b.getColor();
				Long badgeId = null;
				badgeId = badgeMapper.getBadgeByNameAndColor(name, color);
				if (null == badgeId) {
					badgeMapper.createBadge(name, color);
					badgeId = badgeMapper.getLastInsertId();
				}
				articleMapper.saveBagesInfo(articleId, badgeId);
			}
		}

		return article;
	}

	@Override
	@Transactional
	public void updateArticle(Article article) {
		articleMapper.updateArticle(article.getTitle(), article.getCid(),
				article.getType(), System.currentTimeMillis(),
				article.getAbst(), article.getContent(),
				article.getAllowComments(), article.getId());
	}

	@Override
	public void publishArticle(Long id) {
		Long mid = monthMapper.getCurrentMonthId();
		articleMapper.updateArticlePublishById(id, System.currentTimeMillis(),
				Article.ARTICLE_PUBLISH, mid);
	}

	@Override
	public Integer getArticleNumByUid(Long uid) {
		return articleMapper.getArticleCountByUid(uid, Article.ARTICLE_INUSE).intValue();
	}

	@Override
	public List<Article> getPaginationArticleByUid(Long uid,
			Integer numPerPage, Integer pageNum) {
		return articleMapper.getArticlePaginationByUid(uid, (pageNum - 1)
				* numPerPage, numPerPage);
	}

	@Override
	public void deleteArticleById(Long id) {
		articleMapper.deleteArticleById(id);
	}
	
	@Override
	public List<Article> getArchivesArticles(Long id, Integer currentPageNum, Integer numPerPage){
		return articleMapper.getPaginationArticleByMid(id, Article.ARTICLE_INUSE, Article.ARTICAL_PUBLIC, (currentPageNum - 1) * numPerPage, numPerPage);
	}
	
	@Override
	public Integer getArchiveCountByMid(Long mid){
		return articleMapper.getArticleCountByMid(mid);
	}
}
