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
	@Autowired
	private CategoryService categoryService;
	@Override
	public void run(String... args) throws Exception {
		List<Category> primaryFrontCategories = categoryService.getPrimaryFrontCategories();
		Map<Category, List<Category>> categoryMap = new LinkedHashMap<>();
		for(Category c:primaryFrontCategories){
			List<Category> secondaryCategory = categoryService.getSecondaryCategoriesByPid(c.getId());
			categoryMap.put(c, secondaryCategory);
		}
	}

}
