package com.crm.comcast.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * WebDriverUtility class contains WebDriver reusable 
 * @author Aishwarya
 *
 */

public class WebDriverUtility {
	/**
	 * implicit wait will wait for element in DOM document until all the element is completely available after which it 
	 * will release control
	 * @param driver
	 */
	public void ImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(IConstants.IMPLICITLY_TIMEOUT, TimeUnit.SECONDS);
	}
	/**
	 * Explicitly wait will wait  till page is fully loaded and available in the GUI
	 * @param driver
	 * @param element
	 */
	public void ExplicitWait(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,IConstants.EXPLICITLY_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * used to switch from one window to another window 
	 * @param driver
	 * @param MainWindowTitle
	 */
	public void Windowhandling(WebDriver driver,String PartialWindowTitle)
	{
		Set<String> set=driver.getWindowHandles();
		Iterator<String> iterator=set.iterator();
		while(iterator.hasNext())
		{
			String ChildWID=iterator.next();
			driver.switchTo().window(ChildWID);
			String ChildWindowTitle=driver.getTitle();
			if(ChildWindowTitle.contains(PartialWindowTitle))
			{
				continue;
			}
		}
	}
	/**
	 * used to switch window rom child to parent
	 * @param driver
	 * @param ChildWindowtitle
	 */
//	public void WindowFromChildToParent(WebDriver driver,String ChildWindowtitle)
//	{
//		Set<String> set=driver.getWindowHandles();
//		Iterator<String> iterator=set.iterator();
//		while(iterator.hasNext())
//		{
//			String MainWID=iterator.next();
//			driver.switchTo().window(MainWID);
//			String MainWindowTitle=driver.getTitle();
//			if(MainWindowTitle.contains(ChildWindowtitle))
//			{
//				break;
//			}
//		}
//		
//	}
	/**
	 * used to handle alertpopup and click on accept
	 * @param driver
	 * @param ExpectedMsg
	 */
	public void SwithToAlertAndAccept(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	/**
	 * used to handle alertpopup and click on cancel
	 * @param driver
	 * @param ExpectedMsg
	 */
	
	public void SwithToAlertAndDismiss(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
	}
	/**
	 * used to select element from listbox and dropdown using index
	 * @param index
	 * @param element
	 */
	public void SelectByIndex(WebElement element, int index)
	{
		Select select=new Select(element);
				select.selectByIndex(index);
				
	}
	/**
	 * used to select element from listbox and dropdown using visibility of text
	 * @param index
	 * @param element
	 */
	public void SelectByVisibleText(WebElement element, String text)
	{
		Select select=new Select(element);
				select.selectByVisibleText(text);
				
	}
	/**
	 * used to select element from listbox and dropdown using String value
	 * @param index
	 * @param element
	 */
	public void SelectByValue(WebElement element, String value)
	{
		Select select=new Select(element);
				select.selectByValue(value);
				
	}
	/**
	 * used to move to perticular element using mouse over action
	 * @param driver
	 * @param element
	 */
	public void MouseOverOnElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * used to right click on element
	 * @param driver
	 * @param element
	 */
	public void RightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void SwitchToFrameIndex(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public void SwitchToFrameValue(WebDriver driver, String value)
	{
		driver.switchTo().frame(value);
	}
	public void SwitchToFrameElement(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void SwitchToFrameDefault(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	public void SwitchToFrameParent(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	public void TakeScreenShot(WebDriver driver) throws Throwable
	{
		//EventFiringWebDriver efw=new EventFiringWebDriver(driver);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./Screenshot/ss.png");
		FileUtils.copyFile(src, dst);
			
		
	}
	public void ScrollDown(WebDriver driver, int x,int y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollby(0,1000)");
		
		
	}
	

	
	
	
	
	

}
