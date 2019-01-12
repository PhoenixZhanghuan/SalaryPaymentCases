package com.tp.obj;

import com.tp.top.Affiliation;

/**
 * 定义组织关系:
 * 1.id
 * 2.收费
 * @author Administrator
 *
 */
public class UnionAffiliation implements Affiliation {
	private int unionId;
	private ServiceCharge serviceCharge;
	
	//有参构造
	public UnionAffiliation(int unionId, ServiceCharge serviceCharge) {
		super();
		this.unionId = unionId;
		this.serviceCharge = serviceCharge;
	}
	public int getUnionId() {
		return unionId;
	}
	public void setUnionId(int unionId) {
		this.unionId = unionId;
	}
	public ServiceCharge getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(ServiceCharge serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	@Override
	public double calculateDeductions() {
		// TODO Auto-generated method stub
		return serviceCharge.getAmount();
	}
}
