package com.crm.autodesk.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/*
 * @author Priya Pal
 * It contain WebDriver specific reusable actions
 */
public class WebDriverUtility {
	/*
	 * wait for page to load before identifying any synchronize element in DOM[HTML-document]
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}
	/*
	 * wait for page to load before identifying any assyconize[java script actions]element 
	 * in DOM[HTML-document]
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	/*
	 * wait for element to be clickable in GUI and check for specific element in eveery 500milliseconds
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/*
	 * wait for element to be clickable in GUI and check for specific element in eveery 500milliseconds
	 * @param driver
	 * @param element
	 * @param polling time in the form of seconds
	 * @throw Throwable
	 */
	public void waitForElementForCustomTimeOut(WebDriver driver,WebElement element,int pollingTime) throws Throwable {
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/*
	 * use to switch to any window based on window title
	 * @parameter driver
	 * @paarmeter partial window title
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String wId = it.next();
			driver.switchTo().window(wId);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}	
	}
	public void radioButton(WebDriver driver) {
		Select s=new Select((WebElement) driver);
        s.selectByIndex(1);
	}
    /*
     * use to switch to Alert Window and click on OK buttom	
     * @parameter driver
     */
	public void switchToALertWindowAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/*
	 * used to switch to Frame window based on index
	 * @parameter driver
	 * @parameter index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/*
	 * used to switch to Frame window based on id and name
	 * @parameter driver
	 * @parameter id_name_attribute
	 */
	public void switchToFrame(WebDriver driver,String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	/*
	 * used to select value from dropdown based on idex
	 * @parameter driver
	 * @parameter index
	 */
	public void selectDropdown(WebElement  element, int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public void selectDropDown(WebElement element, String dropDown) {
		Select s=new Select(element);
		s.selectByValue(dropDown);
	}
	/*
	 * used to select value from dropdown based on value/option based on GUI
	 * @parameter driver
	 * @parameter text
	 */
	public void selectDropdown(WebElement element, String text) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/*
	 * Used to place Mouse Cursor over Element
	 *  @parameter driver
	 *  @parameter element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();		
	}
	/*
	 * Used to Right Click on Specific Element
	 *  @parameter driver
	 *  @parameter element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	/*
	 * used to handle ScrollBar
	 * @parameter driver
	 * @parameter javaScript
	 */
	public void javaScriptExecutor(WebDriver driver,String javaScript) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
	}
	/*
	 * Used to take Screenshot using Screenshot Name
	 * @parameter driver
	 * @parameter screenshotName
	 */
	public void screenshot(WebDriver driver, String screenshotName) throws Throwable  {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot"+screenshotName+".PNG");
		Files.copy(src, dest);
	}
	/*
	 * Used to Maximize window
	 * @Parameter driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	
	
	
	
}
