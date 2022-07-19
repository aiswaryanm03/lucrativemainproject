package com.crm.comcast.pomUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement SuccessfulMsg;
	
	@FindBy(name="Delete")
	private WebElement DeleteBtn;

	public WebElement getDeleteBtn() {
		return DeleteBtn;
	}

	public WebElement getHeaderTxt() {
		return SuccessfulMsg;
		
		
	}

}
