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

	public void execute(){//ͨ��id��ö���
		Employee emp = PayrollDatabase.getEmployee(empid);
		//�����󽻸��鷽������
		if(emp!=null){
			change(emp);
			System.out.println("Ա���������޸ĳɹ�����");
		}else{
			System.out.println("������idΪ"+empid+"��Ա��");
		}
	}

	protected abstract void change(Employee emp);//�����޸Ĳ�ͬ�����Խ���ʵ��

}
