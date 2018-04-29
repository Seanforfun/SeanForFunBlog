package ca.seanforfun.blog.controller;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ca.seanforfun.blog.config.runner.CategoryRunner;
import ca.seanforfun.blog.exception.SeanForFunException;
import ca.seanforfun.blog.model.entity.config.BlogInfo;
import ca.seanforfun.blog.model.entity.config.ConfigBean;
import ca.seanforfun.blog.model.entity.config.SqlInfo;
import ca.seanforfun.blog.model.entity.config.SysInfo;
import ca.seanforfun.blog.model.entity.entity.Category;
import ca.seanforfun.blog.model.entity.entity.User;
import ca.seanforfun.blog.service.ebo.AccessService;
import ca.seanforfun.blog.service.ebo.ArticleService;
import ca.seanforfun.blog.service.ebo.LinkService;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 24, 2018 5:28:20 PM
 * @version 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private ConfigBean configBean;
	@Autowired
	private AccessService accessService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private LinkService linkService;
	@Autowired
	private SysInfo sysInfo;
	@Autowired
	private SqlInfo sqlInfo;
	
	@RequestMapping("/toAdmin")
	public ModelAndView toAdminPage(ModelAndView mv, HttpSession session,
			HttpServletRequest request) throws SQLException {
		// Use Interceptor to replace the login check.
		User loginUser = (User) session.getAttribute("loginUser");
		if (null == loginUser){
			mv.setViewName("redirect:/tologin");
			return mv;
		}
		if (null == loginUser.getId()) {
			throw new SeanForFunException("Login information error...");
		}
		// Get yesterday's blog access data.
		//	 Access access = accessService.getYesterdayAccessInfo();
		//Get view time today.
		Long access = BlogInfo.oneDayAccessTime.get();
		mv.addObject("access", access);

		// Get blog articles infromation.
		Integer articleNum = articleService.getCountByUid(loginUser.getId());
		mv.addObject("articleNum", articleNum);

		// Get comments information.

		// Get Friend's link information.
		Integer linkCount = linkService.getLinkCount();
		mv.addObject("linkCount", linkCount);
		
		// Get Blog & Server information.
		Properties props = System.getProperties();
		sysInfo.setCountry(request.getLocale().getDisplayCountry());
		sysInfo.setAccountName(props.getProperty("user.name"));
		sysInfo.setJavaVersion(props.getProperty("java.version"));
		sysInfo.setOs(props.getProperty("os.name"));
		sysInfo.setOsVersion(props.getProperty("os.version"));
		sysInfo.setServerName(request.getServerName());
		Connection connection = DriverManager.getConnection(sqlInfo.getUrl(),sqlInfo.getUsername(),sqlInfo.getPassword());
		DatabaseMetaData metaData = connection.getMetaData();
		sysInfo.setDatabaseName(metaData.getDatabaseProductName());
		sysInfo.setDatabaseVersion(metaData.getDatabaseProductVersion());
		sysInfo.setDatabaseDriverName(metaData.getDriverName());
		sysInfo.setProjectName(configBean.getName());
		sysInfo.setProjectVersion(configBean.getVersion());
		mv.addObject("sysInfo", sysInfo);
		
		//Add category inforamtion
		Map<Category, List<Category>> adminCategoryMap = CategoryRunner.getAdminCategoryMap();
		if(null == adminCategoryMap || adminCategoryMap.size() <= 0){
			throw new SeanForFunException("Blog Category setting error....");
		}else {
			mv.addObject("pacategory", adminCategoryMap);
		}
		
		mv.setViewName("admin/admin.html");
		return mv;
	}
	
	@RequestMapping("/toWrite")
	public ModelAndView toWriteBlog(ModelAndView mv){
		//Add admin category information.
		Map<Category, List<Category>> adminCategoryMap = CategoryRunner.getAdminCategoryMap();
		if(null == adminCategoryMap || adminCategoryMap.size() <= 0){
			throw new SeanForFunException("Blog Category setting error....");
		}else {
			mv.addObject("pacategory", adminCategoryMap);
		}
		
		//Add front catefory information for setting article belonging.
		Map<Category, List<Category>> frontCategoryMap = CategoryRunner.getFrontCategoryMap();
		if(null == frontCategoryMap || frontCategoryMap.size() <= 0){
			throw new SeanForFunException("Blog Category setting error....");
		}else {
			mv.addObject("pfacategory", frontCategoryMap);
		}
		mv.setViewName("admin/write.html");
		return mv;
	}

	@RequestMapping("/adminSignout")
	public ModelAndView signOut(ModelAndView mv, HttpSession session) {
		session.removeAttribute("remember");
		mv.setViewName("redirect:/");
		return mv;
	}
}
