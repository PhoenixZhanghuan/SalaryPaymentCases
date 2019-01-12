package com.tp.obj;

import com.tp.top.PaymentMethod;

public class HoldMethod implements PaymentMethod {

	//
	@Override
	public void pay(Paycheck pc) {
		// TODO Auto-generated method stub
		System.out.println("创建一张支票");
	}

}
