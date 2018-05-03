package ca.seanforfun.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import ca.seanforfun.blog.model.entity.entity.Article;
import ca.seanforfun.blog.model.entity.entity.Badge;
import ca.seanforfun.blog.model.entity.entity.Category;
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
	@Select("select count(id) from article where publish = 1")
	public Integer getArticalCount();

	@Select("select count(id) from article where uid = #{uid}")
	public Long getArticleCountByUid(@Param("uid") Long uid);

	@Cacheable("articlePagination")
	@Select("SELECT id, title, abst, uid, lastmodifytime FROM article WHERE TYPE = #{type} and publish = 1 ORDER BY lastmodifytime desc LIMIT #{current}, #{perpage}")
	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "title", column = "title"),
			@Result(property = "abst", column = "abst"),
			@Result(property = "author", column = "uid", javaType = User.class, one = @One(select = "ca.seanforfun.blog.dao.UserMapper.getUserById")),
			@Result(property = "lastModifyTime", column = "lastmodifytime"),
			@Result(property = "images", column = "id", javaType = List.class, many = @Many(select = "ca.seanforfun.blog.dao.ArticleMapper.getImagesByArticleId")),
			@Result(property = "badges", column = "id", javaType = List.class, many = @Many(select = "ca.seanforfun.blog.dao.ArticleMapper.getBadgesByAritcleId")) })
	public List<Article> getArticlePaginationByType(
			@Param("current") Integer nextIndex,
			@Param("perpage") Integer articlePerPage,
			@Param("type") Integer type);

	@Select("SELECT id, NAME, color FROM badge b WHERE b.id IN(SELECT bid FROM article_badge WHERE aid = #{aid})")
	public List<Badge> getBadgesByAritcleId(@Param("aid") Integer aid);

	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "title", column = "title"),
			@Result(property = "hit", column = "hit"),
			@Result(property = "abst", column = "abst"),
			@Result(property = "cid", column = "cid"),
			@Result(property = "content", column = "content"),
			@Result(property = "type", column = "type"),
			@Result(property = "allowComments", column = "allowComments"),
			@Result(property = "author", column = "uid", javaType = User.class, one = @One(select = "ca.seanforfun.blog.dao.UserMapper.getUserById")),
			@Result(property = "lastModifyTime", column = "lastmodifytime"),
			@Result(property = "accessTime", column = "accessTime"),
			@Result(property = "badges", column = "id", javaType = List.class, many = @Many(select = "ca.seanforfun.blog.dao.ArticleMapper.getBadgesByAritcleId")),
			@Result(property = "images", column = "id", javaType = List.class, many = @Many(select = "ca.seanforfun.blog.dao.ArticleMapper.getImageByAid")) })
	@Select("SELECT id, title, hit, lastmodifytime, uid, abst, content, cid, type, allowComments, accessTime FROM article WHERE id=#{id}")
	public Article getArticleById(Long id);

	@Select("SELECT path FROM image WHERE aid = #{id}")
	public List<Image> getImageByAid(Long aid);

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
			@Result(property = "images", column = "id", javaType = List.class, many = @Many(select = "ca.seanforfun.blog.dao.ArticleMapper.getImagesByArticleId")),
			@Result(property = "badges", column = "id", javaType = List.class, many = @Many(select = "ca.seanforfun.blog.dao.ArticleMapper.getBadgesByAritcleId")) })
	@Select("SELECT id, title, abst, uid, lastmodifytime FROM article WHERE TYPE = #{type} and publish = 1 ORDER BY lastmodifytime desc LIMIT #{current}, #{perpage}")
	public List<Article> getArticalByCategoryId(Integer categoryId,
			@Param("current") Integer currentIndex,
			@Param("perpage") Integer numPerPage, @Param("type") Integer type);

	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "title", column = "title"),
			@Result(property = "abst", column = "abst"),
			@Result(property = "images", column = "id", javaType = List.class, many = @Many(select = "ca.seanforfun.blog.dao.ArticleMapper.getImagesByArticleId")) })
	@Select("SELECT id, title,abst FROM article WHERE id IN (SELECT DISTINCT aid FROM image WHERE aid IS NOT NULL) and publish = 1 LIMIT 0, 3")
	public List<Article> getArticalsWithImage();

	@Select("SELECT id,path,name FROM image WHERE aid = #{aid}")
	public List<Image> getImagesByArticleId(@Param("aid") Long aid);

	@Update("UPDATE article SET accessTime = accessTime + 1 WHERE id = #{id}")
	public void updateAccesstimeById(@Param("id") Long articleId);

	@Select("SELECT COUNT(id) FROM article WHERE uid = #{id}")
	public Long getArticleByUid(@Param("id") Long id);

	@Insert("INSERT INTO article (title, cid, TYPE, hit, lastmodifytime, uid, abst, content, accessTime, publish, allowComments) VALUES (#{title}, #{cid}, #{type}, #{hit}, #{lastmodifytime}, #{uid}, #{abst}, #{content}, #{accessTime}, #{publish}, #{allowComments});")
	public void createArticle(@Param("title") String title,
			@Param("cid") Long cid, @Param("type") Integer type,
			@Param("hit") Long hit,
			@Param("lastmodifytime") Long lastmodifytime,
			@Param("uid") Long uid, @Param("abst") String abst,
			@Param("content") String content,
			@Param("accessTime") Long accessTime,
			@Param("publish") Integer publish,
			@Param("allowComments") Integer allowComments);

	@Insert("INSERT INTO article_badge (aid, bid) VALUES(#{articleId}, #{badgeId})")
	public void saveBagesInfo(@Param("articleId") Long articleId,
			@Param("badgeId") Long badgeId);

	@Select("select LAST_INSERT_ID()")
	public Long findLastInsertId();

	@Update("UPDATE article SET title = #{title}, cid = #{cid}, TYPE = #{TYPE}, lastmodifytime = #{lastmodifytime}, abst = #{abst}, content = #{content}, allowComments = #{allowComments} WHERE id = #{id}")
	public void updateArticle(@Param("title") String title,
			@Param("cid") Long cid, @Param("TYPE") Integer type,
			@Param("lastmodifytime") Long lastmodifytime,
			@Param("abst") String abst, @Param("content") String content,
			@Param("allowComments") Integer allowComments, @Param("id") Long id);

	@Update("UPDATE article SET publish = #{publish}, publishTime = #{publishTime} where id = #{id}")
	public void updateArticlePublishById(@Param("id") Long id,
			@Param("publishTime") long currentTimeMillis,
			@Param("publish") Integer articlePublish);

	@Results(value = {
			@Result(property = "id", column = "id"),
			@Result(property = "title", column = "title"),
			@Result(property = "cid", column = "cid"),
			@Result(property = "type", column = "type"),
			@Result(property = "accessTime", column = "accessTime"),
			@Result(property = "lastModifyTime", column = "lastmodifytime"),
			@Result(property = "publish", column = "publish"),
			@Result(property = "category", column = "cid", javaType = Category.class, one = @One(select = "ca.seanforfun.blog.dao.CategoryMapper.getCategoryById")) })
	@Select("SELECT id, title, cid, accessTime, TYPE, lastmodifytime, publish FROM article WHERE uid = #{uid} ORDER BY id DESC LIMIT #{index} ,#{numPerPage}")
	public List<Article> getArticlePaginationByUid(@Param("uid") Long uid,
			@Param("index") int index, @Param("numPerPage") Integer numPerPage);
}
