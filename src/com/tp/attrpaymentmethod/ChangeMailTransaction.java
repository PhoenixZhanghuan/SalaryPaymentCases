package com.tp.attrpaymentmethod;

import com.tp.attribute.ChangeMethodTransaction;
import com.tp.obj.Employee;
import com.tp.obj.MailMethod;

public class ChangeMailTransaction extends ChangeMethodTransaction {
	private String address;
	public ChangeMailTransaction(int empid, String address) {
		super(empid);
		this.address = address;
	}
	
	//将邮件支付支付方式放入对象
	@Override
	protected void change(Employee emp) {
		emp.setPaymethod(new MailMethod(address));
	}

}
