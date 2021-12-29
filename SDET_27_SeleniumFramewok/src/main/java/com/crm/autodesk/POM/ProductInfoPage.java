package com.crm.autodesk.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productHeaderInfo;
	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getProductHeaderInfo() {
		return productHeaderInfo;
	}
	public String productInfoVerify() {
		return (productHeaderInfo.getText());
	}
	
}
