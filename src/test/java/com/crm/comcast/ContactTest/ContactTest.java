package com.crm.comcast.ContactTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.pomUtility.ContactInfoPage;
import com.crm.comcast.pomUtility.ContactPage;
import com.crm.comcast.pomUtility.CreateContactPage;
import com.crm.comcast.pomUtility.HomePage;
@Listeners(com.crm.comcast.GenericUtility.ListenersImplimentation.class)
public class ContactTest extends BaseClass {
	@Test(groups = "Smoke")
	public void CreateContactTest() throws Throwable
	{
		
		String value=elib.GetDataFromExcel("book1", 3, 1);
		int num=jlib.CreateRandomNumber();
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
		System.out.println(resultText);
		Assert.assertTrue(resultText.contains(ActualText));
		//Assert.assertEquals(resultText, ActualText);
//		if(resultText.contains(ActualText))
//		{
//			System.out.println("Contact Created successfully");
//		}
//		
//		 else
//			System.out.println("Not Successful");
	}
	@Test(groups = "Regression")
	public void CreateAndDeleteContacttest() throws Throwable
	{
		String value=elib.GetDataFromExcel("book1", 3, 3);
		int num=jlib.CreateRandomNumber();
		HomePage hp=new HomePage(driver);
		hp.getContacts().click();
		ContactPage cp=new ContactPage(driver);
		cp.getCreateContact().click();
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.getLastnameTxt().sendKeys(value+num);
		ccp.getSaveBtn().click();
		ContactInfoPage cip=new ContactInfoPage(driver);
		cip.getDeleteBtn().click();
		wlib.SwithToAlertAndAccept(driver);
		cp.getSearchTxt().sendKeys(value);
		
		wlib.SelectByValue(cp.getSearchList(), "lastname");
		cp.getSearchBtn().click();
		String msg=cp.getContactNotFoundMsg().getText();
		String actlmsg="No Contact Found !";
		Assert.assertTrue(msg.contains(actlmsg));
//		if(msg.contains(actlmsg))
//		{
//			System.out.println("Contact Deleted successfully");
//			
//		}
//		
//		 else
//			System.out.println("Not Successful");
	}
	
	

}
