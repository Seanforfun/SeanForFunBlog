package ca.seanforfun.blog.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 30, 2018 7:11:22 PM
 * @version 1.0
 */
@Repository
@Mapper
public interface ImageMapper {
	@Insert("INSERT INTO image (name, path, aid, removehash) VALUES (#{name}, #{path}, #{articleId}, #{removeHash})")
	void createImageByAid(@Param("path") String path, @Param("removeHash") String removeHash, @Param("articleId") Long articleId, @Param("name") String name);
}
