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

	//定义通过empid获得雇员对象的方法
	public static Employee getEmployee(int empid){
		return dictionary.get(empid);
	}
	
	//定义将雇员添加到Map的方法
	public static void addEmployee(int empid, Employee e){
		dictionary.put(empid, e);
	}
	
	/**
	 * 首先获取所有键值set集合，然后迭代遍历集合，对每个键值在Map中对应的值取出来添加到list上
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
	
	//定义删除雇员的方法
	public static void delectEmployee(int empid){
		Employee e = dictionary.get(empid);
		if(e!=null){
			dictionary.remove(empid);
			System.out.println("成功删除id为"+empid+"的员工");
		}else{
			System.out.println("不存在id为"+empid+"的员工");
		}
	}
	
	//定义通过组织id获取员工
	public static Employee getEmployeeByUnionId(int unionId){
		return dictionary.get(unionId);
	}
	
	//定义添加组织关系
	public static void addUnion(int empid, Employee e){
		UnionIdAndEmployee.put(empid, e);
	}
	
	//定义删除员工组织关系
	public static void delUnion(int unionid){
		UnionIdAndEmployee.remove(unionid);
	}
}
