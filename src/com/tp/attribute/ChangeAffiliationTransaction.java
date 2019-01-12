package com.tp.attribute;
/**
 * 改变雇员的组织关系属性
 */
import com.tp.obj.Employee;
import com.tp.top.ChangeEmployeeTransation;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransation {

	public ChangeAffiliationTransaction(int empid) {
		super(empid);
		// TODO Auto-generated constructor stub
	}
}
