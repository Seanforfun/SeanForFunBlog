package ca.seanforfun.blog.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 30, 2018 12:51:34 PM
 * @version 1.0
 */
@Repository
@Mapper
public interface BadgeMapper {
	@Insert("INSERT INTO badge (NAME, color) VALUES (#{name}, #{color})")
	public void createBadge(@Param("name") String name, @Param("color") Integer color);
	
	@Select("SELECT id FROM badge WHERE NAME=#{name} AND color=#{color}")
	public Long getBadgeByNameAndColor(@Param("name") String name, @Param("color") Integer color);

	@Select("select LAST_INSERT_ID()")
	public Long getLastInsertId();
}
