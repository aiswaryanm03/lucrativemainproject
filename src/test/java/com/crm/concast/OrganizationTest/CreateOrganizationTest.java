package com.crm.concast.OrganizationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.pomUtility.CreateOrganizationPage;
import com.crm.comcast.pomUtility.HomePage;
import com.crm.comcast.pomUtility.LoginPage;
import com.crm.comcast.pomUtility.OrganizationInfoPage;
import com.crm.comcast.pomUtility.OrganizationPage;

public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		WebDriver driver=null;
		String Browser=flib.getPropertyKeyValue("Browser");
		String url=flib.getPropertyKeyValue("url");
		String un=flib.getPropertyKeyValue("un");
		String pwd=flib.getPropertyKeyValue("pwd");
		String value=elib.GetDataFromExcel("book1", 4, 1);
		int num=jlib.CreateRandomNumber();
		
 	    if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox"))
				{
					driver=new FirefoxDriver();				}
		else
			driver=new ChromeDriver();
		wlib.ImplicitWait(driver);
		
		
		LoginPage lp=new LoginPage(driver);
		lp.LoginToVtiger(url, un, pwd);
		
		HomePage hp=new HomePage(driver);
		hp.getOrganization().click();		
		
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrganizationImg().click();
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.getOrganizationNameTxt().sendKeys(value+num);
		cop.getSaveBtn().click();
		String ActualText=value+num;
		System.out.println(ActualText);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String resultText=oip.getHeaderTxt().getText();
		System.out.println(resultText);
		if(resultText.contains(ActualText))
		{
			System.out.println("Contact Created successfully");
			hp.logout();
			
		}
		
		 else
			System.out.println("Not Successful");
		System.out.println("signedout successfully");
		driver.close();
		

	}

}
