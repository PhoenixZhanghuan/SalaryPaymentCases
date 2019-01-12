package com.tp.attribute;

import com.tp.classification.PaymentClassification;
import com.tp.obj.Employee;
import com.tp.top.ChangeEmployeeTransation;
import com.tp.top.PaymentSchedule;

public abstract class ChangeClassificationTransation extends ChangeEmployeeTransation {
	protected PaymentClassification classification;
	public ChangeClassificationTransation(int empid, PaymentClassification classification) {
		super(empid);
		this.classification = classification;
	}
	
	@Override
	public void change(Employee emp){
		emp.setPaymentClassification(getClassification());
		emp.setSchedule(getSchedule());
	}
	
	//������󷽷���ȡclassisfication
	public abstract PaymentClassification getClassification();
	//������󷽷���ȡschedule
	public abstract PaymentSchedule getSchedule();
}
