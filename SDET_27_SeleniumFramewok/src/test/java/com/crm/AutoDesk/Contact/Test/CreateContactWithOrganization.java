package com.crm.AutoDesk.Contact.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.POM.ContactPage;
import com.crm.autodesk.POM.ContactsInfo;
import com.crm.autodesk.POM.CreateNewContactPage;
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
public class CreateContactWithOrganization extends BaseClass {

	@Test(groups = "regressionSuite")
	public void CreateContactWithOrganization() throws Throwable 
	{ 
		FileUtility fLib=new FileUtility();
        int randomNo = jLib.getRandomNumber();
       
        //Excel Utility
        String orgName = eLib.getDataFromExcelSheet("Sheet1", 1, 2)+ randomNo;
        String contactName = eLib.getDataFromExcelSheet("Sheet1", 1, 4)+ randomNo;

       //navigate to organization module
       HomePage hp=new HomePage(driver);
       hp.createOrganization();
       
       //click on craete org icon
       OrganizationPage op=new OrganizationPage(driver);
       op.clickOnCreateContactLookupImg();
       
       //enter all the details and click on save button
       CreateNeworganizationPage cnop=new CreateNeworganizationPage(driver);
       cnop.organizationDetails(orgName);
		
       //wait for element to be active
       wLib.waitForElementToBeClickable(driver, driver.findElement(By.className("dvHeaderText")));

       //navigate to contact module    
       hp.createContacts();
       
       //click on create contact img
       ContactPage cp=new ContactPage(driver);
       cp.clickOnContactImg();

       //enter all the details and create new contact
       CreateNewContactPage cncp=new CreateNewContactPage(driver);
       cncp.createNewContactsWithOrgName(contactName, orgName, driver);

       System.out.println(contactName+"==> actual organization name");
       
       ContactsInfo ci=new ContactsInfo(driver);
       String check = ci.contactVerify();
       
       //validation
       SoftAssert sa=new SoftAssert();
       sa.assertTrue(check.contains(contactName));
       sa.assertAll();

	}
}
