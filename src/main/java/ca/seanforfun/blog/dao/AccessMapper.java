package ca.seanforfun.blog.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 25, 2018 1:50:36 PM
 * @version 1.0
 */
@Mapper
@Repository
public interface AccessMapper {
	@Insert("insert into access (dayAccessNum, currentTime) values (#{accessNum}, #{currentTimeMillis})")
	void createDailyAccessInfo(@Param("accessNum") Long accessNum,
			@Param("currentTimeMillis") long currentTimeMillis);

	@Select("select count(id) from access")
	Long getTotelCount();
	
	@Delete("DELETE FROM access WHERE id = #{old_id}")
	public void deleteOldAccessinfo(@Param("old_id") Long id);

	@Select("SELECT MIN(id) FROM access")
	public Long getOldestId();
}
