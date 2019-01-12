package com.tp.classification;

import com.tp.dao.PayrollDatabase;
import com.tp.obj.Employee;
import com.tp.obj.Paycheck;
import com.tp.obj.SalesReceipt;
import com.tp.obj.TimeCard;

public class CommissionedClassification extends PaymentClassification {
	private double salary;//基本工资
	private double commissionRate;//销售单价
	private SalesReceipt saleReceipt; //销售量

	public CommissionedClassification(double salary, double commissionRate, SalesReceipt saleReceipt) {
		super();
		this.salary = salary;
		this.commissionRate = commissionRate;
		this.saleReceipt = saleReceipt;
	}

	//酬金发放计算
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
	
	//增加酬金卡
	public void addSaleReceipt(SalesReceipt salesReceipt, int empid) {
		double amount = salesReceipt.getAmount()+this.saleReceipt.getAmount();//累加销售数量
		this.saleReceipt.setAmount(amount);
		this.saleReceipt.setDate(salesReceipt.getDate());//累计后日期更新
		Employee emp = PayrollDatabase.getEmployee(empid);//将酬金计算类添加到员工对象
		emp.setPaymentClassification(this);
	}
}
