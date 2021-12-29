package com.crm.autodesk.genericutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.autodesk.POM.HomePage;
import com.crm.autodesk.POM.LoginPage;
//basic configuration
public class BaseClass {
        //public DataBaseConnectionUtility dbLib=new DataBaseConnectionUtility();
	    public FileUtility fLib=new FileUtility();
	    public JavaUtility jLib=new JavaUtility();
	    public ExcelUtility eLib=new ExcelUtility();
	    public WebDriverUtility wLib=new WebDriverUtility();
	    public WebDriver driver;
	    public static WebDriver sdriver;
//	    @BeforeSuite(groups = {"smokeSuite","regressionSuite"})
//	    public void openDBConnection() {
//	    	System.out.println("Connection to DataBase");
//	    }
	    @Parameters("browser")
		@BeforeClass(groups = {"smokeSuite","regressionSuite"})
		public void launchBrowser(String BROWSER) throws Throwable
		{		
		//String BROWSER = fLib.getPropertyKeyValue("browser");
			System.out.println(BROWSER);
			String URL = fLib.getPropertyKeyValue("url");
	
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
			sdriver=driver;
			wLib.waitForPageToLoad(driver);
			wLib.maximizeWindow(driver);
			driver.get("http://localhost:8888");

		}

		@BeforeMethod(groups = {"smokeSuite","regressionSuite"})
		public void loginToApp() throws Throwable {		
			String USERNAME = fLib.getPropertyKeyValue("username");
			System.out.println(USERNAME);
			String PASSWORD = fLib.getPropertyKeyValue("password");
			System.out.println(PASSWORD);

			LoginPage lp=new LoginPage(driver);
			lp.login(USERNAME, PASSWORD);	
		}
		
		@AfterMethod(groups = {"smokeSuite","regressionSuite"})
		public void logout() 
		{
			HomePage hp=new HomePage(driver);
			hp.logout(driver);
		}

		@AfterClass(groups = {"smokeSuite","regressionSuite"})
		public void closeBrowser() {
			driver.quit();
		}
			
//		@AfterSuite(groups = {"smokeSuite","regressionSuite"})
//		public void configAS() {
//			System.out.println("Close DataBase");
//		}
}
