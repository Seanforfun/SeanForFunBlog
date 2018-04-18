package ca.seanforfun.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import ca.seanforfun.blog.model.entity.vo.UserVo;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 18, 2018 2:33:32 PM
 * @version 1.0
 */
@Mapper
@Repository
public interface UserMapper {

	@Select("SELECT name, nickname, bio, intro, pic FROM USER WHERE url=#{url}")
	@Cacheable("user")
	public UserVo getUserByUrl(@Param("url") String url);

}
