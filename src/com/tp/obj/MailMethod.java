package com.tp.obj;

import com.tp.top.PaymentMethod;

public class MailMethod implements PaymentMethod {
	private String address;//�ʼ���ַ

	
	public MailMethod(String address) {
		super();
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	//���ݸ��ʽ��Ա��֧��
	@Override
	public void pay(Paycheck pc) {
		System.out.println("ʹ���ʼ�֧��");
	}
	
}
