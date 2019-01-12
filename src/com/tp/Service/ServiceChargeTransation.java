package com.tp.Service;

import java.util.Date;

import com.tp.dao.PayrollDatabase;
import com.tp.obj.Employee;
import com.tp.obj.ServiceCharge;
import com.tp.obj.UnionAffiliation;
import com.tp.top.Affiliation;
import com.tp.top.Transation;

public class ServiceChargeTransation implements Transation {
	private Date date;
	private double amount;
	private int unionId;
	
	public ServiceChargeTransation(Date date, double amount, int unionId) {
		super();
		this.date = date;
		this.amount = amount;
		this.unionId = unionId;
	}

	@Override
	public void trasation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		//���ݿ���Ա��id
		Employee emp = PayrollDatabase.getEmployeeByUnionId(unionId);
		//�ж�Ա���Ƿ����
		if(emp!=null){
			UnionAffiliation aff = (UnionAffiliation) emp.getAffiliation();
			//�ı���֯
			aff.setServiceCharge(new ServiceCharge(date, amount));
			aff.setUnionId(unionId);
		
		}else{
			System.out.println("���޴��ˣ�");
		}
	}

}
