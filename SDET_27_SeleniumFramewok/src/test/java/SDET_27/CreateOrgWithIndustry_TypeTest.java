package SDET_27;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateOrgWithIndustry_TypeTest 
{
       public static void main(String[] args) throws Throwable 
       {
    	   FileUtility fLib=new FileUtility();
   		JavaUtility jLib=new JavaUtility();
           ExcelUtility eLib=new ExcelUtility();
   		WebDriverUtility wLib=new WebDriverUtility();
   		
   		//File Utility
   		String URL = fLib.getPropertyKeyValue("url");
   		String USERNAME = fLib.getPropertyKeyValue("username");
   		String PASSWORD = fLib.getPropertyKeyValue("password");
   		String BROWSER = fLib.getPropertyKeyValue("browser");
   		
   		//java Utility
           int randomNum = jLib.getRandomNumber();
   		//Excel Utility
   		String orgName = eLib.getDataFromExcelSheet("Sheet1", 1, 2)+ randomNum;
   		String industry = eLib.getDataFromExcelSheet("Sheet1", 3, 4)+ randomNum;
   		String type = eLib.getDataFromExcelSheet("Sheet1", 5, 4)+ randomNum;
   		
		//WebDriver
		WebDriver driver=null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("ie")) {
			driver=new InternetExplorerDriver();
		}
		else if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else{
			driver=new ChromeDriver();
		}
		
		//login
        wLib.waitForPageToLoad(driver);
		driver.get(URL);
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();
		
		//navigate to organization module
        driver.findElement(By.linkText("Organizations")).click();
        
		//click on create organization button
        driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
        
        //enter all the details and create new organization
        driver.findElement(By.name("accountname")).sendKeys(orgName);
        
        //dropdown Industry
        WebElement verifyIndustry = driver.findElement(By.name("industry"));
        wLib.selectDropdown(verifyIndustry, industry);
        
        //dropdown type
        WebElement verifyType = driver.findElement(By.name("accounttype"));   
        wLib.selectDropdown(verifyType, type);
        
        //save button
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
        //verify organization name in header of msg
        
        	String actualMsg = driver.findElement(By.className("dvHeaderText")).getText();
            if(actualMsg.contains(orgName)) {
          	  System.out.println("Organization create successfully");
            }
            else {
          	  System.out.println("Organization not create successfully");
            }
              //verify drop down   
            String industryText = driver.findElement(By.className("small")).getText();
            if(industryText.contains(industry)) {
        	    System.out.println("PASS");
            }
        	else {
        		System.out.println("FAIL");
        	}
         
            String typeText = driver.findElement(By.className("small")).getText();
            if(typeText.contains(type)) {
              	System.out.println("Text is Present");
            }
            else {
            	System.out.println("Text is not Present"); 
            }
            
            //logout
            wLib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
            driver.findElement(By.linkText("Sign Out")).click();
            driver.quit();      
	}
}
