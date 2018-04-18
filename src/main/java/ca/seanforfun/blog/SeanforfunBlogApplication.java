package ca.seanforfun.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SeanForFunBlogApplication {
	public static void main(String[] args) {
		SpringApplication.run(SeanForFunBlogApplication.class, args);
	}
}
