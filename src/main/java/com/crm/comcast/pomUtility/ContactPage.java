package com.crm.comcast.pomUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	/**
	 * this class consisits of webelements of contactpage
	 * @param driver
	 */
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//img[@alt='Create Contact...']")
	private WebElement CreateContact;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement SearchTxt;
	
	@FindBy(xpath="(//select[@name='search_field'])[1]")
	private WebElement SearchList;
	
	@FindBy(xpath="(//input[@value=' Search Now '] )[1]")
	private WebElement SearchBtn;
	
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement ContactNotFoundMsg;

	public WebElement getSearchTxt() {
		return SearchTxt;
	}

	public WebElement getSearchList() {
		return SearchList;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getContactNotFoundMsg() {
		return ContactNotFoundMsg;
	}

	public WebElement getCreateContact() {
		return CreateContact;
	}
	
	
	

}
