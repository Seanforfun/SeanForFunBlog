package ca.seanforfun.blog.service.ebi;

import java.util.List;

import ca.seanforfun.blog.model.entity.entity.Link;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 21, 2018 9:23:50 PM
 * @version 1.0
 */
public interface LinkEbi {
	/**
	 * @Description: 
	 * @Return: List<Link> Get all friends links from database.
	 */
	public List<Link> getAllFriendsLinks();
	
	/**
	 * @Description: Get total friend link number.
	 * @Return: Integer
	 */
	public Integer getLinkCount();

	/**
	 * @Description:Get LinkList from database.
	 * @Return: List<Link>
	 */
	List<Link> getPaginationLinks(Integer pageNum, Integer numPerPage);

	/**
	 * @Description:Delete link by id.
	 * @Return: void
	 */
	void deleteLinkById(Long id);

	/**
	 * @Description:Get link information of the link.
	 * @Return: Link
	 */
	Link getLinkById(Long id);
}
