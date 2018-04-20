package ca.seanforfun.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import ca.seanforfun.blog.model.entity.entity.Category;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 19, 2018 12:00:34 PM
 * @version 1.0
 */
@Mapper
@Repository
public interface CategoryMapper {
	@Cacheable("roleTypeCategory")
	@Select("select id, name, link, icon from category where categoryType = #{categoryType} and role = #{role} order by id")
	public List<Category> getCategoriesByCategoryTypeAndRole(@Param("categoryType") Integer categoryType,
			@Param("role") Integer role);

	@Cacheable("roleCategory")
	@Select("select id, name, pid, icon, link from category where role = #{role}")
	public List<Category> getCategoriesByRole(@Param("role") Integer role);
	
	@Cacheable("categoryNum")
	@Select("select count(name) from category where categoryType = #{categoryType} and role = #{role} ")
	public Long getCategoryNumByTypeAndRol(@Param("categoryType") Integer categoryType, @Param("role") Integer role);
	
	@Select("select name, icon, link from category where pid = #{pid}")
	public List<Category> getCategorieByPid(@Param("pid") Long pid);
}
