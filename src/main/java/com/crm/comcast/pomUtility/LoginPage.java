package com.crm.comcast.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement userName;
	
	@FindBy(name="user_password")
	private WebElement PassWord;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassword() {
		return PassWord;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public void LoginToVtiger(String url,String username,String Password) 
	{
		driver.get(url);
		userName.sendKeys(username);
		PassWord.sendKeys(Password);
		 loginBtn.click();
		
	
		
	}

}
