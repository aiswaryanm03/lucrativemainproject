package com.crm.comcast.pomUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement CreateCampaignImg;

	public WebElement getCreateCampaignimg() {
		return CreateCampaignImg;
	}
	

}
