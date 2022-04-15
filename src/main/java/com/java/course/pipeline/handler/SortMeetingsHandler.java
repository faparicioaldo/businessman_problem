package com.java.course.pipeline.handler;

import com.java.course.pipeline.Handler;
import com.java.course.vo.Meeting;

public class SortMeetingsHandler implements Handler<Meeting[], Meeting[]>{

	@Override
	public Meeting[] process(Meeting[] meetings) {
		int numMeets = meetings.length;
		for (int i = 0; i < numMeets - 1; i++) {
			for (int j = 0; j < numMeets - i - 1; j++) {
				if (meetings[j].occursBefore(meetings[j + 1]) == false) {
					Meeting temp = meetings[j];
					meetings[j] = meetings[j + 1];
					meetings[j + 1] = temp;
				}
			}
		}
		return meetings;
	}
}
