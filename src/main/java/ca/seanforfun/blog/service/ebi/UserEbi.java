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

	/**
	 * @Description: Update admin avatar information.
	 * @Return: void
	 */
	void updateAdminPic(String imageInfo);

	/**
	 * @Description:Get admin's avatar from database.
	 * @Return: String
	 */
	String getAdminAvatar();

	/**
	 * @Description:Get user from db by id.
	 * @Return: User
	 */
	User getUserById(Long id);

	/**
	 * @Description:Update User information.
	 * @Return: void
	 */
	void updateUserInfo(User user);
}
