package com.tp.pay;


import java.util.Calendar;
/**
 * 给员工发薪水
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
	Calendar date = Calendar.getInstance();//调用是的当天时间
	
	@Override
	public void trasation() {
		
	}
	
	@Override
	public void execute() {
		//获取所有员工对象
		List<Employee> list = PayrollDatabase.getEmployees();
		//判断是否有员工
		if(list.isEmpty()){
			System.out.println("数据库无员工信息。。。");
			return;
		}
		//遍历所有员工
		for(Employee e:list){
			PaymentSchedule schedule = e.getSchedule();
			if(schedule.isPayDate(date)){//判断是不是该发工资了
				Paycheck pc = new Paycheck(date);
				e.payDay(pc);
			}
		}	
	}
}