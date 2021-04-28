package com.te.junit_jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Account {
	Connection connection = null;
	PreparedStatement statement = null;
	PreparedStatement statement1 = null;
	public int withDrawBalance(){
		int count=0;
		String username="naresh";
		int amount=10000;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","LION");
			String query ="select * from account";
			     statement = connection.prepareStatement(query);    
			     statement.setString(1,username);  
			    ResultSet re =   statement.executeQuery();
			    if(re.next() ){
			    	int currentamount = re.getInt("amount");
			    	if(amount<currentamount&& re.getString("username").equalsIgnoreCase(username)){
			    		String query1 ="update account set amount=? where username=?";
			    		
			    		statement1 =  connection.prepareStatement(query1);
			    		
			    		currentamount = currentamount-amount;
			    		
			    		statement1.setInt(1, currentamount);
			    		statement1.setString(2, username);
			    		
			    		 count = statement1.executeUpdate();
			    	}else {
			    		System.out.println(" required balance does not exists");
			    	}
			    }
		} catch (ClassNotFoundException | SQLException e){	
			e.printStackTrace();
		} 
		return count;
	}
}
