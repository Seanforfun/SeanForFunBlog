package ca.seanforfun.blog.model.entity.vo;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ca.seanforfun.blog.model.entity.config.PaginationBean;
import ca.seanforfun.blog.model.entity.entity.Article;
import ca.seanforfun.blog.model.entity.entity.Link;
import ca.seanforfun.blog.model.entity.entity.Month;

@Component
@Scope("prototype")
public class PaginationVo extends PaginationBean {
	private Long archiveId;
	private List<Article> articles;
	private UserVo userVo;
	private List<Link> links;
	private List<Month> months;
	public List<Month> getMonths() {
		return months;
	}

	public void setMonths(List<Month> months) {
		this.months = months;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public UserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public Long getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Long archiveId) {
		this.archiveId = archiveId;
	}
}
