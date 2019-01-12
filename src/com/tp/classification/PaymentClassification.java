package com.tp.classification;

import com.tp.obj.Paycheck;
import com.tp.obj.SalesReceipt;
import com.tp.obj.TimeCard;

public abstract class PaymentClassification {
	private double salary;//�������ʡ��ܹ���
	private double commissionRate;//���۵���
	private SalesReceipt saleReceipt; //���ۿ�
	private TimeCard timeCard;//ʱ�俨
	
	//����Ա�����ܹ���
	public abstract double CalculatePay();
	public abstract double CalculatePay(TimeCard timeCard);//����ʱ������
	public abstract double CalculatePay(SalesReceipt salesReceipt);//����ʱ������
	
}
