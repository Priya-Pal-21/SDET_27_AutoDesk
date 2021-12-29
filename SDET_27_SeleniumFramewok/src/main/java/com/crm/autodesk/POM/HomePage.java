package com.crm.autodesk.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
       @FindBy(linkText="Organizations")
       private WebElement orgnizationsLink;
       @FindBy(linkText="Contacts")
       private WebElement contactsLink;
       @FindBy(linkText="Products")
       private WebElement productsLink;
       @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
       private WebElement administratorImg;
       @FindBy(linkText="Sign Out")
       private WebElement logoutBtn;
     
       public HomePage(WebDriver driver){
   		PageFactory.initElements(driver, this);
   	       }

	public WebElement getOrgnizationsLink() {
		return orgnizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	//BUsiness Library
	public void createOrganization() {
		orgnizationsLink.click();
	}
	public void createContacts() {
		contactsLink.click();
	}
	public void createProducts() {
		productsLink.click();
	}
	public void logout(WebDriver driver) {
		
		mouseOverOnElement(driver, administratorImg);
		logoutBtn.click();
	}		
}
