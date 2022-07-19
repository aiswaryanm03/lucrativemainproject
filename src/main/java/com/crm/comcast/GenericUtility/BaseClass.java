package com.crm.comcast.GenericUtility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.comcast.pomUtility.HomePage;
import com.crm.comcast.pomUtility.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public FileUtility flib=new FileUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public ExcelUtility elib=new ExcelUtility();
	public  JavaUtility jlib=new JavaUtility();
	public static WebDriver sdriver;
	
	@BeforeSuite()
	public void configBS()
	{
		System.out.println("=====connect to database===");
	}
	
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable
	{
		System.out.println("===open browser===");
		String Browser=flib.getPropertyKeyValue("Browser");
		if(Browser.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
			driver=new ChromeDriver();
		
		sdriver=driver;
		wlib.ImplicitWait(driver);
		
		//driver.manage().window().maximize();
	}
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable
	{
		System.out.println("===login to application===");
		String url=flib.getPropertyKeyValue("url");
		String un=flib.getPropertyKeyValue("un");
		String pwd=flib.getPropertyKeyValue("pwd");
		//driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.LoginToVtiger(url,un, pwd);		
	}
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
		System.out.println("===logout of the application===");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		System.out.println("===close the browser===");
		driver.quit();
	}
	@AfterSuite(alwaysRun = true)
	public void configAS()
	{
		System.out.println("===close the database===");
	}
	
	
	

}
