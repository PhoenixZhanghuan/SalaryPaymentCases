package com.tp.attrclassifiction;

import com.tp.attribute.ChangeClassificationTransation;
import com.tp.classification.PaymentClassification;
import com.tp.classification.SalariedClassification;
import com.tp.schedule.MonthlySchedule;
import com.tp.top.PaymentSchedule;

public class ChangeSalariedTransaction extends ChangeClassificationTransation {
	private double salary;// Ð½×Ê
	public ChangeSalariedTransaction(int empid, double salary) {
		super(empid, new SalariedClassification(salary));
		this.salary = salary;
	}

	@Override
	public PaymentClassification getClassification() {
		return classification;
	}

	@Override
	public PaymentSchedule getSchedule() {
		return new MonthlySchedule();
	}
	
}
