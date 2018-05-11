package ca.seanforfun.blog.model.entity.entity;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ca.seanforfun.blog.utils.FormatUtils;
import ca.seanforfun.blog.validator.UpdateAdminValidator;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 18, 2018 1:33:39 PM
 * @version 1.0
 */
public class User {
	public static final Integer USER_ACTIVED = 1;
	public static final Integer USER_NOT_ACTIVED = 0;
	public static final Integer USER_ADMIN = 1;
	public static final Integer USER_NOT_ADMIN = 0;
	public static final String USER_ADMIN__VIEW = "admin";
	public static final String USER_NOT_ADMIN_VIEW = "not admin";
	public static final Map<Integer, String> ADMIN_MAP = new HashMap<Integer, String>();
	
	static{
		ADMIN_MAP.put(USER_ADMIN, USER_ADMIN__VIEW);
		ADMIN_MAP.put(USER_NOT_ADMIN, USER_NOT_ADMIN_VIEW);
	}
	
	private Long id;
	/**
	 * User information
	 */
	private String nickname;
	@NotNull(groups={UpdateAdminValidator.class})
	@Size(min=1, max=100, groups={UpdateAdminValidator.class})
	private String firstName;
	@NotNull(groups={UpdateAdminValidator.class})
	@Size(min=1, max=100, groups={UpdateAdminValidator.class})
	private String lastName;
	private String name;
	@NotNull(groups={UpdateAdminValidator.class})
	@Size(min=1, max=40, groups={UpdateAdminValidator.class})
	private String password;
	@NotNull(groups={UpdateAdminValidator.class})
	@Size(min=1, max=100, groups={UpdateAdminValidator.class})
	private String email;
	@NotNull(groups={UpdateAdminValidator.class})
	private String bio;
	@NotNull(groups={UpdateAdminValidator.class})
	private String intro;
	private String pic;
	
	/**
	 * User location
	 */
	@Size(min=0, max=60, groups={UpdateAdminValidator.class})
	private String country;
	@Size(min=0, max=60, groups={UpdateAdminValidator.class})
	private String province;
	@Size(min=0, max=60, groups={UpdateAdminValidator.class})
	private String city;
	
	/**
	 * Blog control
	 */
	private Long activeTime;
	private Long lastLoginTime;
	private String url;
	private String ipAddr;
	
	/**
	 * 0: Not activate by e-mail
	 * 1: Activated by e-mail 
	 */
	private Integer activestatus;
	/**
	 * name: admin
	 * type: Integer 
	 * @Description:
	 * 1: admin
	 * 0: not admin
	 */
	private Integer admin;
	
	private String activateTimeView;
	private String lastLoginTimeView;
	private String adminView;
	
	public String getAdminView() {
		return adminView;
	}
	public String getActivateTimeView() {
		return activateTimeView;
	}
	public String getLastLoginTimeView() {
		return lastLoginTimeView;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getActiveTime() {
		return activeTime;
	}
	public void setActiveTime(Long activeTime) {
		this.activeTime = activeTime;
		activateTimeView = FormatUtils.formatDate(activeTime);
	}
	public Long getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
		lastLoginTimeView = FormatUtils.formatDateTime(lastLoginTime);
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getActivestatus() {
		return activestatus;
	}
	public void setActivestatus(Integer activestatus) {
		this.activestatus = activestatus;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Integer getAdmin() {
		return admin;
	}
	public void setAdmin(Integer admin) {
		this.admin = admin;
		this.adminView = ADMIN_MAP.get(admin);
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
