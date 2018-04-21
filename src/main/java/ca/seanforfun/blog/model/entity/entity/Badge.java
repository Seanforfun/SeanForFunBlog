package ca.seanforfun.blog.model.entity.entity;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 20, 2018 8:30:01 PM
 * @version 1.0
 */
public class Badge {
	/**
	 * name: id
	 * type: Long 
	 * @Description: Primary key of badge.
	 */
	private Long id;
	/**
	 * name: name
	 * type: String 
	 * @Description:Name of the badge.
	 */
	private String name;
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
}
