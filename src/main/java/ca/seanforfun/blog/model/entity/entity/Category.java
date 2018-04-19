package ca.seanforfun.blog.model.entity.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 19, 2018 10:42:52 AM
 * @version 1.0
 */
public class Category {
	public final static Integer PRIMARY_CATEGORY = 0;
	public final static Integer SECONDARY_CATEGORY = 1;
	public final static Integer FRONT_PAGE = 0;
	public final static Integer ADMIN_PAGE = 1;
	private final static Map<Integer, String> CATEGORY_TYPE_VIEW_MAP = new HashMap<>();
	private final static Map<Integer, String> ROLE_VIEW_MAP = new HashMap<>();
	
	static{
		CATEGORY_TYPE_VIEW_MAP.put(PRIMARY_CATEGORY, "Primary");
		CATEGORY_TYPE_VIEW_MAP.put(SECONDARY_CATEGORY, "Secondary");
		ROLE_VIEW_MAP.put(FRONT_PAGE, "Front");
		ROLE_VIEW_MAP.put(ADMIN_PAGE, "Admin");
	}
	/**
	 * id: Primary key of current Category.
	 */
	private Long id;
	/**
	 * name: category_type
	 * type: Integer 
	 * @Description	0: Primary category, 1: sub level category.
	 * 							Refers to PRIMARY_CATEGORY and SECONDARY_CATEGORY.
	 */
	private Integer categoryType;
	/**
	 * name: pid
	 * type: Long 
	 * @Description If it is a secondary category, pid value records it's primary category id.
	 * if it is a primary category, this value is null.
	 * if it is a secondary category, this value refers corresponding id of primary category.
	 * Can be null
	 */
	private Long pid;
	/**
	 * name: Name of current catefory. Not null.
	 */
	private String name;
	/**
	 * name: uid
	 * type: Long 
	 * @Description Which user this category belongs to. Not null.
	 */
	private Long uid;
	/**
	 * name: icon
	 * type: String 
	 * @Description Icon of current category, can be null.
	 */
	private String icon;
	/**
	 * name: link
	 * type: String 
	 * @Description Link of current category.
	 * Null: PRIMARY_CATEGORY
	 * Not null: SECONDARY_CATEGORY
	 */
	private String link;
	/**
	 * name: role
	 * type: Integer 
	 * @Description	Determine current column belongs to front or admin. Not null.
	 * FRONT_PAGE: Belongs to front pages.
	 * ADMIN_PAGE: Belongs to admin pages.
	 */
	private Integer role;
	
	/**
	 * name: roleView
	 * type: String 
	 * @Description String representation of role.
	 */
	private String roleView;
	/**
	 * name: categoryTypeView
	 * type: String 
	 * @Description String representation of categoryType.
	 */
	private String categoryTypeView;
	
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
		this.roleView = ROLE_VIEW_MAP.get(role);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(Integer category_type) {
		this.categoryType = category_type;
		this.categoryTypeView = CATEGORY_TYPE_VIEW_MAP.get(category_type);
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRoleView() {
		return roleView;
	}
	public String getCategoryTypeView() {
		return categoryTypeView;
	}
}
