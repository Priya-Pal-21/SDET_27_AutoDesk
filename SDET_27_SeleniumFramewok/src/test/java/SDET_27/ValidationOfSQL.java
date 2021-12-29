package SDET_27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ValidationOfSQL {

	public static void main(String[] args) throws Throwable {
		Connection connection = null;
		try {//register the database
			   Driver driver = new Driver();
			   DriverManager.registerDriver(driver);
			
			   //establish the connection between database
			   connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/priya_db", "root", "root");
			   
			   //issue the statement
			Statement statement = connection.createStatement();
			   
			   //execute query[select statements/select query]
			    ResultSet result = statement.executeQuery("select * from studentinforrmation");
			    while(result.next()) {
			    	System.out.println(result.getString(1)+"\t"+result.getString(2));
			    }
			    
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		finally {
			//close the database connection
			   connection.close();
		}
		  
	}

}
