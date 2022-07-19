package com.crm.comcast.pomUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;

public class CreatecampaignPage extends WebDriverUtility {
	public CreatecampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="campaignname")
	private WebElement CampaignNameTxt;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement LookupImg;
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement ChildWindowTxt;
	
	@FindBy(name="search")
	private WebElement ChildWindowSearch;
	
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private WebElement ChildWindowProduct;
	
	
	

	public WebElement getLookupImg() {
		return LookupImg;
	}

	public WebElement getChildWindowTxt() {
		return ChildWindowTxt;
	}

	public WebElement getChildWindowSearch() {
		return ChildWindowSearch;
	}

	public WebElement getChildWindowProduct() {
		return ChildWindowProduct;
	}

	public WebElement getCampaignNameTxt() {
		return CampaignNameTxt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	 public void CreateCampaign(String text)
	 {
		 CampaignNameTxt.sendKeys(text);
		 SaveBtn.click();
		 
	 }
	 public void  SwitchFromCampaignToProduct(WebDriver driver,String text)
	 {
		 Windowhandling(driver, text);
	 }

}
