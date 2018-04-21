package ca.seanforfun.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import ca.seanforfun.blog.model.entity.entity.Article;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 20, 2018 9:44:26 PM
 * @version 1.0
 */
@Mapper
@Repository
public interface ArticleMapper {
	@Cacheable("articleNum")
	@Select("select count(id) from article")
	public Integer getArticalCount();

	@Cacheable("articlePagination")
	@Select("SELECT a.id, title, abst, uid, u.nickname, lastmodifytime FROM article a LEFT OUTER JOIN USER u ON a.uid = u.id WHERE TYPE = #{type} ORDER BY lastmodifytime LIMIT #{current}, #{perpage}")
	public List<Article> getArticlePaginationByType(
			@Param("current") Integer nextIndex,
			@Param("perpage") Integer articlePerPage,
			@Param("type") Integer type);
}
