package com.tp.controllor;

import com.tp.classification.CommissionedClassification;
import com.tp.classification.PaymentClassification;
import com.tp.obj.HoldMethod;
import com.tp.obj.SalesReceipt;
import com.tp.schedule.BiweeklySchedule;
import com.tp.top.PaymentMethod;
import com.tp.top.PaymentSchedule;

public class AddCommissionedEmployee extends AddEmployee {
	private double salary;
	private double commissionRate;
	private SalesReceipt saleReceipt;
	
	public AddCommissionedEmployee(int empid, String itsAddress, String itsName, double salary, double commissionRate,
			SalesReceipt saleReceipt) {
		super(empid, itsAddress, itsName);
		this.salary = salary;
		this.commissionRate = commissionRate;
		this.saleReceipt = saleReceipt;
	}

	@Override
	protected PaymentClassification getClassification() {
		return new CommissionedClassification(empid,commissionRate,saleReceipt);
	}

	@Override
	protected PaymentSchedule getSchedule() {
		// TODO Auto-generated method stub
		return new BiweeklySchedule();
	}

	@Override
	protected PaymentMethod getMethod() {
		// 默认使用支票支付
		return new HoldMethod();
	}

}
