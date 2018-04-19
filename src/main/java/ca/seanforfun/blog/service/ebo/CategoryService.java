package ca.seanforfun.blog.service.ebo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.seanforfun.blog.dao.CategoryMapper;
import ca.seanforfun.blog.model.entity.entity.Category;
import ca.seanforfun.blog.service.ebi.CategoryEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 19, 2018 12:20:18 PM
 * @version 1.0
 */
@Service
public class CategoryService implements CategoryEbi {
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> getPrimaryFrontCategories() {
		return categoryMapper.getCategoriesByCategoryTypeAndRole(
				Category.PRIMARY_CATEGORY, Category.FRONT_PAGE);
	}

}
