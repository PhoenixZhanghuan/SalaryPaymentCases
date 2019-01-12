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
	
	//���ʼ�֧��֧����ʽ�������
	@Override
	protected void change(Employee emp) {
		emp.setPaymethod(new MailMethod(address));
	}

}
