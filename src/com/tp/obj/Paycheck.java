package com.tp.obj;

import java.util.Calendar;

public class Paycheck {
	private double grossPay;//工资总数
	private double deductions;//扣除工资
	private double netPay;//实付工资
	private Calendar date;//日期
	
	public Paycheck(Calendar date) {
		this.date = date;
	}

	public double getGrossPay() {
		return grossPay;
	}

	public void setGrossPay(double grossPay) {
		this.grossPay = grossPay;
	}

	public double getDeductions() {
		return deductions;
	}

	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

	public double getNetPay() {
		return netPay;
	}

	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
}
