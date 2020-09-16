package com.topgear.qa.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.topgear.qa.base.BaseClass;
import com.topgear.qa.xpaths.DemoQASelectablePageXpath;

public class DemoQASelectablePage implements DemoQASelectablePageXpath
{
	private static Logger log = LogManager.getLogger(DemoQASelectablePage.class);
	public String hexbtnBackgroundColor;
	WebDriver driver = null;
	BaseClass baseClass = null;

	public DemoQASelectablePage(BaseClass baseClass) {
		this.driver = baseClass.driver;
		this.baseClass = baseClass;
	}

	public void selectablePageVerify() throws Exception
	{
		try {
			driver.get("https://demoqa.com/selectable/");
			String Selectable = baseClass.getVisibleElement(selectableText).getText();
			Assert.assertEquals(Selectable,"Selectable");
			baseClass.test.log(LogStatus.PASS, " Selectable page loaded" + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
			}	catch (Exception e) 
				{
				log.error("Selectable page not loaded");
					baseClass.test.log(LogStatus.FAIL,
							"Selectable page not loaded " + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
				throw e;
				}
		
	}
	
	public void selectItem() throws Exception
	{
		try {
			List<WebElement> selectableElements=baseClass.getAllElements(selectableItem);
			for(WebElement se:selectableElements)
			{
				se.click();
				System.out.println(se.getText());
			}
			
			String btn1backgroundColor= driver.findElement(selectableItem).getCssValue("background-color");
			System.out.println(btn1backgroundColor);
			hexbtnBackgroundColor=Color.fromString(btn1backgroundColor).asHex();
			System.out.println("background color:"+hexbtnBackgroundColor);
			baseClass.test.log(LogStatus.PASS, " Items are selected" + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
			}	catch (Exception e) 
				{	log.error("Items are not selected");
					baseClass.test.log(LogStatus.FAIL,
					"Items are not selected " + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
				throw e;
				}
	}
	
}
