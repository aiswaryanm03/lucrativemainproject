package com.crm.concast.OrganizationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.pomUtility.CreateOrganizationPage;
import com.crm.comcast.pomUtility.HomePage;
import com.crm.comcast.pomUtility.OrganizationInfoPage;
import com.crm.comcast.pomUtility.OrganizationPage;

public class OrganizationTest extends BaseClass {
	@Test
	public void createOrganizationTest() throws Throwable
	{
		String value=elib.GetDataFromExcel("book1", 4, 1);
		int num=jlib.CreateRandomNumber();
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
		Assert.assertTrue(resultText.contains(ActualText));
//		if(resultText.contains(ActualText))
//		{
//			System.out.println("Contact Created successfully");
//			
//		}
//		
//		 else
//			System.out.println("Not Successful");
//		
	}

}
