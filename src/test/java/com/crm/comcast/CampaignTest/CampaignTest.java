package com.crm.comcast.CampaignTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.pomUtility.CampaignInfoPage;
import com.crm.comcast.pomUtility.CampaignPage;
import com.crm.comcast.pomUtility.CreateProductPage;
import com.crm.comcast.pomUtility.CreatecampaignPage;
import com.crm.comcast.pomUtility.HomePage;
import com.crm.comcast.pomUtility.ProductPage;
@Listeners(com.crm.comcast.GenericUtility.ListenersImplimentation.class)
public class CampaignTest extends BaseClass{
	@Test(groups = "Smoke")
	public void CreateCampaignTest() throws Throwable
	{
		String value=elib.GetDataFromExcel("book1", 5, 1);
		int num=jlib.CreateRandomNumber();

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
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(resulttxt.contains(value));
		sa.assertAll();
		System.out.println("campaign created successfully");
			
		}
	@Test(groups = "Regression")
	public void createcampaignaproductTest() throws Throwable
	{
		
		String value=elib.GetDataFromExcel("book1", 6, 1);
		String value1=elib.GetDataFromExcel("book1", 5, 2);
		int num=jlib.CreateRandomNumber();
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
		SoftAssert as=new SoftAssert();
		as.assertTrue(resulttxt.contains(expectedtxt) );
		as.assertAll();
		//Assert.assertEquals(resulttxt, expectedtxt);
//		if(resulttxt.contains(expectedtxt))
//		{
//			System.out.println("product with campaign created successfully");
//		}
//		else
//			System.out.println("couldnot create product with campaign sucessfully");
	}
	}


