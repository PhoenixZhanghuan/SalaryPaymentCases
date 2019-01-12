package com.tp.attrclassifiction;

import java.util.Date;

import com.tp.attribute.ChangeClassificationTransation;
import com.tp.classification.CommissionedClassification;
import com.tp.classification.PaymentClassification;
import com.tp.obj.SalesReceipt;
import com.tp.schedule.BiweeklySchedule;
import com.tp.top.PaymentSchedule;

public class ChangeCommissionedTransation extends ChangeClassificationTransation {
	private double salary;//��������
	private double commissionRate;//����
	public ChangeCommissionedTransation(int empid, double salary, double commissionRate) {
		super(empid, new CommissionedClassification(salary, commissionRate, new SalesReceipt(new Date(), 0)));
		// TODO Auto-generated constructor stub
	}

	//����֧������
	@Override
	public PaymentClassification getClassification() {
		return classification;
	}

	//����֧��ʱ��
	@Override
	public PaymentSchedule getSchedule() {
		return new BiweeklySchedule();
	}

}
