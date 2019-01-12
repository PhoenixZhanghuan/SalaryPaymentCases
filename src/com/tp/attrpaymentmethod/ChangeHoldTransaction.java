package com.tp.attrpaymentmethod;

import com.tp.attribute.ChangeMethodTransaction;
import com.tp.obj.Employee;
import com.tp.obj.HoldMethod;

public class ChangeHoldTransaction extends ChangeMethodTransaction {

	public ChangeHoldTransaction(int empid) {
		super(empid);
		
	}

	//将支票支付对象放入雇员对象中
	@Override
	protected void change(Employee emp) {
		emp.setPaymethod(new HoldMethod());
	}

}
