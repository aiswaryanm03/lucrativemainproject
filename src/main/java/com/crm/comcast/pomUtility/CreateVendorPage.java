package com.crm.comcast.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorPage {
	public CreateVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="vendorname")
	private WebElement VendornameTxt;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;

	public WebElement getVendornameTxt() {
		return VendornameTxt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

}
