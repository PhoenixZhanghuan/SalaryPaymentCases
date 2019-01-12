package com.tp.attraffiliation;
import java.util.Date;

/**
 * 改变员工组织属性
 */
import com.tp.attribute.ChangeAffiliationTransaction;
import com.tp.obj.Employee;
import com.tp.obj.ServiceCharge;
import com.tp.obj.UnionAffiliation;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction {
	private int unionId;
	private ServiceCharge servicecharge;
	public ChangeMemberTransaction(int empid, int unionId, Date date, double amount) {
		super(empid);
		this.servicecharge = new ServiceCharge(date, amount);
		this.unionId = unionId;
	}

	//将组织信息加入对象中
	@Override
	protected void change(Employee emp) {
		emp.setAffiliation(new UnionAffiliation(unionId,servicecharge));
	}

}
