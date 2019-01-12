package com.tp.controllor;

import com.tp.classification.PaymentClassification;
import com.tp.dao.PayrollDatabase;
import com.tp.obj.Employee;
import com.tp.top.PaymentMethod;
import com.tp.top.PaymentSchedule;
import com.tp.top.Transation;

public abstract class AddEmployee implements Transation {
	//���ӵĹ�Ա���е�����
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
	public void execute() {//�Ѷ���������ݿ���
		Employee e = PayrollDatabase.getEmployee(empid);
		if(e!=null){//���������ͬid��Ա��
			System.out.println("idΪ"+empid+"��Ա���Ѿ����ڣ���");
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
		System.out.println("�Ѿ��ɹ����Ա��������");//��ʾ�ɹ������Ա��
	}
	
	protected abstract PaymentClassification getClassification();//��ö�������
	protected abstract PaymentSchedule getSchedule();//��ö��󷢹��ʵ�ʱ��
	protected abstract PaymentMethod getMethod() ;//��нˮ�ķ�ʽ
}
