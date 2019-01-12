package com.tp.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tp.obj.Employee;

public class PayrollDatabase {
	private static int empId;
	private static Map<Integer,Employee> dictionary = new HashMap();
	private static Map<Integer,Employee> UnionIdAndEmployee;
	
	public static Map<Integer, Employee> getDictionary() {
		return dictionary;
	}

	public static void setDictionary(Map<Integer, Employee> dictionary) {
		PayrollDatabase.dictionary = dictionary;
	}

	//����ͨ��empid��ù�Ա����ķ���
	public static Employee getEmployee(int empid){
		return dictionary.get(empid);
	}
	
	//���彫��Ա��ӵ�Map�ķ���
	public static void addEmployee(int empid, Employee e){
		dictionary.put(empid, e);
	}
	
	/**
	 * ���Ȼ�ȡ���м�ֵset���ϣ�Ȼ������������ϣ���ÿ����ֵ��Map�ж�Ӧ��ֵȡ������ӵ�list��
	 * @return
	 */
	public static List<Employee> getEmployees(){
		List<Employee> list = new LinkedList<Employee>();
		Set<Integer> keySet = dictionary.keySet();
		Iterator<Integer> it = keySet.iterator();
		while(it.hasNext()){
			Integer next = it.next();
			Employee emp = dictionary.get(next);
			list.add(emp);
		}
		return list;
	}
	
	//����ɾ����Ա�ķ���
	public static void delectEmployee(int empid){
		Employee e = dictionary.get(empid);
		if(e!=null){
			dictionary.remove(empid);
			System.out.println("�ɹ�ɾ��idΪ"+empid+"��Ա��");
		}else{
			System.out.println("������idΪ"+empid+"��Ա��");
		}
	}
	
	//����ͨ����֯id��ȡԱ��
	public static Employee getEmployeeByUnionId(int unionId){
		return dictionary.get(unionId);
	}
	
	//���������֯��ϵ
	public static void addUnion(int empid, Employee e){
		UnionIdAndEmployee.put(empid, e);
	}
	
	//����ɾ��Ա����֯��ϵ
	public static void delUnion(int unionid){
		UnionIdAndEmployee.remove(unionid);
	}
}
