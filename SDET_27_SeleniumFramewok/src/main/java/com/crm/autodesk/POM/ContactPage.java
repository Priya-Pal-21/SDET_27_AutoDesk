package com.crm.autodesk.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
      @FindBy(xpath="//img[@title='Create Contact...']")
      private WebElement createContactsLookUpImg;
      @FindBy(name="search_text")
      private WebElement searchForEdt;
      @FindBy(name="submit")
      private WebElement searchNowBtn;
  
      //Initialization
    public ContactPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
    	PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getCreateContactsLookUpImg() {
		return createContactsLookUpImg;
	}

	public WebElement getSearchForEdt() {
		return searchForEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

  	 //Business Library
	public void clickOnContactImg() {
		createContactsLookUpImg.click();
	}
}
