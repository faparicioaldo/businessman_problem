package com.java.course;

import com.java.course.pipeline.Pipeline;
import com.java.course.pipeline.handler.LookForMaxSleepPeriodHandler;
import com.java.course.pipeline.handler.MeetsToObjectsHandler;
import com.java.course.pipeline.handler.SortMeetingsHandler;

public class SleepSolution {
	final String LF = "\n";

	public int solution(String schedule) {
		String meets[] = schedule.split(LF);

		return new Pipeline<>(
							new MeetsToObjectsHandler())
				.addHandler(new SortMeetingsHandler())
				.addHandler(new LookForMaxSleepPeriodHandler())
				.execute(meets);
	}
}