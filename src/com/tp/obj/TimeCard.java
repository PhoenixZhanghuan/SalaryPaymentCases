package com.tp.obj;

import java.util.Date;

public class TimeCard {
	private Date date;
	private int hours;
	private int empid;
	
	public TimeCard(Date date, int hours) {
		super();
		this.date = date;
		this.hours = hours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}
	
	
}
