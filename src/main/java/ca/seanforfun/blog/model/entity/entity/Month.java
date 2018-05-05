package ca.seanforfun.blog.model.entity.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
	 * name: articleCount
	 * type: Integer 
	 * @Description: Number of articles published in this month.
	 */
	private Integer articleCount;
	
	private String dateView;
	public String getDateView() {
		return dateView;
	}
	public Integer getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
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
		this.dateView = new SimpleDateFormat("MMM, yyyy", Locale.CANADA).format(date);
	}
}
