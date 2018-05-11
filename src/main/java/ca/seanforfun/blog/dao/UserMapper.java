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

	@Select("SELECT id, firstname, lastname, nickname, bio, intro, pic, activestatus FROM USER WHERE url like '${url}%'")
	public UserVo getUserByUrl(@Param("url") String url);

	@Select("SELECT id, firstname, lastname, bio, intro, password, country, province, city, email, nickname FROM USER WHERE id = #{id}")
	public User getUserById(@Param("id") Long id);

	@Select("SELECT id, firstname, lastname, nickname, bio, intro, pic, activestatus, country, province, city, email FROM USER WHERE admin=#{adminType}")
	public List<UserVo> getUserByAdmin(Integer adminType);

	@Cacheable("loginUser")
	@Select("SELECT admin, id, nickname, activestatus, firstname, lastname, PASSWORD, email, bio, country, province, city, url, intro, pic FROM USER WHERE firstname = #{firstname} and lastname = #{lastname} AND PASSWORD = #{password}")
	public User getUserByNameAndPassword(@Param("firstname") String firstname, @Param("lastname") String lastname,
			@Param("password") String password_hash);

	@Update("UPDATE USER SET lastLoginTime = #{currentTimeMillis}, ipAddr = #{loginIp} WHERE id = #{id}")
	public void updateUserLastLoginTime(@Param("currentTimeMillis") long currentTimeMillis, @Param("id") Long id, @Param("loginIp") String loginIp);

	@Update("UPDATE USER SET pic = #{imageInfo} WHERE admin = 1")
	public void updateAdminPic(@Param("imageInfo") String imageInfo);

	@Select("SELECT pic FROM USER WHERE admin = 1")
	public String getAvatar();

	@Update("UPDATE USER SET firstname = #{firstname}, nickname=#{nickname}, lastname=#{lastname}, bio=#{bio}, intro=#{intro}, PASSWORD=#{PASSWORD}, city=#{city}, province=#{province}, country=#{country}, email=#{email} WHERE id=#{id}")
	public void updateUserInfoById(@Param("id") Long id, @Param("firstname") String firstName,
			@Param("lastname") String lastName, @Param("PASSWORD") String password, @Param("bio") String bio, @Param("intro") String intro,
			@Param("country") String country, @Param("province") String province, @Param("city") String city, @Param("email") String email, @Param("nickname") String nickname);
}
