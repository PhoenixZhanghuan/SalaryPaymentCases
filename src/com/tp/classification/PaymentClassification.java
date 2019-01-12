package com.tp.classification;

import com.tp.obj.Paycheck;
import com.tp.obj.SalesReceipt;
import com.tp.obj.TimeCard;

public abstract class PaymentClassification {
	private double salary;//基本工资、总工资
	private double commissionRate;//销售单价
	private SalesReceipt saleReceipt; //销售卡
	private TimeCard timeCard;//时间卡
	
	//计算员工的总工资
	public abstract double CalculatePay();
	public abstract double CalculatePay(TimeCard timeCard);//计算时工工资
	public abstract double CalculatePay(SalesReceipt salesReceipt);//计算时工工资
	
}
