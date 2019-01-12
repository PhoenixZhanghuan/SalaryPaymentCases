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
		//���ݿ��ö���
		Employee emp = PayrollDatabase.getEmployee(empid);
		//��������������ƾ��
		if(emp!=null){
			if(emp.getPaymentClassification() instanceof CommissionedClassification){
				CommissionedClassification cc = (CommissionedClassification) emp.getPaymentClassification();
				cc.addSaleReceipt(new SalesReceipt(date, amount), empid);
			}else{
				System.out.println("��������Ա�в���ƾ����");
			}
		}else{
			System.out.println("���޴��ˣ�");
		}
	}
	
}
