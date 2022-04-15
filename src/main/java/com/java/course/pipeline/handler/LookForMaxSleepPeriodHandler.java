package com.java.course.pipeline.handler;

import com.java.course.helper.Constants;
import com.java.course.pipeline.Handler;
import com.java.course.vo.Meeting;

public class LookForMaxSleepPeriodHandler implements Handler<Meeting[], Integer>{

	@Override
	public Integer process(Meeting[] meetings) {
		int numMeets = meetings.length;
		Meeting firstMeet = meetings[0];
		int initialSleep = Constants.daysToMinutes(firstMeet.getDayNumber()) 
				+ firstMeet.getStart().getDifference(Constants.FIRST_DATE_TIME);

		
		Meeting lastMeet = meetings[numMeets - 1];
		int endSleep = Constants.daysToMinutes(Constants.LAST_DAY_WEEK_INDEX - lastMeet.getDayNumber()) 
				+ Constants.LAST_DATE_TIME.getDifference(lastMeet.getEnd());

		int maxSleep = Math.max(initialSleep, endSleep);

		for (int i = 1; i < numMeets; i++) {
			int currSleep = meetings[i].getSleepTime(meetings[i - 1]);

			maxSleep = Math.max(maxSleep, currSleep);
		}
		return maxSleep;
	}

}
