package ca.seanforfun.blog.service.ebo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.seanforfun.blog.dao.MonthMapper;
import ca.seanforfun.blog.model.entity.entity.Month;
import ca.seanforfun.blog.service.ebi.MonthEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date May 5, 2018 4:02:11 PM
 * @version 1.0
 */
@Service
public class MonthService implements MonthEbi {
	@Autowired
	private MonthMapper monthMapper;
	
	@Override
	@Transactional
	public void createMonth() {
		monthMapper.addMonth(new Timestamp(System.currentTimeMillis()));
	}
	
	@Override
	public Long getCurrentMonth(){
		return monthMapper.getCurrentMonthId();
	}
	
	@Override
	public List<Month> getArchiveInfo(){
		return monthMapper.getArticleCountList();
	}
}
