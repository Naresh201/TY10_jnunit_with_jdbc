package com.te.junit_jdbc_test;

public class Mainclass {

	public static void main(String[] args) {
		Account account = new Account();
		
	 int count = account.withDrawBalance();
	 System.out.println(count);

	}

}
