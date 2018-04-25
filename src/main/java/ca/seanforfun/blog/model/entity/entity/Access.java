package ca.seanforfun.blog.model.entity.entity;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 25, 2018 1:40:32 PM
 * @version 1.0
 */
public class Access {
	/**
	 * name: id
	 * type: Long 
	 * @Description: Primary key.
	 */
	private Long id;
	/**
	 * name: dayAccessNum
	 * type: Long 
	 * @Description: Access time in one single day.
	 */
	private Long dayAccessNum;
	/**
	 * name: currentTime
	 * type: Long 
	 * @Description:Current Time of writing the data.
	 */
	private Long currentTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDayAccessNum() {
		return dayAccessNum;
	}
	public void setDayAccessNum(Long dayAccessNum) {
		this.dayAccessNum = dayAccessNum;
	}
	public Long getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(Long currentTime) {
		this.currentTime = currentTime;
	}
}
