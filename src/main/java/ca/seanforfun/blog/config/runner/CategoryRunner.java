package ca.seanforfun.blog.config.runner;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ca.seanforfun.blog.model.entity.entity.Category;
import ca.seanforfun.blog.service.ebo.CategoryService;

@Component
@Order(value=1)
public class CategoryRunner implements CommandLineRunner {
	private static Map<Category, List<Category>> frontCategoryMap = null;
	
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
	}
	
	@Bean
	public Map<Category, List<Category>> categoryMap(){
		return frontCategoryMap;
	}
}
