package SDET_27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerificationColumnName {

	public static void main(String[] args) throws SQLException 
	{
		String ecpectedProjectname="TestYantra";
         Driver driver=new Driver();
         DriverManager.registerDriver(driver);
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
         Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select * from Project");
        while(result.next()) {
        	if(result.getString(4).equals(ecpectedProjectname)) {
        		System.out.println("PASS");
        	}
        }
        connection.close();
	}

}
