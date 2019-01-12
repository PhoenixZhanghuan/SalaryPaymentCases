package com.tp.attraffiliation;

import com.tp.attribute.ChangeAffiliationTransaction;
import com.tp.obj.Employee;

public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {

	public ChangeUnaffiliatedTransaction(int empid) {
		super(empid);
		// TODO Auto-generated constructor stub
	}

	//无组织会员设置为空
	@Override
	protected void change(Employee emp) {
		emp.setAffiliation(null);
	}

}
