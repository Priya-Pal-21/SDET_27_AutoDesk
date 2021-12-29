package com.crm.autodesk.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgVerifyInfo;
	
	//Initialization	
    public OrganizationInfoPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrgVerifyInfo() {
		return orgVerifyInfo;
	}
    
	//Business Library
	public String organizationsInfo() {
		return (orgVerifyInfo.getText());
	}
		
}
