package com.crm.AutoDesk.orgTest;

import org.testng.AssertJUnit;
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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.POM.CreateNeworganizationPage;
import com.crm.autodesk.POM.HomePage;
import com.crm.autodesk.POM.LoginPage;
import com.crm.autodesk.POM.OrganizationInfoPage;
import com.crm.autodesk.POM.OrganizationPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
@Listeners(com.crm.autodesk.genericutility.ListnerImplementation.class)
public class CreateOrgWithIndustry_TypeTest extends BaseClass
{
	 @Test(groups = "smokeSuite")
	  public void CreateOrgWithIndustry_TypeTest() throws Throwable 
       {
   		//java Utility
           int randomNum = jLib.getRandomNumber();
   		//Excel Utility
   		String orgName = eLib.getDataFromExcelSheet("Sheet1", 1, 2)+ randomNum;
   		String industry = eLib.getDataFromExcelSheet("Sheet1", 3, 4);
   		String type = eLib.getDataFromExcelSheet("Sheet1", 5, 4);

		//navigate to organization module
        HomePage hp=new HomePage(driver);  
        hp.createOrganization();
        
		//click on create organization button
        OrganizationPage op=new OrganizationPage(driver);
        op.clickOnCreateContactLookupImg();
        
        //enter all the details and create new organization
        CreateNeworganizationPage cnop=new CreateNeworganizationPage(driver);
        cnop.organizationDetailsWithIndustryAndType(orgName, industry, type);
	
        //verify organization name in header of msg
        OrganizationInfoPage oip=new OrganizationInfoPage(driver);
        String actmsg = oip.organizationsInfo();
        AssertJUnit.assertTrue(actmsg.contains(orgName));
  
        //verify INDUSTRY drop down using softAssert bcz not mandatory field 
        String industryText = driver.findElement(By.className("small")).getText();
        SoftAssert sa=new SoftAssert();
        AssertJUnit.assertTrue(industryText.contains(industry));
        sa.assertAll();
       
        //verify TYPE drop down using softAssert bcz not mandatory field 
        String typeText = driver.findElement(By.className("small")).getText();
        AssertJUnit.assertTrue(typeText.contains(type));
        sa.assertAll();
    
	}
}
