package ca.seanforfun.blog.model.entity.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ca.seanforfun.blog.utils.FormatUtils;
import ca.seanforfun.blog.validator.ArticleWriteValidateGroup;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 20, 2018 7:41:04 PM
 * @version 1.0
 */
public class Article {
	public static final Integer ARTICAL_PUBLIC = 0;
	public static final Integer ARTICAL_PRIVATE = 1;
	private static final String ARTICAL_PUBLIC_VIEW = "public";
	private static final String ARTICAL_PRIVATE_VIEW = "private";
	public static final Integer ARTICLE_PUBLISH = 1;
	public static final Integer ARTICLE_NOT_PUBLISH = 0;
	public static final Integer ARTICLE_ALLOW_COMMENTS = 1;
	public static final Integer ARTICLE_DONT_ALLOW_COMMENTS = 0;
	public static final Integer ARTICLE_INUSE = 1;
	public static final Integer ARTICLE_DELETE = 0;
	public static final Map<Integer, String> articleTypeMap  = new HashMap<>();
	static{
		articleTypeMap.put(ARTICAL_PRIVATE, ARTICAL_PRIVATE_VIEW);
		articleTypeMap.put(ARTICAL_PUBLIC, ARTICAL_PUBLIC_VIEW);
	}
	/**
	 * name: id
	 * type: Long 
	 * @Description: Primary key of article.
	 */
	private Long id;
	/**
	 * name: title
	 * type: String 
	 * @Description: Title of currrent article.
	 */
	@NotNull(groups={ArticleWriteValidateGroup.class})
	@Size(min=1, groups={ArticleWriteValidateGroup.class})
	private String title;
	/**
	 * name: cid
	 * type: Long 
	 * @Description: Which category this article belongs to.
	 */
	@NotNull(groups={ArticleWriteValidateGroup.class})
	private Long cid;
	
	/**
	 * name: type
	 * type: Integer 
	 * @Description: 0-public, 1-private
	 */
	private Integer type;
	/**
	 * name: badges
	 * type: List<Badge> 
	 * @Description: Badges assigned to this artical. 
	 * Can be null.
	 */
	private List<Badge> badges;
	/**
	 * name: hit
	 * type: Long 
	 * @Description:Viewed number of this artical.
	 */
	private Long hit;
	
	/**
	 * name: lastModifyTime
	 * type: Long 
	 * @Description: Last time of save or publish.
	 * Not null.
	 */
	private Long lastModifyTime;
	
	/**
	 * name: publishTime
	 * type: Long 
	 * @Description: First publish time.
	 * Can be null.
	 */
	private Long publishTime;
	
	/**
	 * name: uid
	 * type: Integer 
	 * @Description:Which user this artical belongs to.
	 */
	private User author;
	/**
	 * name: abst
	 * type: String 
	 * @Description: Abstract of current artical.
	 * Not null.
	 */
	@NotNull(groups={ArticleWriteValidateGroup.class})
	private String abst;
	/**
	 * name: content
	 * type: String 
	 * @Description:Content of current article.
	 */
	@NotNull(groups={ArticleWriteValidateGroup.class})
	@Size(min=1, groups={ArticleWriteValidateGroup.class})
	private String content;
	private List<Image> images;
	/**
	 * name: publish
	 * type: Integer 
	 * @Description:If current article is published.
	 * 1-published 0-not published
	 */
	private Integer publish;
	
	/**
	 * name: allowComments
	 * type: Integer 
	 * @Description: If current article allows comments.
	 * 0 - Don't allow 1-allow
	 */
	private Integer allowComments;
	/**
	 * name: category
	 * type: Category 
	 * @Description:The category of the blog belongs to. 
	 */
	private Category category;
	
	/**
	 * name: inuse
	 * type: Integer 
	 * @Description: Default in use, will alter to 0 after delete the blog.
	 */
	private Integer inuse;
	
	
	/**
	 * name: mid
	 * type: Long 
	 * @Description: Foreign key to month info.
	 * NOT NULL
	 */
	private Long mid;
	
	private String typeView;
	private String lastModifyTimeView;
	private String publishTimeView;
	
	/**
	 * name: accessTime
	 * type: Long 
	 * @Description: The number of the article be viewed.
	 */
	private Long accessTime;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Integer getAllowComments() {
		return allowComments;
	}
	public void setAllowComments(Integer allowComments) {
		this.allowComments = allowComments;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
		this.typeView = articleTypeMap.get(type);
	}
	public List<Badge> getBadges() {
		return badges;
	}
	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	public Long getLastModifyTime() {
		return lastModifyTime;
	}
	public void setLastModifyTime(Long lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
		this.lastModifyTimeView = FormatUtils.formatDateTime(lastModifyTime);
	}
	public Long getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Long publishTime) {
		this.publishTime = publishTime;
		this.publishTimeView = FormatUtils.formatDate(publishTime);
	}
	public String getAbst() {
		return abst;
	}
	public void setAbst(String abst) {
		this.abst = abst;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTypeView() {
		return typeView;
	}
	public String getLastModifyTimeView() {
		return lastModifyTimeView;
	}
	public String getPublishTimeView() {
		return publishTimeView;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public Long getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(Long accessTime) {
		this.accessTime = accessTime;
	}
	public Integer getPublish() {
		return publish;
	}
	public void setPublish(Integer publish) {
		this.publish = publish;
	}
	public Integer getInuse() {
		return inuse;
	}
	public void setInuse(Integer inuse) {
		this.inuse = inuse;
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
}
