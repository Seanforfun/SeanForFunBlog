package ca.seanforfun.blog.utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 18, 2018 1:47:43 PM
 * @version 1.0
 */
public class FormatUtils {
	public static final String formatDate(Long time) {
		if (null == time)
			return "";
		DateFormat df = new SimpleDateFormat("MMM d, yyyy", Locale.CANADA);
		return df.format(new Date(time));
	}

	public static final String formatTime(Long time) {
		if (null == time)
			return "";
		DateFormat df = new SimpleDateFormat("HH-mm-ss");
		return df.format(new Date(time));
	}

	public static final String formatDateTime(Long time) {
		if (null == time)
			return "";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date(time));
	}

	public static final String formatMoney(Double money) {
		if (null == money)
			return "";
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(money);
	}
}
