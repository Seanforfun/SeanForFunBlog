package ca.seanforfun.blog.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 30, 2018 7:11:22 PM
 * @version 1.0
 */
@Repository
@Mapper
public interface ImageMapper {

	//TODO Finish this part tomorrow!
	@Insert("")
	void createImageByAid(String path, String removeHash, Long articleId);
	
}
