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
		//操作指示
		System.out.println("1.增加员工；2.修改员工信息；3.给员工发薪水；4.删除员工");
		System.out.println("请选择：");
		String s = new Scanner(System.in).nextLine();
		//判断输入的字符串
		if(!s.matches("\\d{1,}")){
			System.out.println("输入的不是数字。。。");
			return null;
		}
		int i = Integer.parseInt(s);
		switch(i){//根据数据获取操作
		case 1:transaction = addEmp();break;
		case 2:transaction = updateAttr();break;
		case 3:transaction = payEmp();break;
		case 4:transaction = delEmp();break;
		default :System.out.println("请重新输入...");
		}
		
		return transaction;
	}

	private Transation updateAttr() {//修改员工信息
		Transation t = null;
		System.out.println("1.支付方法，2.薪资结算类型，3.组织信息，4.其他");
		String s = new Scanner(System.in).nextLine();
		if(!s.matches("\\d{1,}")){
			System.out.println("输入的不是数字！！");
			return null;
		}
		int i = Integer.parseInt(s);
		switch(i){
		case 1:t = chgMethod();break;//修改支付方法
		case 2:t = chgClassification();break;//修改薪资结算类型
		case 3:t = chgAttraffiliation();break;//修改组织信息
		case 4:t = chgOther();break;//修改员工其他属性
		default :System.out.println("请重新输入！！！");
		}
		return t;
	}

	//修改员工的组织关系
	private Transation chgAttraffiliation() {
		Transation t = null;
		System.out.println("请选择：1.加入组织，2.退出组织");
		int i = new Scanner(System.in).nextInt();
		switch(i){
		case 1:{
			System.out.println("请输入：id，组织id，会费");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("\\d{1,},\\w{1,},\\d{1,}(\\.)?\\d{1,}")){
				System.out.println("输入不符");
				return null;
			}
			String[] ss = s.split(",");
			t = new ChangeMemberTransaction(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]), new Date(), Double.parseDouble(ss[2]));
		};break;
		case 2:{
			System.out.println("请输入：id");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("\\d{1,}")){
				System.out.println("输入不符");
				return null;
			}
			t = new ChangeUnaffiliatedTransaction(Integer.parseInt(s));
		}break;
		default :System.out.println("输入不符");
		}
		return t;
	}

	//修改员工其他属性
	private Transation chgOther() {
		Transation t = null;
		System.out.print("请选择：1.地址，2.名字: ");
		int i = new Scanner(System.in).nextInt();
		switch(i){
		case 1:{//更改地址
			System.out.println("请输入：id，地址");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("\\d{1,},\\w{1,}")){
				System.out.println("不符合要求");
				return null;
			}
			String[] ss = s.split(",");
			t = new ChangeAddressTransation(Integer.parseInt(ss[0]), ss[1]);
		};break;
		case 2:{//更改名字
			System.out.println("请选择：id，名字");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("\\d{1,},\\w{1,}")){
				System.out.println("输入格式不符");
				return null;
			}
			String[] ss = s.split(",");
			t = new ChangeNameTransation(Integer.parseInt(ss[0]), ss[1]);
		}break;
		default :System.out.println("输入格式不符");
		}
		return t;
	}

	//修改员工薪资结算类型
	private Transation chgClassification() {
		Transation t = null;
		System.out.print("请选择：1.销售，2.时工，3.月薪：");
		String e = new Scanner(System.in).nextLine();
		if(!e.matches("\\d{1,}")){
			System.out.println("输入的不是数字！");
			return null;
		}
		int i = Integer.parseInt(e);
		switch(i){
		case 1:{
			System.out.println("请输入员工：id，基本工资，单价");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("\\d{1,},\\d\\.?\\d{1,},\\d\\.?\\d{1,}")){
				System.out.println("输入不符");
				return null;
			}
			String[] ss = s.split(",");
			t = new ChangeCommissionedTransation(Integer.parseInt(ss[0]), Double.parseDouble(ss[1]), Double.parseDouble(ss[2]));
		}break;
		case 2:{
			System.out.println("请输入员工：id，工作时长");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("\\d{1,},\\d{1,}")){
				System.out.println("输入不符");
				return null;
			}
			String[] ss = s.split(",");
			t = new ChangeHourlyTransaction(Integer.parseInt(ss[0]), new TimeCard(new Date(), Integer.parseInt(ss[1])));
		}break;
		case 3:{
			System.out.println("请输入员工：id, 固定月薪");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("\\d{1,},\\d{1,}\\.?\\d{1,}")){
				System.out.println("输入不符");
				return null;
			}
			String[] ss = s.split(",");
			t = new ChangeSalariedTransaction(Integer.parseInt(ss[0]), Double.parseDouble(ss[1]));
		}break;
		default :System.out.println("输入不符");
		}
		return t;
	}

	private Transation chgMethod() {
		Transation t = null;
		System.out.println("请选择支付方式：1.转账 , 2.支票，3.邮件");
		String s1 = new Scanner(System.in).nextLine();
		//判断输入是否符合要求
		if(!s1.matches("\\d{1,}")){
			System.out.println("输入不符");
			return null;
		}
		int i = Integer.parseInt(s1);
		switch(i){
		case 1:{//转账支付方式
			System.out.println("请输入员工：id，银行名称，银行账号");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("\\d{1,},\\w{1,},\\d{15,}")){
				System.out.println("输入不符");
				return null;
			}
			String[] sp = s.split(",");
			t = new ChangeDirectTransaction(Integer.parseInt(sp[0]), sp[1], sp[2]);
		}break;
		case 2:{//支票支付方式
			System.out.println("请输入员工：id");
			int empId = new Scanner(System.in).nextInt();
			t = new ChangeHoldTransaction(empId);
		}break;
		case 3:{//邮件支付方式
			System.out.println("请输入员工：id，邮箱");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("[0-9]{1,},\\w{1,}@\\w{1,}(\\.\\w{1,})+")){
				System.out.println("输入不符");
				return null;
			}
			String[] sp = s.split(",");
			t = new ChangeMailTransaction(Integer.parseInt(sp[0]), sp[1]);
		}break;
		default:System.out.println("员工信息输入不符");
		}
		return t;
	}

	private Transation payEmp() {//支付给员工支付薪资
		PaydayTransaction pt = new PaydayTransaction();
		
		return pt;
	}

	private Transation delEmp() {//删除员工
		int itsId = 0;
		System.out.println("请输入员工id：");
		itsId = new Scanner(System.in).nextInt();
		return new DelectEmployee(itsId);
	}

	private Transation addEmp() {//增加员工
		Transation transation = null;
		//1.commissioned 2.hourlyemp 3.salaryemp
		System.out.println("1.commissioned 2.hourlyemp 3.salaryemp");
		System.out.print("请选择：");
		String s = new Scanner(System.in).nextLine();
		//判断输入的格式是否符合要求
		if(!s.matches("\\d{1,}")){
			System.out.println("输入格式不符。。。");
			return null;
		}
		int i = Integer.parseInt(s);
		switch(i){
		case 1:{//增加有酬金的员工
			System.out.println("请输入: id，地址，名字，基本工资，酬金单价，销售量");
			String emp = new Scanner(System.in).nextLine();
			if(!emp.matches("\\d{1,},\\w{1,},\\w{1,},\\d{1,}\\.?\\d{1,},\\d{1,}\\.?\\d{1,},\\d{1,}\\.?\\d{1,}")) {//如果格式不符合就返回null
				System.out.println("输入格式不符");
				return null;
			}
			String[] e = emp.trim().split(",");
			transation = new AddCommissionedEmployee(
					Integer.parseInt(e[0]), e[1], e[2], Double.parseDouble(e[3]),
					Double.parseDouble(e[4]), new SalesReceipt(new Date(), Double.parseDouble(e[5])));
		}break;
		case 2:{//增加小时工
			System.out.println("请输入员工的id，地址，名字，工时");
			String emp = new Scanner(System.in).nextLine();
			if(!emp.matches("\\d{1,},\\w{1,},\\w{1,},\\d{1,}")) {//如果格式不符合就返回null
				return null;
			}
			String[] e = emp.trim().split(",");
			transation = new AddHourlyEmployee(Integer.parseInt(e[0]), e[1], e[2], new TimeCard(new Date(),Integer.parseInt(e[3])));
		}break;
		case 3:{//增加固定薪资员工
			System.out.println("请输入员工的id，地址，名字，薪资");
			String emp = new Scanner(System.in).nextLine();
			if(!emp.matches("\\d{1,},\\w{1,},\\w{1,},\\d{1,}\\.?\\d{1,}")) {//如果格式不符合就返回null
				System.out.println("输入格式不符。。。");
				return null;
			}
			String[] e = emp.trim().split(",");
			transation = new AddSalariedEmployee(Integer.parseInt(e[0]), e[1], e[2], Double.parseDouble(e[3]));
		}break;
		default:System.out.println("输入格式不符。。。");
		}
		return transation;
	}

}
