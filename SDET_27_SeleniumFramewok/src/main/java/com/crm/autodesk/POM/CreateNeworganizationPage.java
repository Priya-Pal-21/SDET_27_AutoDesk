package com.crm.autodesk.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateNeworganizationPage extends WebDriverUtility
{      //Step1 ==>> create separate POM class
	
	   //Step2 ==>> Identify all the elements in the page using @FindBy and Declare as private
       @FindBy(name="accountname")
       private WebElement organizationName;
       @FindBy(xpath="//input[@title='Save [Alt+S]']")
       private WebElement saveBtn;
       @FindBy(name="industry")
       private WebElement industryDropDown;
       @FindBy(name="accounttype")
       private WebElement typeDropDown;
       
       //Initialization
       public CreateNeworganizationPage(WebDriver driver){
      		PageFactory.initElements(driver, this);
      	   }
   
       //Utilization
	   public WebElement getOrgName() {
		 return organizationName;
     	}
	   public WebElement getSaveBtn() {
		 return saveBtn;
	    }
	   public WebElement getIndustryDropDown() {
			return industryDropDown;
		} 
	   public WebElement getTypeDropDown() {
		    return typeDropDown;
    	}

	//Business library
       public void organizationDetails(String orgName) {
    	   organizationName.sendKeys(orgName);
    	   saveBtn.click();
       }
       public void organizationDetailsWithIndustryAndType(String orgName, String industryType,String type) {
    	   organizationName.sendKeys(orgName);
    	   selectDropdown(industryDropDown,industryType);
    	   selectDropdown(typeDropDown, type);
    	   saveBtn.click();
       }
		
	}
