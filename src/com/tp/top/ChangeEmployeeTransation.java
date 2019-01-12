package com.tp.top;

import com.tp.classification.PaymentClassification;
import com.tp.dao.PayrollDatabase;
import com.tp.obj.Employee;

public abstract class ChangeEmployeeTransation implements Transation {
	protected int empid;
	
	public ChangeEmployeeTransation(int empid) {
		super();
		this.empid = empid;
	}

	@Override
	public void trasation() {
		// TODO Auto-generated method stub
		
	}

	public void execute(){//通过id获得对象
		Employee emp = PayrollDatabase.getEmployee(empid);
		//将对象交给虚方法处理
		if(emp!=null){
			change(emp);
			System.out.println("员工属性已修改成功！！");
		}else{
			System.out.println("不存在id为"+empid+"的员工");
		}
	}

	protected abstract void change(Employee emp);//根据修改不同的属性进行实现

}
