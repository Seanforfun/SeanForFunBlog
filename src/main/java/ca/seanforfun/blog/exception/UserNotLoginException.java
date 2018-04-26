package ca.seanforfun.blog.exception;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 26, 2018 3:21:35 PM
 * @version 1.0
 */
@SuppressWarnings("serial")
public class UserNotLoginException extends Exception {

	public UserNotLoginException() {
		super();
	}

	public UserNotLoginException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserNotLoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotLoginException(String message) {
		super(message);
	}

	public UserNotLoginException(Throwable cause) {
		super(cause);
	}
}
