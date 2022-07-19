package com.crm.comcast.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;

public class CreatePurchasePage extends WebDriverUtility {
	WebDriver driver;
	public CreatePurchasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="subject")
	private WebElement SubjectTxt;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement LookupImg;
	
	@FindBy(xpath="(//a[@href='javascript:window.close();'])[last()]")
	private WebElement VendorFromTable;
	
	@FindBy(name="vendor_name")
	private WebElement Vendorname;
	
	
	
	public WebElement getVendorname() {
		return Vendorname;
	}
	public WebElement getVendorFromTable() {
		return VendorFromTable;
	}
	public WebElement getSubjectTxt() {
		return SubjectTxt;
	}
	public WebElement getLookupImg() {
		return LookupImg;
	}
	public void WindowFromPurchaseToVendor(WebDriver driver, String Text)
	{
		Windowhandling(driver,Text);
	}
	public void WindowFromVendorToPurchase(WebDriver driver, String Text)
	{
		Windowhandling(driver,Text);
	}

}
