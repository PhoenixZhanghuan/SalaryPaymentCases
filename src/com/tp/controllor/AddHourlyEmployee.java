package com.tp.controllor;

import com.tp.classification.HourlyClassification;
import com.tp.classification.PaymentClassification;
import com.tp.obj.HoldMethod;
import com.tp.obj.TimeCard;
import com.tp.schedule.WeeklySchedule;
import com.tp.top.PaymentMethod;
import com.tp.top.PaymentSchedule;

public class AddHourlyEmployee extends AddEmployee{
	private double salary;
	private TimeCard timeCard;
	public AddHourlyEmployee(int empid, String itsAddress, String itsName,TimeCard timeCard) {
		super(empid, itsAddress, itsName);
		this.timeCard = timeCard;
	}

	@Override
	protected PaymentClassification getClassification() {
		return new HourlyClassification(timeCard);
	}

	@Override
	protected PaymentSchedule getSchedule() {
		return new WeeklySchedule();
	}

	@Override
	protected PaymentMethod getMethod() {
		// 默认使用支票支付
		return new HoldMethod();
	}
	
}
