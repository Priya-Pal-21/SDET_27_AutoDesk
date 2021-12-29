package com.crm.AutoDesk.Contact.Test;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.POM.ContactPage;
import com.crm.autodesk.POM.ContactsInfo;
import com.crm.autodesk.POM.CreateNewContactPage;
import com.crm.autodesk.POM.HomePage;
import com.crm.autodesk.POM.LoginPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.BaseClass1;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
@Listeners(com.crm.autodesk.genericutility.ListnerImplementation.class)
public class CreateContactTest extends BaseClass {

    @Test(groups = "smokeSuite",retryAnalyzer = com.crm.autodesk.genericutility.RetryAnalyser.class)
	public void createContactTest() throws Throwable 
	{	
		//Get Random num from java Utility
        int randomNum = jLib.getRandomNumber();
		//Excel Utility
		String contactName = eLib.getDataFromExcelSheet("Sheet1", 1, 4)+ randomNum;
        
		//navigate to contacts module
        HomePage hp=new HomePage(driver);  
        hp.createContacts();
        
        //contact
        ContactPage cp=new ContactPage(driver);
        cp.clickOnContactImg();
        Reporter.log("clickOnContactImg",true);
        
        //Craete new contact page
        CreateNewContactPage cnc=new CreateNewContactPage(driver);
        cnc.createNewContacts(contactName);
        Reporter.log("createNewContacts",true);

        //validation
        ContactsInfo ci=new ContactsInfo(driver);
        String check = ci.contactVerify();
        Reporter.log("ContactsInfo",true);

        //HardAssert
        //Assert.assertTrue(check.contains(contactName));
        //SoftAssert
        SoftAssert sa=new SoftAssert();
        sa.assertTrue(check.contains(contactName));
        sa.assertAll();
	}

}
