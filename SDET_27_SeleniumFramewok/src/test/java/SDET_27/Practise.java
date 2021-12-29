package SDET_27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Practise {

	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(null, null, null);
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from studentinforrmation");
        while(result.next()) {
        	System.out.println(result.getString(1));
        }
       int result2 = statement.executeUpdate("insert into studentinforrmation(id,fname,lname,address)values('Priya','pal','bng')");
        if(result2==1) {
        	System.out.println("one set of data is added to DB");
        }
        else {
        	System.out.println("Fail to added the data");
        }
		connection.close();
		
	}

}
