package com.java.course.helper;

import com.java.course.vo.Time;

public class Constants {

	public static final int LAST_DAY_WEEK_INDEX = 6;

	public static final int DAY_HOURS = 24;
	public static final int FIRST_DAY_HOUR = 0;
	public static final int LAST_DAY_HOUR = 24;
	
	public static final int HOUR_MINUTES = 60;
	public static final int FIRST_HOUR_MINUTE = 0;
	
	public static final Time FIRST_DATE_TIME = new Time(FIRST_DAY_HOUR, FIRST_HOUR_MINUTE);
	public static final Time LAST_DATE_TIME = new Time(LAST_DAY_HOUR, FIRST_HOUR_MINUTE);
	
	public static int daysToMinutes(int days) {
		return days * DAY_HOURS * HOUR_MINUTES;
	}
}
