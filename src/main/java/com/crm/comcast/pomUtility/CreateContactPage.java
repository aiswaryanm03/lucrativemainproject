package com.crm.comcast.pomUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="lastname")
	private WebElement lastnameTxt;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveBtn;

	public WebElement getLastnameTxt() {
		return lastnameTxt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void CreateContactWithMandatory(String text)
	{
		 lastnameTxt.sendKeys(text);
		 saveBtn.click();	
	}
	

}
