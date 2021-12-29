package com.crm.autodesk.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateNewProductPage extends WebDriverUtility {

	@FindBy(name="productname")
	private WebElement productNameEdt;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(xpath="(//input[@onclick='toggleAssignType(this.value)'])[2]")
	private WebElement marketingGropRadioButton;
	@FindBy(xpath = "//select[@name='assigned_group_id']")
	private WebElement marketingDropDown;
	
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductNameEdt() {
		return productNameEdt;
	}
	public WebElement getMarketingRadiobtn() {
		return marketingGropRadioButton;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getMarketingDropDown() {
		return marketingDropDown;
	}

	//Business Library for createing New Product
	public void createNewProduct(String productName) {
		productNameEdt.sendKeys(productName);
		saveBtn.click();
	}
	//Business Libraries for creating Product With Radio Button and Drop Down
	public void createNewProductWithMarketingDropdown(String productName,String dropDown) throws Throwable {
		productNameEdt.sendKeys(productName);
		Thread.sleep(2000);
		marketingGropRadioButton.click();
		Thread.sleep(2000);
		selectDropdown(marketingDropDown, dropDown);
		saveBtn.click();
	}	

}
