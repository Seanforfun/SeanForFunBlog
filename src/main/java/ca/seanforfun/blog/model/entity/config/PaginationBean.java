package ca.seanforfun.blog.model.entity.config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 21, 2018 9:57:10 PM
 * @version 1.0
 */
@Component
@Scope("prototype")
public class PaginationBean {
	private Integer currentPageNum;
	private Integer numPerPage;
	private Integer totalPageNum;
	public Integer getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(Integer totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public Integer getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(Integer currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	public Integer getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(Integer numPerPage) {
		this.numPerPage = numPerPage;
	}
	public void calculationMaxPage(Integer articleTotalNum,
			Integer articlePerPage) {
		Integer totelPage = articleTotalNum/articlePerPage;
		totelPage = (articleTotalNum%articlePerPage == 0) ? totelPage:totelPage+1;
		this.setTotalPageNum(totelPage);
	}
}
