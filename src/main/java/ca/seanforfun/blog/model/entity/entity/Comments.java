package ca.seanforfun.blog.model.entity.entity;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 30, 2018 12:27:02 PM
 * @version 1.0
 */
public class Comments {
	/**
	 * name: id
	 * type: Long 
	 * @Description: Primary key of comments. NOT NULL
	 */
	private Long id;
	/**
	 * name: content
	 * type: String 
	 * @Description:Content of comments. NOT NULL
	 */
	private String content;
	/**
	 * name: time
	 * type: Long 
	 * @Description:Time of sending comments.
	 */
	private Long time;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
}
