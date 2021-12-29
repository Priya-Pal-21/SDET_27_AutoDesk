package com.crm.autodesk.genericutility;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.autodesk.POM.HomePage;
import com.crm.autodesk.POM.LoginPage;

public class BaseClass1 {
	
	public DataBaseConnectionUtility dLib = new DataBaseConnectionUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriver driver;
		
	@BeforeSuite
	public void connectToDB_1()
	{
		System.out.println("Connected Database");
	}
    
	@BeforeClass
		public void launchBrowser() throws Throwable
		{
		driver=new ChromeDriver();
		wLib.waitForPageToLoad(driver);
		wLib.maximizeWindow(driver);
		
//		String BROWSER = fLib.getPropertyKeyValue("browser");
//		String URL = fLib.getPropertyKeyValue("url");
//		
//		if(BROWSER.equals("chrome")) {
//			driver=new ChromeDriver();
//		}
//		else if(BROWSER.equals("firefox")) {
//			driver=new FirefoxDriver();
//		}
//		else if(BROWSER.equals("ie")) {
//			driver=new InternetExplorerDriver();
//		}
//		else if(BROWSER.equals("chrome")) {
//			driver=new ChromeDriver();
//		}
//		else{
//			driver=new ChromeDriver();
//		}
//		
//		wLib.waitForPageToLoad(driver);
//		driver.get(URL);		
		}
	
	@BeforeMethod
	public void loginToApp() throws Throwable
	{
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		
	}
	
	@AfterMethod
	public void logoutApp()
	{
		HomePage hp = new HomePage(driver);
		hp.logout(driver);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
	@AfterSuite
	public void closeConnectionToDB_2()
	{
		System.out.println("Connection closed");
	}

}
