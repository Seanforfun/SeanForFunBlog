package ca.seanforfun.blog.model.entity.entity;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 23, 2018 12:38:39 PM
 * @version 1.0
 */
public class Album {
	/**
	 * name: id
	 * type: Long 
	 * @Description:Primary key of Album.
	 */
	private Long id;
	/**
	 * name: name
	 * type: String 
	 * @Description: Name of the album.
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
