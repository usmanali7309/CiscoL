package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;

import com.audium.server.session.DecisionElementData;
import com.audium.server.voiceElement.DecisionElementBase;

public class CheckMAExpressEnable extends DecisionElementBase{

	@Override
	public String doDecision(String arg0, DecisionElementData data) throws Exception {
		
			
			Context ctx = null;
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			String nextNode = "";
			
			data.addToLog("Current State is 0:",nextNode);
			
			try{
				
		    String driverClassName = "com.mysql.jdbc.Driver";
	        String url = "jdbc:mysql://localhost:3306/cvpdemo?useSSL=false&allowPublicKeyRetrieval=true&characterEncoding=utf8";
	        String username = "root";
	        String password = "password";
	        
	        data.addToLog("Current State is 1:",nextNode);
	        
	        // Load driver class
	        Class.forName(driverClassName);
	 
	        // Obtain a connection
	         con = DriverManager.getConnection(url, username, password);
	 
	        // Obtain a statement
	          stmt = con.createStatement();
	          
	          data.addToLog("Current State is 2:",nextNode);
				
				rs = stmt.executeQuery("select State from state where empId=1");
				
				while(rs.next()) {
					
					data.addToLog("Current State is :", rs.getString(1));
					
					if(rs.getString(1).equals("true")) {
						
						nextNode = "true";
						
					}else {
						
						nextNode = "No";
					}
					
				}
										
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		return nextNode;
	}

	
		
		
	}

	
	
	

