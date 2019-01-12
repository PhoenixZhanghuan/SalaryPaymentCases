package com.tp.Service;

import java.util.Date;

import com.tp.classification.CommissionedClassification;
import com.tp.classification.SalariedClassification;
import com.tp.dao.PayrollDatabase;
import com.tp.obj.Employee;
import com.tp.obj.SalesReceipt;
import com.tp.top.Transation;

public class SaleReceiptTransation implements Transation {
	private Date date;
	private double amount;
	private int empid;
	
	
	public SaleReceiptTransation(int empid, Date date, double amount) {
		super();
		this.date = date;
		this.amount = amount;
		this.empid = empid;
	}

	@Override
	public void trasation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		//数据库获得对象
		Employee emp = PayrollDatabase.getEmployee(empid);
		//对象中增加销售凭条
		if(emp!=null){
			if(emp.getPaymentClassification() instanceof CommissionedClassification){
				CommissionedClassification cc = (CommissionedClassification) emp.getPaymentClassification();
				cc.addSaleReceipt(new SalesReceipt(date, amount), empid);
			}else{
				System.out.println("非销售人员中插入凭条！");
			}
		}else{
			System.out.println("查无此人！");
		}
	}
	
}
