package com.tp.attribute;

import com.tp.obj.Employee;
import com.tp.top.ChangeEmployeeTransation;

public class ChangeAddressTransation extends ChangeEmployeeTransation {
	private String address;
	public ChangeAddressTransation(int empid, String  address) {
		super(empid);
		this.address = address;
	}

	//更改雇员地址
	@Override
	protected void change(Employee emp) {
		emp.setAddress(address);
	}

}
