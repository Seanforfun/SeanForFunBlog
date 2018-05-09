package ca.seanforfun.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ca.seanforfun.blog.exception.SeanForFunException;
import ca.seanforfun.blog.model.entity.entity.Link;
import ca.seanforfun.blog.model.entity.vo.PaginationVo;
import ca.seanforfun.blog.service.ebo.LinkService;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date May 9, 2018 1:59:39 PM
 * @version 1.0
 */
@Controller
@RequestMapping("/link")
public class LinkController {
	@Autowired
	private LinkService linkService;
	@Autowired
	private PaginationVo paginationVo;
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteLink(ModelAndView mv, @PathVariable("id") Long id){
		if(null == id){
			throw new SeanForFunException("Error happens when deleting link...");
		}
		linkService.deleteLinkById(id);
		mv.setViewName("redirect:/admin/toLinkManage/1");
		return mv;
	}
	
	//----------------------------------------------ajax------------------------------------------------------
	@RequestMapping("/modify/{id}")
	public @ResponseBody Link ajaxGetLinkById(@PathVariable("id") Long id){
		Link linkInfo = linkService.getLinkById(id);
		return linkInfo;
	}
}
