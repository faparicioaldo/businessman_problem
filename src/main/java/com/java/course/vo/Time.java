package com.java.course.vo;

public class Time {
	private int hour;
	private int minute;

	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public boolean occursBefore(Time time) {

		if (this.hour < time.hour)
			return true;

		if ((this.hour == time.hour) && (this.minute < time.minute))
			return true;
		return false;
	}

	public int getDifference(Time time) {
		int hoursDiff = this.hour - time.hour;
		return hoursDiff * 60 + this.minute - time.minute;
	}
}