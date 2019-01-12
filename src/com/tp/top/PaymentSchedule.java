package com.tp.top;

import java.util.Calendar;
import java.util.Date;

public interface PaymentSchedule {
	boolean isPayDate(Calendar date);//判断是否到时间发放工资
	
}
