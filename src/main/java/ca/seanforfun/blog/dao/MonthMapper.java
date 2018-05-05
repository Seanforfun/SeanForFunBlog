package ca.seanforfun.blog.dao;

import java.sql.Timestamp;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date May 5, 2018 4:04:44 PM
 * @version 1.0
 */
@Repository
@Mapper
public interface MonthMapper {
	@Insert("insert into month (date) values (#{time})")
	public void addMonth(@Param("time") Timestamp time);
	
	@Select("SELECT MAX(id) FROM MONTH")
	public Long getCurrentMonthId();
}
