package com.crm.AutoDesk.product.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
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

import com.crm.autodesk.POM.CreateNewProductPage;
import com.crm.autodesk.POM.HomePage;
import com.crm.autodesk.POM.LoginPage;
import com.crm.autodesk.POM.ProductInfoPage;
import com.crm.autodesk.POM.ProductPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
@Listeners(com.crm.autodesk.genericutility.ListnerImplementation.class)
public class Create_ProductWith_MarketingGroup extends BaseClass{

	@Test(groups = "regressionSuite")
	public void Create_ProductWith_MarketingGroup() throws Throwable {

		
		//java Utility
        int randomNum = jLib.getRandomNumber();
		//Excel Utility
		String productName = eLib.getDataFromExcelSheet("Sheet1", 1, 5)+ randomNum;
		String stockDropdown = eLib.getDataFromExcelSheet("Sheet1", 3, 5);
	        
	        //Select product from quick create drop down
	        HomePage hp=new HomePage(driver);
	        hp.createProducts();
	        
	        //Create a new Product
	        ProductPage pp=new ProductPage(driver);
	        pp.clickOnProductImg();
	        
	        CreateNewProductPage cpp=new CreateNewProductPage(driver);
	        cpp.createNewProductWithMarketingDropdown(productName, stockDropdown);
	        
	        //verify using hardAssert bcz mandatory field it is
	        ProductInfoPage pip=new ProductInfoPage(driver);
	        String check = pip.productInfoVerify();
	        Assert.assertTrue(check.contains(productName));
	      
	}

}
