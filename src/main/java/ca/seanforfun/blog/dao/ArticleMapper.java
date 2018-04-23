package ca.seanforfun.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import ca.seanforfun.blog.model.entity.entity.Article;
import ca.seanforfun.blog.model.entity.entity.Badge;
import ca.seanforfun.blog.model.entity.entity.Image;
import ca.seanforfun.blog.model.entity.entity.User;

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
	@Select("SELECT id, title, abst, uid, lastmodifytime FROM article WHERE TYPE = #{type} ORDER BY lastmodifytime LIMIT #{current}, #{perpage}")
	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "title", column = "title"),
			@Result(property = "abst", column = "abst"),
			@Result(property = "author", column = "uid", javaType = User.class, one = @One(select = "ca.seanforfun.blog.dao.UserMapper.getUserById")),
			@Result(property = "lastModifyTime", column = "lastmodifytime"),
			@Result(property = "badges", column = "id", javaType = List.class, many = @Many(select = "ca.seanforfun.blog.dao.ArticleMapper.getBadgesByAritcleId")) })
	public List<Article> getArticlePaginationByType(
			@Param("current") Integer nextIndex,
			@Param("perpage") Integer articlePerPage,
			@Param("type") Integer type);

	@Select("SELECT id, NAME, color FROM badge b WHERE b.id IN(SELECT bid FROM article_badge WHERE aid = #{aid})")
	public List<Badge> getBadgesByAritcleId(@Param("aid") Integer aid);

	@Results(value = {
			@Result(property = "title", column = "title"),
			@Result(property = "hit", column = "hit"),
			@Result(property = "abst", column = "abst"),
			@Result(property = "content", column = "content"),
			@Result(property = "author", column = "uid", javaType = User.class, one = @One(select = "ca.seanforfun.blog.dao.UserMapper.getUserById")),
			@Result(property = "lastModifyTime", column = "lastmodifytime"),
			@Result(property = "badges", column = "id", javaType = List.class, many = @Many(select = "ca.seanforfun.blog.dao.ArticleMapper.getBadgesByAritcleId")) })
	@Select("SELECT id, title, hit, lastmodifytime, uid, abst, content FROM article WHERE id=#{id};")
	public Article getArticleById(Long id);

	@Cacheable("articleNumByCategory")
	@Select("select count(id) from article where cid = #{category}")
	public Integer getArticalCountByCategoryId(Integer category);

	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "title", column = "title"),
			@Result(property = "hit", column = "hit"),
			@Result(property = "abst", column = "abst"),
			@Result(property = "content", column = "content"),
			@Result(property = "author", column = "uid", javaType = User.class, one = @One(select = "ca.seanforfun.blog.dao.UserMapper.getUserById")),
			@Result(property = "lastModifyTime", column = "lastmodifytime"),
			@Result(property = "badges", column = "id", javaType = List.class, many = @Many(select = "ca.seanforfun.blog.dao.ArticleMapper.getBadgesByAritcleId")) })
	@Select("SELECT id, title, abst, uid, lastmodifytime FROM article WHERE TYPE = #{type} ORDER BY lastmodifytime LIMIT #{current}, #{perpage}")
	public List<Article> getArticalByCategoryId(Integer categoryId,
			@Param("current") Integer currentIndex,
			@Param("perpage") Integer numPerPage, @Param("type") Integer type);

	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "title", column = "title"),
			@Result(property = "abst", column = "abst"),
			@Result(property = "images", column = "id", javaType = List.class, many = @Many(select = "ca.seanforfun.blog.dao.ArticleMapper.getImagesByArticleId")) })
	@Select("SELECT id, title,abst FROM article WHERE id IN (SELECT DISTINCT aid FROM image WHERE aid IS NOT NULL) LIMIT 0, 3")
	public List<Article> getArticalsWithImage();
	
	@Select("SELECT id,path FROM image WHERE aid = #{aid}")
	public List<Image> getImagesByArticleId(@Param("aid") Long aid);
}
