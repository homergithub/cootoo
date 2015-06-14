package com.cootoo.common.util;

import java.util.Date;

import org.joda.time.DateTime;

public class DateUtil {

	private DateUtil() {
		super();
	}

	public static String dateFormat(Date date,String format){
		DateTime dTime = new DateTime(date);
		return dTime.toString(format);
	}
}
