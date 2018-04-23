package ca.seanforfun.blog.service.ebo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.seanforfun.blog.dao.UserMapper;
import ca.seanforfun.blog.exception.SeanForFunException;
import ca.seanforfun.blog.model.entity.entity.User;
import ca.seanforfun.blog.model.entity.vo.UserVo;
import ca.seanforfun.blog.service.ebi.UserEbi;

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
		List<UserVo> adminUsers =  userMapper.getUserByAdmin(adminType);
		if(null == adminUsers || adminUsers.size() != 1){
			throw new SeanForFunException("Admin user number error....");
		}
		return adminUsers.get(0);
	}
	
}
