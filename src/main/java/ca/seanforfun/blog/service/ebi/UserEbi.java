package ca.seanforfun.blog.service.ebi;

import ca.seanforfun.blog.model.entity.vo.UserVo;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 18, 2018 3:12:10 PM
 * @version 1.0
 */
public interface UserEbi {
	/**
	 * @Description: Get user information according to current url.
	 * @param url get from request scope.
	 * @return
	 */
	public UserVo getUserByUrl(String url);
}