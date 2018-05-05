package ca.seanforfun.blog.model.entity.entity;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 21, 2018 9:16:06 PM
 * @version 1.0
 */
public class Link {
	/**
	 * name: id
	 * type: Long 
	 * @Description: primary key
	 */
	private Long id;
	/**
	 * name: name
	 * type: String 
	 * @Description: Name of this link.
	 */
	private String name;
	/**
	 * name: link
	 * type: String 
	 * @Description:Path
	 */
	private String link;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
