package ca.seanforfun.blog.service.ebo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.seanforfun.blog.dao.LinkMapper;
import ca.seanforfun.blog.model.entity.entity.Link;
import ca.seanforfun.blog.service.ebi.LinkEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 21, 2018 9:25:11 PM
 * @version 1.0
 */
@Service
public class LinkService implements LinkEbi {
	@Autowired
	private LinkMapper linkMapper;
	
	@Override
	public List<Link> getAllFriendsLinks() {
		return linkMapper.getAllLinks();
	}
}