package com.tp.controllor;

import com.tp.classification.PaymentClassification;
import com.tp.dao.PayrollDatabase;
import com.tp.obj.Employee;
import com.tp.top.PaymentMethod;
import com.tp.top.PaymentSchedule;
import com.tp.top.Transation;

public abstract class AddEmployee implements Transation {
	//增加的雇员具有的属性
	protected int empid;
	protected String itsAddress;
	protected String itsName;
	
	public AddEmployee(int empid, String itsAddress, String itsName) {
		super();
		this.empid = empid;
		this.itsAddress = itsAddress;
		this.itsName = itsName;
	}

	@Override
	public void trasation() {
		// TODO Auto-generated method stub
		   
	}
	
	@Override
	public void execute() {//把对象放入数据库中
		Employee e = PayrollDatabase.getEmployee(empid);
		if(e!=null){//限制添加相同id的员工
			System.out.println("id为"+empid+"的员工已经存在！！");
			return;
		}
		PaymentClassification classification = getClassification();
		PaymentSchedule schedule = getSchedule();
		PaymentMethod method = getMethod();
		Employee emp = new Employee();
		emp.setEmpId(empid);
		emp.setAddress(itsAddress);
		emp.setName(itsName);
		emp.setPaymentClassification(classification);
		emp.setSchedule(schedule);
		emp.setPaymethod(method);
		PayrollDatabase.addEmployee(empid, emp);
		System.out.println("已经成功添加员工！！！");//提示成功添加了员工
	}
	
	protected abstract PaymentClassification getClassification();//获得对象类型
	protected abstract PaymentSchedule getSchedule();//获得对象发工资的时间
	protected abstract PaymentMethod getMethod() ;//发薪水的方式
}
