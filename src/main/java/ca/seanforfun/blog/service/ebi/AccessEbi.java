package ca.seanforfun.blog.service.ebi;

import ca.seanforfun.blog.model.entity.entity.Access;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 25, 2018 1:43:12 PM
 * @version 1.0
 */
public interface AccessEbi {
	public void createDailyAccess(Long accessNum);

	Access getYesterdayAccessInfo();
}
