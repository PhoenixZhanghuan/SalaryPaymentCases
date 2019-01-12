package com.tp.schedule;

import java.util.Calendar;
import com.tp.top.PaymentSchedule;

public class MonthlySchedule implements PaymentSchedule {
	public static String schedule = "month";

	public boolean isPayDate(Calendar itsDate) {//��ĩ���һ���Ǹ�н��	
		return isLastDayOfMonthly(itsDate);
	}

	private boolean isLastDayOfMonthly(Calendar c) {//�ж��Ƿ�����ĩ���һ��
		int mouth1 = c.get(Calendar.MONTH);
		c.add(Calendar.DAY_OF_MONTH,1);
		int mouth2 = c.get(Calendar.MONTH);
		return mouth1==mouth2;
	}
}
