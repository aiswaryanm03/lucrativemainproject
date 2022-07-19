package com.crm.comcast.CampaignTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.pomUtility.CampaignInfoPage;
import com.crm.comcast.pomUtility.CampaignPage;
import com.crm.comcast.pomUtility.CreateProductPage;
import com.crm.comcast.pomUtility.CreatecampaignPage;
import com.crm.comcast.pomUtility.HomePage;
import com.crm.comcast.pomUtility.LoginPage;
import com.crm.comcast.pomUtility.ProductPage;

public class CreateCampaignTest   {
	public static void main(String args []) throws Throwable
	{
	
	 WebDriver driver=null;
	 FileUtility flib=new FileUtility();
	 WebDriverUtility wlib=new WebDriverUtility();
	 ExcelUtility elib=new ExcelUtility();
	 JavaUtility jlib=new JavaUtility();
	String Browser=flib.getPropertyKeyValue("Browser");
	String url=flib.getPropertyKeyValue("url");
	String un=flib.getPropertyKeyValue("un");
	String pwd=flib.getPropertyKeyValue("pwd");
	String value=elib.GetDataFromExcel("book1", 5, 1);
	int num=jlib.CreateRandomNumber();
	if(Browser.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(Browser.equals("firefox"))
			{
				driver=new FirefoxDriver();
			}
	else
		driver=new ChromeDriver();
	wlib.ImplicitWait(driver);

	LoginPage lp=new LoginPage(driver);
	lp.LoginToVtiger(url, un, pwd);
	
	HomePage hp=new HomePage(driver);
	hp.getMoreOpt().click();
	hp.getCampaigns().click();
	CampaignPage cp=new CampaignPage(driver);
	cp.getCreateCampaignimg().click();
	CreatecampaignPage ccp=new CreatecampaignPage(driver);
	ccp.getCampaignNameTxt().sendKeys(value+num);
	ccp.getSaveBtn().click();
	CampaignInfoPage cip=new CampaignInfoPage(driver);
	String resulttxt=cip.getHeaderTxt().getText();
	if(resulttxt.contains(value+num))
	{
		System.out.println("campaign created successfully");
		hp.logout();
		driver.close();
	}
	
	 else
		System.out.println("Not Successful");
	
		
	}
	 
	

	

	}
		
		
		
		

	


