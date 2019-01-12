package com.tp.controllor;

import com.tp.classification.PaymentClassification;
import com.tp.classification.SalariedClassification;
import com.tp.obj.HoldMethod;
import com.tp.schedule.MonthlySchedule;
import com.tp.top.PaymentMethod;
import com.tp.top.PaymentSchedule;

public class AddSalariedEmployee extends AddEmployee {
	
	private double isSalary;
	
	public AddSalariedEmployee(int empid, String itsAddress, String itsName, double isSalary) {
		super(empid, itsAddress, itsName);
		this.isSalary = isSalary;
	}

	
	@Override
	protected PaymentClassification getClassification() {
		 return new SalariedClassification(isSalary);
		
	}

	@Override
	protected PaymentSchedule getSchedule() {
		return new MonthlySchedule();  	
	}

	@Override
	protected PaymentMethod getMethod() {
		return new HoldMethod();
		//默认使用支票支付
		
	}

}
