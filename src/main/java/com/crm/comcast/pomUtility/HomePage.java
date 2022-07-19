package com.crm.comcast.pomUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;

public class HomePage 
{
	WebDriverUtility wlib=new WebDriverUtility();
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(linkText="More")
	private WebElement MoreOpt;
	
	@FindBy(linkText="Campaigns")
	private WebElement Campaigns;
	
	@FindBy(linkText="Products")
	private WebElement Products;
	
	@FindBy(linkText="Contacts")
	private WebElement Contacts;
	
	@FindBy(linkText="Organizations")
	private WebElement Organization;
	
	@FindBy(name="Purchase Order")
	private WebElement PurchaseOrder;
	

	@FindBy(xpath="(//img[@style='padding: 0px;padding-left:5px'])[1]")
	private WebElement AdminstratorImage;
	
	public WebElement getVendors() 
	{
		return Vendors;
	}
	
	@FindBy(linkText="Sign Out")
	private WebElement Signout;
	
	@FindBy(name="Vendors")
	private WebElement Vendors;
	
	public WebDriverUtility getWlib() {
		return wlib;
	}

	
	
	
	
	public WebElement getMoreOpt() {
		return MoreOpt;
	}

	public WebElement getCampaigns() {
		return Campaigns;
	}

	public WebElement getProducts() {
		return Products;
	}

	public WebElement getContacts() {
		return Contacts;
	}

	public WebElement getOrganization() {
		return Organization;
	}

	public WebElement getPurchaseOrder() {
		return PurchaseOrder;
	}

	
	public WebElement getAdminstratorImage() {
		return AdminstratorImage;
	}

	public WebElement getSignout() {
		return Signout;
	}
	public void logout()
	{
		wlib.MouseOverOnElement(driver, AdminstratorImage);
		Signout.click();
		
	
	}

	
	
	
	

}
