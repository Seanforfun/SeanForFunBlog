package ca.seanforfun.blog.model.entity.entity;

import java.util.Date;
import java.util.List;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date May 5, 2018 3:52:01 PM
 * @version 1.0
 */
public class Month {
	/**
	 * name: id
	 * type: Long 
	 * @Description:The primary key of month.
	 */
	private Long id;
	/**
	 * name: date
	 * type: Date 
	 * @Description: The date of the month.
	 */
	private Date date;
	/**
	 * name: articleList
	 * type: List<Article> 
	 * @Description: Articles published in this month.
	 */
	private List<Article> articleList;
	public List<Article> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
