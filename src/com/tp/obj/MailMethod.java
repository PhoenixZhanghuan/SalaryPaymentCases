package com.tp.obj;

import com.tp.top.PaymentMethod;

public class MailMethod implements PaymentMethod {
	private String address;//邮件地址

	
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
	
	//根据付款方式给员工支付
	@Override
	public void pay(Paycheck pc) {
		System.out.println("使用邮件支付");
	}
	
}
