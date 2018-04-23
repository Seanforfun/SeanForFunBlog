package ca.seanforfun.blog.model.entity.vo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ca.seanforfun.blog.model.entity.config.PaginationBean;
import ca.seanforfun.blog.model.entity.entity.Article;

@Component
@Scope("prototype")
public class PaginationVo extends PaginationBean {
	private List<Article> articles;

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
