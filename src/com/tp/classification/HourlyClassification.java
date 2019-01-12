package com.tp.classification;

import com.tp.dao.PayrollDatabase;
import com.tp.obj.Employee;
import com.tp.obj.Paycheck;
import com.tp.obj.SalesReceipt;
import com.tp.obj.TimeCard;

public class HourlyClassification extends PaymentClassification {
	private TimeCard timeCard;//ʱ�俨
	
	public HourlyClassification(TimeCard timeCard) {
		super();
		this.timeCard = timeCard;
	}
	
	//��Ա��������time��
	public void AddTimeCard(TimeCard timeCard, int empid) {
		Employee emp = PayrollDatabase.getEmployee(empid);
		emp.setPaymentClassification(new HourlyClassification(timeCard));
		PayrollDatabase.addEmployee(empid, emp);
	}

	@Override
	public double CalculatePay(TimeCard timeCard) {//����Сʱ��Ӧ������
		double totalPay = timeCard.getHours()*12;
		
		return totalPay;
	}

	@Override
	public double CalculatePay() {
		return 0;
	}

	@Override
	public double CalculatePay(SalesReceipt salesReceipt) {
		// TODO Auto-generated method stub
		return 0;
	}
}
