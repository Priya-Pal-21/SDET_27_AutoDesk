package SDET_27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NotSelectQuery {

	public static void main(String[] args) throws SQLException {
		//register the database
		   Driver driver = new Driver();
		   DriverManager.registerDriver(driver);
		
		   //establish the connection between database
		   Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/priya_db", "root", "root");
		   
		   //issue the statement
		   Statement statement = connection.createStatement();
		   
		   //execute query/update[NOT select statements/NOt select query]
		    int result = statement.executeUpdate("insert into studentinforrmation (FNAME,LNAME,ADDRESS) values('katrina','kaif','usa')");
		   if(result==1)
		   {
			   System.out.println("one set of data is added to the DB");
		   }
		   else
		   {
			   System.out.println("Data is not added to the DB");
		   }
		   
		   //close the database connection
		   connection.close();

	}

}
