package com.crm.autodesk.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfo {

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactsHeader;
	
	//Initialization	
    public ContactsInfo(WebDriver driver) {
    	PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getContactsHeader() {
		return contactsHeader;
	}
    //Business Utilization
	public String contactVerify() {
		return(contactsHeader.getText());
	}
	
}
