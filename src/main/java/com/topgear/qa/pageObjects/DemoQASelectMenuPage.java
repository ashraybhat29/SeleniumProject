package com.topgear.qa.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.topgear.qa.base.BaseClass;
import com.topgear.qa.xpaths.DemoQASelectMenuPageXpath;

public class DemoQASelectMenuPage extends BaseClass implements DemoQASelectMenuPageXpath
{
	private static Logger log = LogManager.getLogger(DemoQASelectMenuPage.class);
	public String hexbtnBackgroundColor;
	WebDriver driver = null;
	BaseClass baseClass = null;

	public DemoQASelectMenuPage(BaseClass baseClass) 
	{
		this.driver = baseClass.driver;
		this.baseClass = baseClass;
	}

	public void selectablePageVerify() throws Exception
	{
		try {
			driver.get("https://demoqa.com/select-menu/");
			String selectMenu = baseClass.getVisibleElement(selectMenuText).getText();
			Assert.assertEquals(selectMenu,"Select Menu");
			screenshotPath = getScreenShot(driver, "select-menu Loaded");
			logger.pass("select-menu page loaded " + logger.addScreenCaptureFromPath(screenshotPath));
			//baseClass.test.log(LogStatus.PASS, " select-menu page loaded" + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
			}	catch (Exception e) 
				{
				log.error("Select-menu page not loaded ");
//					baseClass.test.log(LogStatus.FAIL,
//					"select-menu page not loaded " + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
				throw e;
				}
		
		
	}
	
	public void selectSelectValue(String visibleTest) throws Exception
	{
		try {	
			baseClass.selectByVisibleText(oldStyleSelectMenu,visibleTest);
			String actualString =  baseClass.getVisibleElement(oldStyleSelectMenu).getText();
			System.out.println("All colour:"+actualString);
			String expectedString = visibleTest;
			System.out.println("Color to be selected"+expectedString);
			Assert.assertTrue(actualString.contains(expectedString));
				
			List<WebElement> options = baseClass.getAllElements(standardMultiSelect);
			for(WebElement so:options)
			{
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).perform();
				so.click();
				String a=so.getCssValue("background-color");
				String b=Color.fromString(a).asHex();
				System.out.println("background color before:"+b);
				System.out.println("option"+so.getText());
			}
			List<WebElement> selection=  baseClass.getSelectOptions(afterselection);
			int expectedselect = 4;
			Assert.assertEquals(selection.size(),expectedselect);
			String btn1backgroundColor= driver.findElement(afterselection).getCssValue("background-color");
			System.out.println(btn1backgroundColor);
			hexbtnBackgroundColor=Color.fromString(btn1backgroundColor).asHex();
			logger.pass("Value selected from select-menu page ");
		//	baseClass.test.log(LogStatus.PASS, " Value selected from select-menu page" + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
			}	catch (Exception e) 
				{
				log.error("Value not selected from select-menu page ");
//					baseClass.test.log(LogStatus.FAIL,
//					"Value not selected from select-menu page" + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
					throw e;
				}
		
	}
}

	