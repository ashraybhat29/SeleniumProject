package com.topgear.qa.pageObjects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.topgear.qa.base.BaseClass;
import com.topgear.qa.xpaths.DemoQADroppablePageXpath;



public class DemoQADroppablePage extends BaseClass implements DemoQADroppablePageXpath 
{

	private static Logger log = LogManager.getLogger(DemoQADroppablePage.class);
	
	WebDriver driver = null;
	BaseClass baseClass = null;
	public String droppedMessage;

	public DemoQADroppablePage(BaseClass baseClass) 
	{
		this.driver = baseClass.driver;
		this.baseClass = baseClass;
	}

	public void droppablePageVerify() throws Exception
	{
		try {
			driver.get("https://demoqa.com/droppable/");
			String droppable = baseClass.getVisibleElement(droppableText).getText();
			Assert.assertEquals("Droppable",droppable);
			screenshotPath = getScreenShot(driver, "Droppable Loaded");
			logger.pass("Droppable Loaded " + logger.addScreenCaptureFromPath(screenshotPath));
		//	baseClass.test.log(LogStatus.PASS, " Droppable page loaded" + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
			}	catch (Exception e) 
				{
				log.error("Droppable page not loaded");
//				baseClass.test.log(LogStatus.FAIL,
//					"Droppable page not loaded " + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
			throw e;
				}
		
	}
	
	public void dragAndDrop() throws Throwable 
	{
		try {
			Actions actions = new Actions(driver);
			actions.dragAndDrop(baseClass.getVisibleElement(dragMe), baseClass.getVisibleElement(dropHere)).perform();
			droppedMessage = baseClass.getVisibleElement(droppedMsg).getText();
			
			logger.pass("Drag and Drop successfull " + logger.addScreenCaptureFromPath(screenshotPath));
			} 	catch (Exception e) 
				{
				log.error("Failed to drag element");
//					baseClass.test.log(LogStatus.FAIL,
//							"Failed to drag element " + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
				throw e;
				}
	}  
	
	
	
	public Point beforeDrag()
	{
		WebElement Drag= baseClass.getVisibleElement(dragMe);
		Point beforedrag=Drag.getLocation();
		
		System.out.println(beforedrag);
		return beforedrag;
	}
	
	public Point afterDrag()
	{
		WebElement Drag=baseClass.getVisibleElement(dragMe);
		Point afterDrag=Drag.getLocation();
		System.out.println(afterDrag);
		return afterDrag;
	}
	
}
