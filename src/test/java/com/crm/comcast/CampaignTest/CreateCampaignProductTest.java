package com.crm.comcast.CampaignTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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
import com.crm.comcast.pomUtility.CampaignInfoPage;
import com.crm.comcast.pomUtility.CampaignPage;
import com.crm.comcast.pomUtility.CreateProductPage;
import com.crm.comcast.pomUtility.CreatecampaignPage;
import com.crm.comcast.pomUtility.HomePage;
import com.crm.comcast.pomUtility.LoginPage;
import com.crm.comcast.pomUtility.ProductPage;

public class CreateCampaignProductTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		String Browser=flib.getPropertyKeyValue("Browser");
		String url=flib.getPropertyKeyValue("url");
		String un=flib.getPropertyKeyValue("un");
		String pwd=flib.getPropertyKeyValue("pwd");
		String value=elib.GetDataFromExcel("book1", 6, 1);
		String value1=elib.GetDataFromExcel("book1", 5, 2);
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
		lp.LoginToVtiger( url,un, pwd);
		
		HomePage hp=new HomePage(driver);
		hp.getProducts().click();
		ProductPage pp=new ProductPage(driver);
		pp.getCreateProductImg().click();
		CreateProductPage cpp=new CreateProductPage(driver);
		cpp.getProductnameTxt().sendKeys(value+num);
		cpp.getSaveBtn().click();
		hp.getMoreOpt().click();
		hp.getCampaigns().click();
		CampaignPage cp=new CampaignPage(driver);
		cp.getCreateCampaignimg().click();
		CreatecampaignPage ccp=new CreatecampaignPage(driver);
		ccp.getCampaignNameTxt().sendKeys(value1+num);
		String MainWindowTitle=driver.getTitle();
		ccp.getLookupImg().click();	
		ccp.SwitchFromCampaignToProduct(driver, MainWindowTitle);
		ccp.getChildWindowTxt().sendKeys(value+num);
		ccp.getChildWindowSearch().click();
		String CWid1=driver.getTitle();
		ccp.getChildWindowProduct().click();
		wlib.Windowhandling(driver, CWid1);
		ccp.getSaveBtn().click();
		CampaignInfoPage cip=new CampaignInfoPage(driver);
		String resulttxt=cip.getHeaderTxt().getText();
		String expectedtxt=value1+num;
		if(resulttxt.contains(expectedtxt))
		{
			System.out.println("product with campaign created successfully");
		}
		else
			System.out.println("couldnot create product with campaign sucessfully");
		hp.logout();
		driver.close();
	}

}
