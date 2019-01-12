package com.tp.attribute;

import com.tp.obj.Employee;
import com.tp.top.ChangeEmployeeTransation;

public class ChangeNameTransation extends ChangeEmployeeTransation{
	private String name;
	
	public ChangeNameTransation(int empid, String name) {
		super(empid);
		this.name = name;
	}

	//���Ĺ�Ա����
	@Override
	protected void change(Employee emp) {
		emp.setName(name);
	}
	
}
