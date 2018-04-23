package ca.seanforfun.blog.model.entity.entity;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 23, 2018 12:28:57 PM
 * @version 1.0
 */
public class Image {
	/**
	 * name: id
	 * type: Long 
	 * @Description:Primary key of Image.
	 */
	private Long id;
	/**
	 * name: path
	 * type: String 
	 * @Description:Image saved in the server or localpath.
	 */
	private String path;
	/**
	 * name: name
	 * type: String 
	 * @Description:Image name.
	 */
	private String name;
	/**
	 * name: aid
	 * type: Long 
	 * @Description: Article id.
	 */
	private Long aid;
	/**
	 * name: alid
	 * type: Long 
	 * @Description: Album id.
	 */
	private Long alid;
	public Long getAlid() {
		return alid;
	}
	public void setAlid(Long alid) {
		this.alid = alid;
	}
	public Long getAid() {
		return aid;
	}
	public void setAid(Long aid) {
		this.aid = aid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
