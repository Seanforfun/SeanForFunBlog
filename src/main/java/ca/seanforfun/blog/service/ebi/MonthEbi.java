package ca.seanforfun.blog.service.ebi;
/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date May 5, 2018 4:01:47 PM
 * @version 1.0
 */
public interface MonthEbi {
	/**
	 * @Description: Automatic create month data in database every month.
	 * @Return: void
	 */
	public void createMonth();

	/**
	 * @Description: Get id of current month.
	 * @Return: Long
	 */
	public Long getCurrentMonth();
}
