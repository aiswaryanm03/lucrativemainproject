package com.crm.comcast.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplimentation implements ITestListener {
	//public WebDriver driver;
	public void onTestStart(ITestResult result) {
		System.out.println("testscript strated");
		
	}

	
	public void onTestFailure(ITestResult result) {
		String Testname=result.getMethod().getMethodName();
		String date=new Date().toString().replaceAll(":", "-");
		//TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		EventFiringWebDriver efw=new EventFiringWebDriver(BaseClass.sdriver);
		File Src=efw.getScreenshotAs(OutputType.FILE);
		
		//LocalDateTime ldt=LocalDateTime.now();
		File Dest=new File("./ScreenShot/"+Testname+date+"ss.png");
		try {
			FileUtils.copyFile(Src, Dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	

}
