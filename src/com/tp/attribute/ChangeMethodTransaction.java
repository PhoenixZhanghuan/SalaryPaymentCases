package com.tp.attribute;

import com.tp.obj.Employee;
import com.tp.top.ChangeEmployeeTransation;

public abstract class ChangeMethodTransaction extends ChangeEmployeeTransation {
	
	public ChangeMethodTransaction(int empid) {
		super(empid);
	}
}
