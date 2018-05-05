package ca.seanforfun.blog.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import ca.seanforfun.blog.model.entity.entity.Month;

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

	@Results(value = {
			@Result(column = "DATE", property = "date"),
			@Result(column = "id", property = "id"),
			@Result(column = "id", property = "articleCount", javaType = Integer.class, one=@One(select="ca.seanforfun.blog.dao.ArticleMapper.getArticleCountByMid")) })
	@Select("SELECT id, DATE FROM MONTH")
	public List<Month> getArticleCountList();
}
