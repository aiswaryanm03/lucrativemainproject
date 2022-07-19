package com.crm.comcast.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {
	public PurchasePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Purchase Order...']")
	private WebElement CreatePurchaseImage;
	
	public WebElement getCreatePurchaseImage() {
		return CreatePurchaseImage;
	}

}
