package ca.seanforfun.blog.service.ebo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.seanforfun.blog.dao.UserMapper;
import ca.seanforfun.blog.exception.SeanForFunException;
import ca.seanforfun.blog.model.entity.entity.User;
import ca.seanforfun.blog.model.entity.vo.UserVo;
import ca.seanforfun.blog.service.ebi.UserEbi;
import ca.seanforfun.blog.utils.MD5Utils;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 18, 2018 3:15:51 PM
 * @version 1.0
 */
@Service
public class UserService implements UserEbi {
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserVo getUserByUrl(String url) {
		return userMapper.getUserByUrl(url);
	}

	@Override
	public UserVo getAdmin() {
		Integer adminType = User.USER_ADMIN;
		List<UserVo> adminUsers = userMapper.getUserByAdmin(adminType);
		if (null == adminUsers || adminUsers.size() != 1) {
			throw new SeanForFunException("Admin user number error....");
		}
		return adminUsers.get(0);
	}

	@Override
	public User checkUserInfo(User user) {
		String name = user.getName();
		String password = user.getPassword();
		if (null == name || password == null) {
			return null;
		}
		String[] tokens = name.split(" ");
		if (tokens.length != 2) {
			return null;
		}
		String firstName = tokens[0];
		String lastName = tokens[1];
		String password_hash = MD5Utils.md5(password);
		return userMapper.getUserByNameAndPassword(firstName, lastName,
				password_hash);
	}

	@Override
	@Transactional
	public void loginUpdate(Long id, String loginIp) {
		userMapper.updateUserLastLoginTime(System.currentTimeMillis(), id,
				loginIp);
	}

	@Override
	@Transactional
	public void updateAdminPic(String imageInfo) {
		userMapper.updateAdminPic(imageInfo);
	}

	@Override
	public String getAdminAvatar() {
		String avatar = userMapper.getAvatar();
		if (null == avatar) {
			return "/images/avatar/avatar.jpg";
		}
		return avatar;
	}

	@Override
	public User getUserById(Long id) {
		return userMapper.getUserById(id);
	}

	@Override
	@Transactional
	public void updateUserInfo(User user) {
		userMapper.updateUserInfoById(user.getId(), user.getFirstName(),
				user.getLastName(), user.getPassword(), user.getBio(),
				user.getIntro(), user.getCountry(), user.getProvince(),
				user.getCity(), user.getEmail(), user.getNickname());
	}
}
