package com.rmgyantra.testscript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class AutoAddProject_VerifyProjectName {

	public static void main(String[] args) throws Throwable 
	{
	    WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8084/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("koyal03");
		//driver.findElement(By.xpath("input[@type='text'])[4]")).sendKeys("21");    (for Disable button)
		  
		
		driver.findElement(By.name("createdBy")).sendKeys("suhash03");
		
		WebElement dropdown = driver.findElement(By.name("status"));
		Select s=new Select(dropdown);
	
		s.selectByVisibleText("Completed");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		
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
		  if (proName.equals(expectedProjectName)) {
			  System.out.println("pass: data is present");
			
		}else {
			System.out.println("fail: data is not present");
		}
		  
		  
		  connection.close();
		  
	}

}
