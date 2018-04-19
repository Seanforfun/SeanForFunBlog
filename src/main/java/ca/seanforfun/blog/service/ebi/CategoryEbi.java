package ca.seanforfun.blog.service.ebi;

import java.util.List;

import ca.seanforfun.blog.model.entity.entity.Category;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 19, 2018 12:18:49 PM
 * @version 1.0
 */
public interface CategoryEbi {
	public List<Category> getPrimaryFrontCategories();
}
