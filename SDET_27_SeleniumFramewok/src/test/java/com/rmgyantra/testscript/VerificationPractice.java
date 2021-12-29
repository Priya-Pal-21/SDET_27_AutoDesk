package com.rmgyantra.testscript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerificationPractice {

	public static void main(String[] args) throws SQLException {
		String expectedProjectName="TestYantra"; 
		  Driver driver1=new Driver();
		  DriverManager.registerDriver(driver1); 
		  Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root"); 
		  Statement statement = connection.createStatement(); 
		  ResultSet result = statement.executeQuery("select * from project");
		  String proName=null;
		  while(result.next()) 
		  { 
			  if(result.getString(4).equals(expectedProjectName)) 
			  { 
		          proName= result.getString(4);
		          System.out.println("Project name from databas==>"+proName);
		      } 
			  
	      } 
		  if (result.equals(expectedProjectName)) {
			  System.out.println("pass: data is present");
			
		}else {
			System.out.println("fail: data is not present");
		}
		  
		  
		  connection.close();
		  
	}
}

