package com.crm.autodesk.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage
{
       @FindBy(xpath="//img[@alt='Create Organization...']")
       private WebElement createOrganizationLookUpImg;
       @FindBy(name="search_text")
       private WebElement searchForEdt;
       @FindBy(name="submit")
       private WebElement submitBtn;
//Initialization
       public OrganizationPage(WebDriver driver){
      		PageFactory.initElements(driver, this);
      	   }
//Utilization
	public WebElement getCreateOrganizationLookUpImg() {
		return createOrganizationLookUpImg;
	}

	public WebElement getSearchForEdt() {
		return searchForEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
//Business Library
	public void clickOnCreateContactLookupImg() {
		createOrganizationLookUpImg.click();
	}      
}
