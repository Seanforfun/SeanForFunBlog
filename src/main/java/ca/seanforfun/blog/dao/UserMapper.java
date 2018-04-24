package ca.seanforfun.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import ca.seanforfun.blog.model.entity.entity.User;
import ca.seanforfun.blog.model.entity.vo.UserVo;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 18, 2018 2:33:32 PM
 * @version 1.0
 */
@Mapper
@Repository
public interface UserMapper {

	@Select("SELECT id, name, nickname, bio, intro, pic, activestatus FROM USER WHERE url like '${url}%'")
	@Cacheable("user")
	public UserVo getUserByUrl(@Param("url") String url);

	@Select("SELECT id, name FROM USER WHERE id = #{id}")
	public User getUserById(@Param("id") Long id);

	@Cacheable("admin")
	@Select("SELECT id, NAME, nickname, bio, intro, pic, activestatus FROM USER WHERE admin=#{adminType}")
	public List<UserVo> getUserByAdmin(Integer adminType);

	@Cacheable("loginUser")
	@Select("SELECT id, nickname, activestatus, NAME, PASSWORD, email, bio, country, province, city, url, intro, pic FROM USER WHERE NAME = #{name} AND PASSWORD = #{password}")
	public User getUserByNameAndPassword(@Param("name") String name,
			@Param("password") String password_hash);

	@Update("UPDATE USER SET lastLoginTime = #{currentTimeMillis}, ipAddr = #{loginIp} WHERE id = #{id}")
	public void updateUserLastLoginTime(@Param("currentTimeMillis") long currentTimeMillis, @Param("id") Long id, @Param("loginIp") String loginIp);
}
