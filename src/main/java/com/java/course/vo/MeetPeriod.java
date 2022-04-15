package com.java.course.vo;

public class MeetPeriod {
	private Time startTime;
	private Time endTime;
	
	public MeetPeriod(Time startTime, Time endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
}