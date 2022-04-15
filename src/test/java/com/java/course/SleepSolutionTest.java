package com.java.course;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SleepSolutionTest {

	private SleepSolution sleep = new SleepSolution();
	
	@Test
	public void SleepTimeMinutes6060test() {
		String schedule = 
		  		  "Sun 10:00-20:00\n"
				+ "Fri 05:00-10:00\n"
				+ "Fri 16:30-23:50";
		
		int maxPeriod = sleep.solution(schedule);
		int maxPeriodExpected = 6060;
		assertEquals(maxPeriodExpected, maxPeriod);
	}
	
	@Test
	public void SleepTimeMinutes505test() {

		SleepSolution sleep = new SleepSolution();

		String schedule = 
			  "Sun 10:00-20:00\n"
			+ "Fri 05:00-10:00\n"
			+ "Fri 16:30-23:50\n"
			+ "Sat 10:10-24:00\n"
			+ "Sun 01:00-04:00\n"
			+ "Sat 02:00-06:00\n"
			+ "Tue 03:30-18:15\n"
			+ "Tue 19:00-20:00\n"
			+ "Wed 04:25-15:14\n"
			+ "Wed 15:14-22:40\n"
			+ "Thu 00:00-23:59\n"
			+ "Mon 05:00-13:00\n"
			+ "Mon 15:00-21:00";
		
		int maxPeriod = sleep.solution(schedule);
		int maxPeriodExpected = 505;
		assertEquals(maxPeriodExpected, maxPeriod);
	}

}
