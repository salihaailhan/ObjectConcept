package com.homework2;

import java.util.*;

public class DateAndTime {
    private Calendar cal;
	private int year;
    private int month;
    private int hour;
    private int minute;
    private int day;
    
	public DateAndTime() {
	    // Create a default calendar
	    this.cal = Calendar.getInstance();
	    this.year = cal.get(Calendar.YEAR);
	    this.month = cal.get(Calendar.MONTH) + 1;
	    this.hour = cal.get(Calendar.HOUR);
	    this.minute = cal.get(Calendar.MINUTE);
	    this.day = cal.get(Calendar.DATE);
	}
	
	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getDay() {
		return day;
	}
	
	@Override
	public String toString() {
		return "\ncal : " + this.cal + "\nyear : " + this.year +
				"\nmonth : " + this.month + "\nhour : " + this.hour +
				"\nminute : " + this.minute + "\nday : " + this.day;
	}
	
}
