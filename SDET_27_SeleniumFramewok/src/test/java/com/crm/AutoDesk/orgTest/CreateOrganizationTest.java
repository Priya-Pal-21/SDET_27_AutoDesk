package com.crm.AutoDesk.orgTest;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.POM.CreateNeworganizationPage;
import com.crm.autodesk.POM.HomePage;
import com.crm.autodesk.POM.LoginPage;
import com.crm.autodesk.POM.OrganizationInfoPage;
import com.crm.autodesk.POM.OrganizationPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.BaseClass1;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
@Listeners(com.crm.autodesk.genericutility.ListnerImplementation.class)
public class CreateOrganizationTest extends BaseClass1 {

	@Test(groups = "smokeSuite")
	public void createOrganizationTest() throws Throwable 
	{
		// getRandom number
		int randomNo = jLib.getRandomNumber();
		
		// read test data from excel sheet
		String orgName = eLib.getDataFromExcelSheet("Sheet1", 1, 2)+ randomNo;
        
		//navigate to organization module
        HomePage hp=new HomePage(driver);  
        hp.createOrganization();
        
		//click on create organization button
        OrganizationPage op=new OrganizationPage(driver);
        op.clickOnCreateContactLookupImg();
        
        //enter all the details and create new organization
        CreateNeworganizationPage cnop=new CreateNeworganizationPage(driver);
        cnop.organizationDetails(orgName);
		
        //verify organization name in header of msg
        OrganizationInfoPage oip=new OrganizationInfoPage(driver);
        String actmsg = oip.organizationsInfo();
        
        Assert.assertTrue(actmsg.contains(orgName));
	}

}
