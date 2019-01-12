package com.tp.classification;

import com.tp.obj.Paycheck;
import com.tp.obj.SalesReceipt;
import com.tp.obj.TimeCard;

public class SalariedClassification extends PaymentClassification {
	private double salary;//ÔÂÐ½
	public SalariedClassification(double salary){
		this.salary = salary;
	}

	@Override
	public double CalculatePay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double CalculatePay(TimeCard timeCard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double CalculatePay(SalesReceipt salesReceipt) {
		// TODO Auto-generated method stub
		return 0;
	}
}
