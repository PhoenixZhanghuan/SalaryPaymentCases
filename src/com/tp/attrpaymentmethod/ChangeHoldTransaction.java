package com.tp.attrpaymentmethod;

import com.tp.attribute.ChangeMethodTransaction;
import com.tp.obj.Employee;
import com.tp.obj.HoldMethod;

public class ChangeHoldTransaction extends ChangeMethodTransaction {

	public ChangeHoldTransaction(int empid) {
		super(empid);
		
	}

	//��֧Ʊ֧����������Ա������
	@Override
	protected void change(Employee emp) {
		emp.setPaymethod(new HoldMethod());
	}

}
