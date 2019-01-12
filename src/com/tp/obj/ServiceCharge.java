package com.tp.obj;

import java.util.Date;

/**
 * 本类定义员工的服务费
 * @author Administrator
 *
 */
public class ServiceCharge {
	private Date date;
	private double amount;//数量
	
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
