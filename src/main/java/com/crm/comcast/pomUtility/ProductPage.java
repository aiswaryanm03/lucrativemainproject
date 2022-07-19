package com.crm.comcast.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	

	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement CreateProductImg;
	
	public WebElement getCreateProductImg() {
		return CreateProductImg;

}
}
