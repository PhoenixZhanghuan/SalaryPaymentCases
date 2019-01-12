package com.tp.Service;

import java.util.Date;

import com.tp.classification.HourlyClassification;
import com.tp.classification.PaymentClassification;
import com.tp.dao.PayrollDatabase;
import com.tp.obj.Employee;
import com.tp.obj.TimeCard;
import com.tp.top.Transation;

public class TimeCardTransation implements Transation {
	private Date date;
	private int hours;
	private int empid;
	
	public TimeCardTransation(int empid, Date date, int hours) {
		super();
		this.date = date;
		this.hours = hours;
		this.empid = empid;
	}

	@Override
	public void trasation() {
		// TODO Auto-generated method stub
		
	}

	//为时工增加时间卡
	@Override
	public void execute() {
		Employee emp = PayrollDatabase.getEmployee(empid);
		if(emp!=null){
			if(emp.getPaymentClassification() instanceof HourlyClassification){
				HourlyClassification hc = (HourlyClassification)emp.getPaymentClassification();
				hc.AddTimeCard(new TimeCard(date, hours),empid);
			}else{
				System.out.println("尝试增加时间卡给非钟点工！");
			}
		}else{
			System.out.println("查无此人！");
		}
		
	}
	
}
