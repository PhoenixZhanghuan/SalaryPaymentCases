package com.tp.schedule;

import java.util.Calendar;

import com.tp.top.PaymentSchedule;
 
public class BiweeklySchedule implements PaymentSchedule {
	public static String schedule = "biweekly";

	@Override
	public boolean isPayDate(Calendar date) {
		int i = date.get(Calendar.DAY_OF_WEEK);
		return i==5;
	}
}
