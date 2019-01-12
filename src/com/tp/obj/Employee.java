package com.tp.obj;

import com.tp.classification.CommissionedClassification;
import com.tp.classification.HourlyClassification;
import com.tp.classification.PaymentClassification;
import com.tp.classification.SalariedClassification;
import com.tp.top.Affiliation;
import com.tp.top.PaymentMethod;
import com.tp.top.PaymentSchedule;

public class Employee {
	//��Ա����
	private int empId;//id
	private String address;//��ַ
	private String name;//����
	private PaymentClassification paymentClassification;//��н�ʼ��㷽����н��
	private PaymentSchedule schedule;//����н�ʵ�ʱ��
	private PaymentMethod paymethod;//����н�ʵķ�ʽ
	private Affiliation affiliation;//���˼������֯
	
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
	public void payDay(Paycheck pc) {//���㹤��
		 //�ж��Ƿ���
		if(paymentClassification instanceof SalariedClassification){//��нԱ��
			SalariedClassification sc = (SalariedClassification)paymentClassification;
			double grossPay = sc.CalculatePay();//����Ӧ������
			double deductions = 0;//����Ӧ�۹���
			if(affiliation!=null){
				deductions = affiliation.calculateDeductions();
			}
			double netPay = grossPay - deductions;
			pc.setGrossPay(grossPay);
			pc.setDeductions(deductions);
			pc.setNetPay(netPay);
			if(paymethod instanceof DirectMethod){//�ж�Ա��ѡ�����ָ��ʽ����ִ��pay����
				DirectMethod dm = (DirectMethod)paymethod;
				dm.pay(pc);
			}else if(paymethod instanceof MailMethod){
				MailMethod mm = (MailMethod)paymethod;
				mm.pay(pc);
			}else{
				HoldMethod hm = (HoldMethod)paymethod;
				hm.pay(pc);
			}
			
		}else if(paymentClassification instanceof HourlyClassification){//Сʱ��
			HourlyClassification hc = (HourlyClassification)paymentClassification;
			double grossPay = hc.CalculatePay();//����Ӧ������
			double deductions = 0;//����Ӧ�۹���
			if(affiliation!=null){
				deductions = affiliation.calculateDeductions();
			}
			double netPay = grossPay - deductions;
			pc.setGrossPay(grossPay);
			pc.setDeductions(deductions);
			pc.setNetPay(netPay);
			if(paymethod instanceof DirectMethod){//�ж�Ա��ѡ�����ָ��ʽ����ִ��pay����
				DirectMethod dm = (DirectMethod)paymethod;
				dm.pay(pc);
			}else if(paymethod instanceof MailMethod){
				MailMethod mm = (MailMethod)paymethod;
				mm.pay(pc);
			}else{
				HoldMethod hm = (HoldMethod)paymethod;
				hm.pay(pc);
			}
		}else{//��𷢷�
			CommissionedClassification cc = (CommissionedClassification)paymentClassification;
			double grossPay = cc.CalculatePay();//����Ӧ������
			double deductions = 0;//����Ӧ�۹���
			if(affiliation!=null){
				deductions = affiliation.calculateDeductions();
			}
			double netPay = grossPay - deductions;
			pc.setGrossPay(grossPay);
			pc.setDeductions(deductions);
			pc.setNetPay(netPay);
			if(paymethod instanceof DirectMethod){//�ж�Ա��ѡ�����ָ��ʽ����ִ��pay����
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
