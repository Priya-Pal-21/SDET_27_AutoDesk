package com.rmgyantra.testscript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoDB_VerifyCreatedByName {

	public static void main(String[] args) throws SQLException 
	{
		String expectedResult="Priya";
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate("insert into project(project_id,created_by,created_on,project_name,status,team_size)values('TY_PROJ_012','system01','16/12/2021','automated01','On Go',4)");

		if(result==1)//true
		{
			System.out.println("one set of data is added to the DB");
		}
		else {
			System.out.println("Data is added to the DB");
		}
		ResultSet result1 = statement.executeQuery("select * from project");
		while(result1.next()) {
			if(result1.getString(2).equals(expectedResult)) {
				System.out.println("Yes Data is present in DataBase");
			}
		}
		connection.close();
		
		
	}

}
