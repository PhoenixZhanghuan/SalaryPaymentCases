package com.tp.attraffiliation;
import java.util.Date;

/**
 * �ı�Ա����֯����
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

	//����֯��Ϣ���������
	@Override
	protected void change(Employee emp) {
		emp.setAffiliation(new UnionAffiliation(unionId,servicecharge));
	}

}
