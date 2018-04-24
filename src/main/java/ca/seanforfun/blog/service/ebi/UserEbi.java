package ca.seanforfun.blog.service.ebi;

import ca.seanforfun.blog.model.entity.entity.User;
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
	
	/**
	 * @Description: Get admin user.
	 * @Return: UserVo
	 */
	public UserVo getAdmin();

	/**
	 * @Description: Check if user is existing. 
	 * @Return: User
	 */
	public User checkUserInfo(User user);

	/**
	 * @Description: Update user information when user login.
	 * @Return: void
	 */
	void loginUpdate(Long id, String loginIp);
}
