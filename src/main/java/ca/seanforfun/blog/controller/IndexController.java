package ca.seanforfun.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 13, 2018 5:20:44 PM
 * @version 1.0
 */
@RestController
public class IndexController {
	@RequestMapping("/")
	public void test(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.sendRedirect("/index.html");
	}
}
