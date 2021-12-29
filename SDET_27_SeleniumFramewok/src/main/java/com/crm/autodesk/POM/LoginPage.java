package com.crm.autodesk.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class LoginPage
{
	//Step1 declare web element
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	@FindBy(id="submitButton")
	private WebElement loginBtm;
	
	//step2 Initialize web element using constructor when obj created
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	//step3 Utilize
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtm() {
		return loginBtm;
	}
	//business library
	public void login(String username,String password) {
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtm.click();
	}	
}
