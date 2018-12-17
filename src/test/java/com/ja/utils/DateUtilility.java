package com.ja.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilility {

	public static String getCurrentDateFormatted() {

		/*
		 * SimpleDateFormat timeFormat = new SimpleDateFormat("mm/dd/yyyy");
		 * //SimpleDateFormat timeFormat = new SimpleDateFormat("MMMM dd, yyyy"
		 * ); timeFormat.setTimeZone(TimeZone.getTimeZone("EST"));
		 * 
		 * String time = timeFormat.format(new Date());
		 * System.out.println(time); return time;
		 */

		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		return dateFormat.format(date);

	}

}
