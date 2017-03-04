package ro.sci.classes;

import java.sql.Date;

public class AgeCalculator {

	private long days;

	public long daysBetweenDates(Date dateOne, Date dateTwo) {
		days = (dateOne.getTime() - dateTwo.getTime()) / (1000 * 60 * 60 * 24);
		// milliseconds in a day
		return Math.abs(days);
	}

}
