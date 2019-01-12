package com.tp.attrclassifiction;

import com.tp.attribute.ChangeClassificationTransation;
import com.tp.classification.HourlyClassification;
import com.tp.classification.PaymentClassification;
import com.tp.obj.TimeCard;
import com.tp.schedule.WeeklySchedule;
import com.tp.top.PaymentSchedule;

public class ChangeHourlyTransaction extends ChangeClassificationTransation {

	public ChangeHourlyTransaction(int empid, TimeCard timeCard) {
		super(empid, new HourlyClassification(timeCard));
		
	}

	//classification
	@Override
	public PaymentClassification getClassification() {
		return classification;
	}
	
	//»ñµÃschedule
	@Override
	public PaymentSchedule getSchedule() {
		return new WeeklySchedule();
	}
}
