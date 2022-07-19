package com.crm.comcast.ContactTest;

import java.awt.Desktop.Action;
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

import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.pomUtility.ContactInfoPage;
import com.crm.comcast.pomUtility.ContactPage;
import com.crm.comcast.pomUtility.CreateContactPage;
import com.crm.comcast.pomUtility.HomePage;
import com.crm.comcast.pomUtility.LoginPage;

public class CreateContactTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		String Browser=flib.getPropertyKeyValue("Browser");
		if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox"))
				{
					driver=new FirefoxDriver();				}
		else
			driver=new ChromeDriver();
		
		String url=flib.getPropertyKeyValue("url");
		String un=flib.getPropertyKeyValue("un");
		String pwd=flib.getPropertyKeyValue("pwd");
		String value=elib.GetDataFromExcel("book1", 3, 1);
		int num=jlib.CreateRandomNumber();
		wlib.ImplicitWait(driver);
		LoginPage lp=new LoginPage(driver);
		lp.LoginToVtiger( url,un, pwd);
		HomePage hp=new HomePage(driver);
		hp.getContacts().click();
		ContactPage cp=new ContactPage(driver);
		cp.getCreateContact().click();
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.getLastnameTxt().sendKeys(value+num);
		ccp.getSaveBtn().click();
		ContactInfoPage cip=new ContactInfoPage(driver);
		
		String ActualText=value;
		System.out.println(ActualText);
		String resultText=cip.getHeaderTxt().getText();
		//driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(resultText);
		if(resultText.contains(ActualText))
		{
			System.out.println("Contact Created successfully");
			System.out.println("signedout successfully");
			hp.logout();
			driver.close();
		}
		
		 else
			System.out.println("Not Successful");
		
		
		
	
	
		
		
		
		
	

	}

}
