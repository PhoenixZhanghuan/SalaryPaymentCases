package com.tp.obj;

import java.util.Calendar;

public class Paycheck {
	private double grossPay;//��������
	private double deductions;//�۳�����
	private double netPay;//ʵ������
	private Calendar date;//����
	
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
