package ca.seanforfun.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import ca.seanforfun.blog.model.entity.entity.Link;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 21, 2018 9:22:32 PM
 * @version 1.0
 */
@Mapper
@Repository
public interface LinkMapper {
	
	@Cacheable("links")
	@Select("select * from link")
	public List<Link> getAllLinks();
	
	@Select("SELECT COUNT(id) FROM link")
	public Long getLinkCount();

	@Select("SELECT id,NAME,link FROM link LIMIT #{start}, #{numPerPage}")
	public List<Link> getLinksByPage(@Param("start") Integer start, @Param("numPerPage") Integer numPerPage);

	@Delete("DELETE FROM link WHERE id = #{id}")
	public void deleteLinkById(@Param("id") Long id);

	@Select("SELECT * FROM link WHERE id = #{id}")
	public Link getLinkById(@Param("id") Long id);
}
