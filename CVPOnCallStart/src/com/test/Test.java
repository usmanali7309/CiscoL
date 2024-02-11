package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;

public class Test {
	
	
	public static void main(String[] args) {
		
		
		Context ctx = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String nextNode = "";
		
		try{
			
	    String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/cvpdemo?useSSL=false&allowPublicKeyRetrieval=true&characterEncoding=utf8";
        String username = "root";
        String password = "password";
        
        // Load driver class
        Class.forName(driverClassName);
 
        // Obtain a connection
         con = DriverManager.getConnection(url, username, password);
 
        // Obtain a statement
          stmt = con.createStatement();
			
			rs = stmt.executeQuery("select State from state where empId=2");
			
			
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			
		  
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	
}

		
	

}
