package com.tp.obj;

import java.util.Date;

/**
 * ���ඨ��Ա���ķ����
 * @author Administrator
 *
 */
public class ServiceCharge {
	private Date date;
	private double amount;//����
	
	public ServiceCharge(Date date, double amount) {
		super();
		this.date = date;
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
