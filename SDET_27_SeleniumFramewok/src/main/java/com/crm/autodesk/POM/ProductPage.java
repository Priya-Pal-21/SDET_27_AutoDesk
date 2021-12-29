package com.crm.autodesk.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement productLookUpImg;
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductLookUpImg() {
		return productLookUpImg;
	}
	public void clickOnProductImg() {
		productLookUpImg.click();
	}
		
}
