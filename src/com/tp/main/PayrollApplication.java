package com.tp.main;

import com.tp.top.Transation;

public class PayrollApplication {
	public static void main(String[] args) {
		while(true){
			TextParserTransactionSource tpt = new TextParserTransactionSource();
			Transation t = tpt.getTransaction();
			if(t==null){
				System.out.println("获取到的Transation为null");
				
			}else{
				t.execute();
			}
		}
	}
}
