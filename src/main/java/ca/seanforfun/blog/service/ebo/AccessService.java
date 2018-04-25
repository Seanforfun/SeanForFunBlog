package ca.seanforfun.blog.service.ebo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.seanforfun.blog.dao.AccessMapper;
import ca.seanforfun.blog.model.entity.entity.Access;
import ca.seanforfun.blog.service.ebi.AccessEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 25, 2018 1:47:09 PM
 * @version 1.0
 */
@Service
public class AccessService implements AccessEbi {
	private static final Long HOUR = new Long(60 * 60 * 1000);
	@Autowired
	private AccessMapper accessMapper;
	
	@Override
	@Transactional
	public void createDailyAccess(Long accessNum) {
		Long count = accessMapper.getTotelCount();
		if(count > Access.MAX_SAVE_ITEMS){
			Long id = accessMapper.getOldestId();
			accessMapper.deleteOldAccessinfo(id);
		}
		accessMapper.createDailyAccessInfo(accessNum, System.currentTimeMillis() - HOUR);
	}
}
