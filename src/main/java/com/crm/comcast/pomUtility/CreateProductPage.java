package com.crm.comcast.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CreateProductPage {
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="productname")
	private WebElement ProductnameTxt;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;

	public WebElement getProductnameTxt() {
		return ProductnameTxt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	

}
