package com.crm.autodesk.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{//Step1 ==>> create separate POM class
	
    //Step2 ==>> Identify all the elements in the page using @FindBy and Declare as private
	@FindBy(name="lastname")
	private WebElement contactLastnameEdt;
	
    //@FindAll({@FindBy(name="account_name"),@FindBy(xpath="//input[@name='account_name']/following-sibling::img")})
    @FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgLookUpImg;
    
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
    
    @FindBy(xpath="//input[@title='Cancel [Alt+X]']")
    private WebElement contactCancelBtn;
    
    @FindBy(name="search_text")
    private WebElement searchTextEdt;
    
    @FindBy(xpath="//input[@name='search']")
    private WebElement searchBtn;
    
    @FindBy(xpath="//tr[@class='lvtColData']//a[1]")
    private WebElement orgNameLink;
    
    //Step3 ==>>Provide the Initialization through constructor	
    public CreateNewContactPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
	 }

    //Step4 ==>>Utilize the WebElement using getters
	public WebElement getContactLastname() {
		return contactLastnameEdt;
	}

	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
    
	public WebElement getContactCancelBtn() {
		return contactCancelBtn;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	//Step5 ==>> Developing the Business Libraries
	public void createNewContactsWithOrgName(String contactLastName,String orgName,WebDriver driver) {
		contactLastnameEdt.sendKeys(contactLastName);
		orgLookUpImg.click();		
		switchToWindow(driver, "Accounts");
		searchTextEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.linkText(orgName)).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}

	public void createNewContacts(String contactName) {
		contactLastnameEdt.sendKeys(contactName);
		saveBtn.click();
	}	
}
