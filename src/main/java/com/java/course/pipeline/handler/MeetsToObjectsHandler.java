package com.java.course.pipeline.handler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.java.course.pipeline.Handler;
import com.java.course.vo.MeetPeriod;
import com.java.course.vo.Meeting;
import com.java.course.vo.Time;

public class MeetsToObjectsHandler implements Handler<String[], Meeting[]>{

	@Override
	public Meeting[] process(String[] meets) {
		int numMeets = meets.length;

		Meeting meetings[] = new Meeting[numMeets];

		for (int i = 0; i < numMeets; i++) {
			String currentMeet = meets[i];

			String dayTime[] = currentMeet.split(" ");
			String day = dayTime[0];
			String time = dayTime[1];

			MeetPeriod meetPeriod = getTimePeriodParts(time);

			Meeting newMeeting = new Meeting(day, meetPeriod);
			meetings[i] = newMeeting;
		}
		return meetings;
	}
	
	public MeetPeriod getTimePeriodParts(String timePeriod) {

		Matcher matcher = Pattern.compile("\\d\\d").matcher(timePeriod);

		int[] extractedHourMinute = new int[4];
		for (int i = 0; i < 4; i++) {
			matcher.find();
			extractedHourMinute[i] = Integer.parseInt(matcher.group(0));
		}
		int startHourInt = extractedHourMinute[0];
		int startMinuteInt = extractedHourMinute[1];
		int endHourInt = extractedHourMinute[2];
		int endMinuteInt = extractedHourMinute[3];

		Time startTime = new Time(startHourInt, startMinuteInt);
		Time endTime = new Time(endHourInt, endMinuteInt);

		MeetPeriod period = new MeetPeriod(startTime, endTime);
		
		return period;
	}
}
