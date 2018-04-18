package ca.seanforfun.blog.model.entity.entity;

import ca.seanforfun.blog.utils.FormatUtils;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 18, 2018 1:33:39 PM
 * @version 1.0
 */
public class User {
	public static final Integer USER_ACTIVED = 0;
	public static final Integer USER_NOT_ACTIVED = 1;
	
	private Long id;
	/**
	 * User information
	 */
	private String nickname;
	private String name;
	private String password;
	private String email;
	private String bio;
	private String intro;
	
	/**
	 * User location
	 */
	private String country;
	private String province;
	private String city;
	
	/**
	 * Blog control
	 */
	private Long activeTime;
	private Long lastLoginTime;
	private String url;
	
	/**
	 * 0: Not activate by e-mail
	 * 1: Activated by e-mail 
	 */
	private Integer activestatus;
	
	private String activateTimeView;
	private String lastLoginTimeView;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
}
