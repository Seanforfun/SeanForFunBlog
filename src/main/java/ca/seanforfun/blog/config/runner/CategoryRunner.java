package ca.seanforfun.blog.config.runner;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ca.seanforfun.blog.model.entity.entity.Category;
import ca.seanforfun.blog.service.ebo.CategoryService;

@Component
@Order(value=1)
public class CategoryRunner implements CommandLineRunner {
	private static Map<Category, List<Category>> frontCategoryMap;
	private static Map<Category, List<Category>> adminCategoryMap;
	
	public static Map<Category, List<Category>> getFrontCategoryMap() {
		return frontCategoryMap;
	}
	
	public static Map<Category, List<Category>> getAdminCategoryMap() {
		return adminCategoryMap;
	}

	@Autowired
	private CategoryService categoryService;
	
	@Override
	public void run(String... args) throws Exception {
		List<Category> primaryFrontCategories = categoryService.getPrimaryFrontCategories();
		frontCategoryMap = new LinkedHashMap<>();
		for(Category c:primaryFrontCategories){
			List<Category> secondaryCategory = categoryService.getSecondaryCategoriesByPid(c.getId());
			frontCategoryMap.put(c, secondaryCategory);
		}
		
		List<Category> primaryAdminCategories = categoryService.getPrimaryAdminCategories();
		adminCategoryMap = new LinkedHashMap<>();
		for(Category c:primaryAdminCategories){
			List<Category> secondaryCategory = categoryService.getSecondaryCategoriesByPid(c.getId());
			adminCategoryMap.put(c, secondaryCategory);
		}
	}
}
