package com.tp.obj;

import com.tp.classification.CommissionedClassification;
import com.tp.classification.HourlyClassification;
import com.tp.classification.PaymentClassification;
import com.tp.classification.SalariedClassification;
import com.tp.top.Affiliation;
import com.tp.top.PaymentMethod;
import com.tp.top.PaymentSchedule;

public class Employee {
	//雇员属性
	private int empId;//id
	private String address;//地址
	private String name;//姓名
	private PaymentClassification paymentClassification;//有薪资计算方法和薪资
	private PaymentSchedule schedule;//计算薪资的时间
	private PaymentMethod paymethod;//发放薪资的方式
	private Affiliation affiliation;//个人加入的组织
	
	public Affiliation getAffiliation() {
		return affiliation;
	}
	public void setAffiliation(Affiliation affiliation) {
		this.affiliation = affiliation;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PaymentClassification getPaymentClassification() {
		return paymentClassification;
	}
	public void setPaymentClassification(PaymentClassification paymentClassification) {
		this.paymentClassification = paymentClassification;
	}
	
	public PaymentSchedule getSchedule() {
		return schedule;
	}
	public void setSchedule(PaymentSchedule paymentSchedule) {
		this.schedule = paymentSchedule;
	}
	public PaymentMethod getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(PaymentMethod paymethod) {
		this.paymethod = paymethod;
	}
	public void payDay(Paycheck pc) {//计算工资
		 //判断是否是
		if(paymentClassification instanceof SalariedClassification){//带薪员工
			SalariedClassification sc = (SalariedClassification)paymentClassification;
			double grossPay = sc.CalculatePay();//计算应发工资
			double deductions = 0;//计算应扣工资
			if(affiliation!=null){
				deductions = affiliation.calculateDeductions();
			}
			double netPay = grossPay - deductions;
			pc.setGrossPay(grossPay);
			pc.setDeductions(deductions);
			pc.setNetPay(netPay);
			if(paymethod instanceof DirectMethod){//判断员工选用哪种付款方式，再执行pay方法
				DirectMethod dm = (DirectMethod)paymethod;
				dm.pay(pc);
			}else if(paymethod instanceof MailMethod){
				MailMethod mm = (MailMethod)paymethod;
				mm.pay(pc);
			}else{
				HoldMethod hm = (HoldMethod)paymethod;
				hm.pay(pc);
			}
			
		}else if(paymentClassification instanceof HourlyClassification){//小时工
			HourlyClassification hc = (HourlyClassification)paymentClassification;
			double grossPay = hc.CalculatePay();//计算应发工资
			double deductions = 0;//计算应扣工资
			if(affiliation!=null){
				deductions = affiliation.calculateDeductions();
			}
			double netPay = grossPay - deductions;
			pc.setGrossPay(grossPay);
			pc.setDeductions(deductions);
			pc.setNetPay(netPay);
			if(paymethod instanceof DirectMethod){//判断员工选用哪种付款方式，再执行pay方法
				DirectMethod dm = (DirectMethod)paymethod;
				dm.pay(pc);
			}else if(paymethod instanceof MailMethod){
				MailMethod mm = (MailMethod)paymethod;
				mm.pay(pc);
			}else{
				HoldMethod hm = (HoldMethod)paymethod;
				hm.pay(pc);
			}
		}else{//酬金发放
			CommissionedClassification cc = (CommissionedClassification)paymentClassification;
			double grossPay = cc.CalculatePay();//计算应发工资
			double deductions = 0;//计算应扣工资
			if(affiliation!=null){
				deductions = affiliation.calculateDeductions();
			}
			double netPay = grossPay - deductions;
			pc.setGrossPay(grossPay);
			pc.setDeductions(deductions);
			pc.setNetPay(netPay);
			if(paymethod instanceof DirectMethod){//判断员工选用哪种付款方式，再执行pay方法
				DirectMethod dm = (DirectMethod)paymethod;
				dm.pay(pc);
			}else if(paymethod instanceof MailMethod){
				MailMethod mm = (MailMethod)paymethod;
				mm.pay(pc);
			}else{
				HoldMethod hm = (HoldMethod)paymethod;
				hm.pay(pc);
			}
		}
	}
}
