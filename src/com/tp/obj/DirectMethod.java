package com.tp.obj;

import com.tp.top.PaymentMethod;

public class DirectMethod implements PaymentMethod {
	private String bank;
	private String account;
	
	public DirectMethod(String bank, String account) {
		super();
		this.bank = bank;
		this.account = account;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	//
	@Override
	public void pay(Paycheck pc) {
		System.out.println("已经支付到银行账户");
	}
	
	
}
