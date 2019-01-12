package com.tp.attrclassifiction;

import java.util.Date;

import com.tp.attribute.ChangeClassificationTransation;
import com.tp.classification.CommissionedClassification;
import com.tp.classification.PaymentClassification;
import com.tp.obj.SalesReceipt;
import com.tp.schedule.BiweeklySchedule;
import com.tp.top.PaymentSchedule;

public class ChangeCommissionedTransation extends ChangeClassificationTransation {
	private double salary;//基本工资
	private double commissionRate;//单价
	public ChangeCommissionedTransation(int empid, double salary, double commissionRate) {
		super(empid, new CommissionedClassification(salary, commissionRate, new SalesReceipt(new Date(), 0)));
		// TODO Auto-generated constructor stub
	}

	//更改支付类型
	@Override
	public PaymentClassification getClassification() {
		return classification;
	}

	//更改支付时间
	@Override
	public PaymentSchedule getSchedule() {
		return new BiweeklySchedule();
	}

}
