package com.crm.AutoDesk.product.Test;

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
public class CreateProductWithQuickCreate extends BaseClass{

	@Test(groups = "smokeSuite")
	public void CreateProductWithQuickCreate() throws Throwable
	{
		
		//java Utility
        int randomNum = jLib.getRandomNumber();
		//Excel Utility
		String productName = eLib.getDataFromExcelSheet("Sheet1", 1, 5)+ randomNum;
        
        //Select product from quick create drop down
		HomePage hp=new HomePage(driver);
		hp.createProducts();
        
        //Create a new Product
		ProductPage pp=new ProductPage(driver);
		pp.clickOnProductImg();
        
		CreateNewProductPage cnpp=new CreateNewProductPage(driver);
		cnpp.createNewProduct(productName);
        
        //verify
		ProductInfoPage pi=new ProductInfoPage(driver);
		String VerifyProductName = pi.productInfoVerify();
		Assert.assertTrue(VerifyProductName.contains(productName));

	}
 }
