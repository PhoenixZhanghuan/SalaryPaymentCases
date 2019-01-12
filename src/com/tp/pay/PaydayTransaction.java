package com.tp.pay;


import java.util.Calendar;
/**
 * ��Ա����нˮ
 */
import java.util.Date;
import java.util.List;

import com.tp.dao.PayrollDatabase;
import com.tp.obj.Employee;
import com.tp.obj.Paycheck;
import com.tp.schedule.MonthlySchedule;
import com.tp.schedule.WeeklySchedule;
import com.tp.top.PaymentSchedule;
import com.tp.top.Transation;

import java.util.*;

import java.util.Calendar;
public class PaydayTransaction implements Transation {
	Calendar date = Calendar.getInstance();//�����ǵĵ���ʱ��
	
	@Override
	public void trasation() {
		
	}
	
	@Override
	public void execute() {
		//��ȡ����Ա������
		List<Employee> list = PayrollDatabase.getEmployees();
		//�ж��Ƿ���Ա��
		if(list.isEmpty()){
			System.out.println("���ݿ���Ա����Ϣ������");
			return;
		}
		//��������Ա��
		for(Employee e:list){
			PaymentSchedule schedule = e.getSchedule();
			if(schedule.isPayDate(date)){//�ж��ǲ��Ǹ÷�������
				Paycheck pc = new Paycheck(date);
				e.payDay(pc);
			}
		}	
	}
}