package ca.seanforfun.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 13, 2018 5:20:44 PM
 * @version 1.0
 */
@Controller
public class IndexController {
	@RequestMapping("/")
	public String test(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return "front/index.html";
	}
}
