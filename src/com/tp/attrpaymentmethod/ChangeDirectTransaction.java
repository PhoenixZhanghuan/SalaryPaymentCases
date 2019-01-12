package com.tp.attrpaymentmethod;

import com.tp.attribute.ChangeMethodTransaction;
import com.tp.obj.DirectMethod;
import com.tp.obj.Employee;

public class ChangeDirectTransaction extends ChangeMethodTransaction {
	private String bank;
	private String account;
	
	public ChangeDirectTransaction(int empid, String bank, String account) {
		super(empid);
		this.bank = bank;
		this.account = account;
	}

	//将将账号加入员工中
	@Override
	protected void change(Employee emp) {
		emp.setPaymethod(new DirectMethod(bank,account));
	}

}
