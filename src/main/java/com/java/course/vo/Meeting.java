package com.java.course.vo;

import com.java.course.helper.Constants;

public class Meeting {
	
	private String day;
	private Time start;
	private Time end;

	private String days[] = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };

	public Meeting(String day, MeetPeriod period) {
		this.day = day;
		this.start = period.getStartTime();
		this.end = period.getEndTime();
	}
	
	public Meeting(String day, Time start, Time end) {
		this.day = day;
		this.start = start;
		this.end = end;
	}

	public Time getEnd() {
		return end;
	}

	public Time getStart() {
		return start;
	}

	public int getDayNumber() {
		int i;

		for (i = 0; i < days.length; i++) {
			if (days[i].equals(day))
				break;
		}

		return i;
	}

	public boolean occursBefore(Meeting meeting) {

		if (this.getDayNumber() < meeting.getDayNumber())
			return true;

		if ((this.getDayNumber() == meeting.getDayNumber()) && (this.getStart().occursBefore(meeting.getStart())))
			return true;
		return false;
	}

	public int getSleepTime(Meeting previousMeeting) {
		Meeting currentMeeting = this;
		if (currentMeeting.getDayNumber() > previousMeeting.getDayNumber()) {
			int prevMeetTimeToSleep = Constants.LAST_DATE_TIME.getDifference(previousMeeting.getEnd());
			int wholeDaysToSleep = Constants.daysToMinutes(currentMeeting.getDayNumber() - previousMeeting.getDayNumber() - 1);
			int currDayTimeToSleep = currentMeeting.getStart().getDifference(Constants.FIRST_DATE_TIME);
			return prevMeetTimeToSleep + wholeDaysToSleep + currDayTimeToSleep;
		}

		return currentMeeting.getStart().getDifference(previousMeeting.getEnd());
	}

}