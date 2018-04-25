package ca.seanforfun.blog.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 25, 2018 1:50:36 PM
 * @version 1.0
 */
@Mapper
public interface AccessMapper {
	@Insert("insert into access (dayAccessNum, currentTime) values (#{accessNum}, #{currentTimeMillis})")
	void createDailyAccessInfo(@Param("accessNum") Long accessNum,
			@Param("currentTimeMillis") long currentTimeMillis);
}
