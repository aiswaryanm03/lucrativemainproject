package com.crm.comcast.pomUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	public CreateOrganizationPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement OrganizationNameTxt;
	
	@FindBy(xpath="(//input[@value='  Save  '])[1]")
	private WebElement SaveBtn;

	public WebElement getOrganizationNameTxt() {
		return OrganizationNameTxt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	

}
