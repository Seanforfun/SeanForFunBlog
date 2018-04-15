package ca.seanforfun.blog.exception;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 14, 2018 10:27:23 PM
 * @version 1.0
 */
@SuppressWarnings("serial")
public class SeanForFunException extends RuntimeException {

	public SeanForFunException() {
		super();
	}
	public SeanForFunException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public SeanForFunException(String message, Throwable cause) {
		super(message, cause);
	}
	public SeanForFunException(String message) {
		super(message);
	}
	public SeanForFunException(Throwable cause) {
		super(cause);
	}
}
