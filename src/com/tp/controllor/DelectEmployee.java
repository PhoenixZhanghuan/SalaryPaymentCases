package com.tp.controllor;

import com.tp.dao.PayrollDatabase;
import com.tp.top.Transation;

public class DelectEmployee implements Transation {
	private int itsId;
	
	
	public DelectEmployee(int itsId) {
		super();
		this.itsId = itsId;
	}

	@Override
	public void trasation() {
		// TODO Auto-generated method stub
		
	} 

	@Override
	public void execute() {
		PayrollDatabase.delectEmployee(itsId);
	}

}
