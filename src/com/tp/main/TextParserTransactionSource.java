package com.tp.main;

import java.util.Date;
import java.util.Scanner;

import com.tp.attraffiliation.ChangeMemberTransaction;
import com.tp.attraffiliation.ChangeUnaffiliatedTransaction;
import com.tp.attrclassifiction.ChangeCommissionedTransation;
import com.tp.attrclassifiction.ChangeHourlyTransaction;
import com.tp.attrclassifiction.ChangeSalariedTransaction;
import com.tp.attribute.ChangeAddressTransation;
import com.tp.attribute.ChangeNameTransation;
import com.tp.attrpaymentmethod.ChangeDirectTransaction;
import com.tp.attrpaymentmethod.ChangeHoldTransaction;
import com.tp.attrpaymentmethod.ChangeMailTransaction;
import com.tp.controllor.AddCommissionedEmployee;
import com.tp.controllor.AddHourlyEmployee;
import com.tp.controllor.AddSalariedEmployee;
import com.tp.controllor.DelectEmployee;
import com.tp.obj.SalesReceipt;
import com.tp.obj.TimeCard;
import com.tp.pay.PaydayTransaction;
import com.tp.top.TransactionSource;
import com.tp.top.Transation;

public class TextParserTransactionSource implements TransactionSource {

	@Override
	public Transation getTransaction() {
		Transation transaction = null;
		//����ָʾ
		System.out.println("1.����Ա����2.�޸�Ա����Ϣ��3.��Ա����нˮ��4.ɾ��Ա��");
		System.out.println("��ѡ��");
		String s = new Scanner(System.in).nextLine();
		//�ж�������ַ���
		if(!s.matches("\\d{1,}")){
			System.out.println("����Ĳ������֡�����");
			return null;
		}
		int i = Integer.parseInt(s);
		switch(i){//�������ݻ�ȡ����
		case 1:transaction = addEmp();break;
		case 2:transaction = updateAttr();break;
		case 3:transaction = payEmp();break;
		case 4:transaction = delEmp();break;
		default :System.out.println("����������...");
		}
		
		return transaction;
	}

	private Transation updateAttr() {//�޸�Ա����Ϣ
		Transation t = null;
		System.out.println("1.֧��������2.н�ʽ������ͣ�3.��֯��Ϣ��4.����");
		String s = new Scanner(System.in).nextLine();
		if(!s.matches("\\d{1,}")){
			System.out.println("����Ĳ������֣���");
			return null;
		}
		int i = Integer.parseInt(s);
		switch(i){
		case 1:t = chgMethod();break;//�޸�֧������
		case 2:t = chgClassification();break;//�޸�н�ʽ�������
		case 3:t = chgAttraffiliation();break;//�޸���֯��Ϣ
		case 4:t = chgOther();break;//�޸�Ա����������
		default :System.out.println("���������룡����");
		}
		return t;
	}

	//�޸�Ա������֯��ϵ
	private Transation chgAttraffiliation() {
		Transation t = null;
		System.out.println("��ѡ��1.������֯��2.�˳���֯");
		int i = new Scanner(System.in).nextInt();
		switch(i){
		case 1:{
			System.out.println("�����룺id����֯id�����");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("\\d{1,},\\w{1,},\\d{1,}(\\.)?\\d{1,}")){
				System.out.println("���벻��");
				return null;
			}
			String[] ss = s.split(",");
			t = new ChangeMemberTransaction(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]), new Date(), Double.parseDouble(ss[2]));
		};break;
		case 2:{
			System.out.println("�����룺id");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("\\d{1,}")){
				System.out.println("���벻��");
				return null;
			}
			t = new ChangeUnaffiliatedTransaction(Integer.parseInt(s));
		}break;
		default :System.out.println("���벻��");
		}
		return t;
	}

	//�޸�Ա����������
	private Transation chgOther() {
		Transation t = null;
		System.out.print("��ѡ��1.��ַ��2.����: ");
		int i = new Scanner(System.in).nextInt();
		switch(i){
		case 1:{//���ĵ�ַ
			System.out.println("�����룺id����ַ");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("\\d{1,},\\w{1,}")){
				System.out.println("������Ҫ��");
				return null;
			}
			String[] ss = s.split(",");
			t = new ChangeAddressTransation(Integer.parseInt(ss[0]), ss[1]);
		};break;
		case 2:{//��������
			System.out.println("��ѡ��id������");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("\\d{1,},\\w{1,}")){
				System.out.println("�����ʽ����");
				return null;
			}
			String[] ss = s.split(",");
			t = new ChangeNameTransation(Integer.parseInt(ss[0]), ss[1]);
		}break;
		default :System.out.println("�����ʽ����");
		}
		return t;
	}

	//�޸�Ա��н�ʽ�������
	private Transation chgClassification() {
		Transation t = null;
		System.out.print("��ѡ��1.���ۣ�2.ʱ����3.��н��");
		String e = new Scanner(System.in).nextLine();
		if(!e.matches("\\d{1,}")){
			System.out.println("����Ĳ������֣�");
			return null;
		}
		int i = Integer.parseInt(e);
		switch(i){
		case 1:{
			System.out.println("������Ա����id���������ʣ�����");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("\\d{1,},\\d\\.?\\d{1,},\\d\\.?\\d{1,}")){
				System.out.println("���벻��");
				return null;
			}
			String[] ss = s.split(",");
			t = new ChangeCommissionedTransation(Integer.parseInt(ss[0]), Double.parseDouble(ss[1]), Double.parseDouble(ss[2]));
		}break;
		case 2:{
			System.out.println("������Ա����id������ʱ��");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("\\d{1,},\\d{1,}")){
				System.out.println("���벻��");
				return null;
			}
			String[] ss = s.split(",");
			t = new ChangeHourlyTransaction(Integer.parseInt(ss[0]), new TimeCard(new Date(), Integer.parseInt(ss[1])));
		}break;
		case 3:{
			System.out.println("������Ա����id, �̶���н");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("\\d{1,},\\d{1,}\\.?\\d{1,}")){
				System.out.println("���벻��");
				return null;
			}
			String[] ss = s.split(",");
			t = new ChangeSalariedTransaction(Integer.parseInt(ss[0]), Double.parseDouble(ss[1]));
		}break;
		default :System.out.println("���벻��");
		}
		return t;
	}

	private Transation chgMethod() {
		Transation t = null;
		System.out.println("��ѡ��֧����ʽ��1.ת�� , 2.֧Ʊ��3.�ʼ�");
		String s1 = new Scanner(System.in).nextLine();
		//�ж������Ƿ����Ҫ��
		if(!s1.matches("\\d{1,}")){
			System.out.println("���벻��");
			return null;
		}
		int i = Integer.parseInt(s1);
		switch(i){
		case 1:{//ת��֧����ʽ
			System.out.println("������Ա����id���������ƣ������˺�");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("\\d{1,},\\w{1,},\\d{15,}")){
				System.out.println("���벻��");
				return null;
			}
			String[] sp = s.split(",");
			t = new ChangeDirectTransaction(Integer.parseInt(sp[0]), sp[1], sp[2]);
		}break;
		case 2:{//֧Ʊ֧����ʽ
			System.out.println("������Ա����id");
			int empId = new Scanner(System.in).nextInt();
			t = new ChangeHoldTransaction(empId);
		}break;
		case 3:{//�ʼ�֧����ʽ
			System.out.println("������Ա����id������");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("[0-9]{1,},\\w{1,}@\\w{1,}(\\.\\w{1,})+")){
				System.out.println("���벻��");
				return null;
			}
			String[] sp = s.split(",");
			t = new ChangeMailTransaction(Integer.parseInt(sp[0]), sp[1]);
		}break;
		default:System.out.println("Ա����Ϣ���벻��");
		}
		return t;
	}

	private Transation payEmp() {//֧����Ա��֧��н��
		PaydayTransaction pt = new PaydayTransaction();
		
		return pt;
	}

	private Transation delEmp() {//ɾ��Ա��
		int itsId = 0;
		System.out.println("������Ա��id��");
		itsId = new Scanner(System.in).nextInt();
		return new DelectEmployee(itsId);
	}

	private Transation addEmp() {//����Ա��
		Transation transation = null;
		//1.commissioned 2.hourlyemp 3.salaryemp
		System.out.println("1.commissioned 2.hourlyemp 3.salaryemp");
		System.out.print("��ѡ��");
		String s = new Scanner(System.in).nextLine();
		//�ж�����ĸ�ʽ�Ƿ����Ҫ��
		if(!s.matches("\\d{1,}")){
			System.out.println("�����ʽ����������");
			return null;
		}
		int i = Integer.parseInt(s);
		switch(i){
		case 1:{//�����г���Ա��
			System.out.println("������: id����ַ�����֣��������ʣ���𵥼ۣ�������");
			String emp = new Scanner(System.in).nextLine();
			if(!emp.matches("\\d{1,},\\w{1,},\\w{1,},\\d{1,}\\.?\\d{1,},\\d{1,}\\.?\\d{1,},\\d{1,}\\.?\\d{1,}")) {//�����ʽ�����Ͼͷ���null
				System.out.println("�����ʽ����");
				return null;
			}
			String[] e = emp.trim().split(",");
			transation = new AddCommissionedEmployee(
					Integer.parseInt(e[0]), e[1], e[2], Double.parseDouble(e[3]),
					Double.parseDouble(e[4]), new SalesReceipt(new Date(), Double.parseDouble(e[5])));
		}break;
		case 2:{//����Сʱ��
			System.out.println("������Ա����id����ַ�����֣���ʱ");
			String emp = new Scanner(System.in).nextLine();
			if(!emp.matches("\\d{1,},\\w{1,},\\w{1,},\\d{1,}")) {//�����ʽ�����Ͼͷ���null
				return null;
			}
			String[] e = emp.trim().split(",");
			transation = new AddHourlyEmployee(Integer.parseInt(e[0]), e[1], e[2], new TimeCard(new Date(),Integer.parseInt(e[3])));
		}break;
		case 3:{//���ӹ̶�н��Ա��
			System.out.println("������Ա����id����ַ�����֣�н��");
			String emp = new Scanner(System.in).nextLine();
			if(!emp.matches("\\d{1,},\\w{1,},\\w{1,},\\d{1,}\\.?\\d{1,}")) {//�����ʽ�����Ͼͷ���null
				System.out.println("�����ʽ����������");
				return null;
			}
			String[] e = emp.trim().split(",");
			transation = new AddSalariedEmployee(Integer.parseInt(e[0]), e[1], e[2], Double.parseDouble(e[3]));
		}break;
		default:System.out.println("�����ʽ����������");
		}
		return transation;
	}

}
