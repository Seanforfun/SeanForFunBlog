package ca.seanforfun.blog.model.entity.vo;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 24, 2018 3:53:46 PM
 * @version 1.0
 */
public class Alert {
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Alert(String message){
		this.message = message;
	}
}
