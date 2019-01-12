package com.tp.classification;

import com.tp.dao.PayrollDatabase;
import com.tp.obj.Employee;
import com.tp.obj.Paycheck;
import com.tp.obj.SalesReceipt;
import com.tp.obj.TimeCard;

public class CommissionedClassification extends PaymentClassification {
	private double salary;//��������
	private double commissionRate;//���۵���
	private SalesReceipt saleReceipt; //������

	public CommissionedClassification(double salary, double commissionRate, SalesReceipt saleReceipt) {
		super();
		this.salary = salary;
		this.commissionRate = commissionRate;
		this.saleReceipt = saleReceipt;
	}

	//��𷢷ż���
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
		double amount = salesReceipt.getAmount();
		return amount;
	}
	
	//���ӳ��
	public void addSaleReceipt(SalesReceipt salesReceipt, int empid) {
		double amount = salesReceipt.getAmount()+this.saleReceipt.getAmount();//�ۼ���������
		this.saleReceipt.setAmount(amount);
		this.saleReceipt.setDate(salesReceipt.getDate());//�ۼƺ����ڸ���
		Employee emp = PayrollDatabase.getEmployee(empid);//������������ӵ�Ա������
		emp.setPaymentClassification(this);
	}
}
