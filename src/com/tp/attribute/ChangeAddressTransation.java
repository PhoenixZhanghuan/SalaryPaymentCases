package com.tp.attribute;

import com.tp.obj.Employee;
import com.tp.top.ChangeEmployeeTransation;

public class ChangeAddressTransation extends ChangeEmployeeTransation {
	private String address;
	public ChangeAddressTransation(int empid, String  address) {
		super(empid);
		this.address = address;
	}

	//���Ĺ�Ա��ַ
	@Override
	protected void change(Employee emp) {
		emp.setAddress(address);
	}

}
