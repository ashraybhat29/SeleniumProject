package com.topgear.qa.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.topgear.qa.base.BaseClass;
import com.topgear.qa.xpaths.DemoQADatePickerPageXpath;

public class DemoQADatePickerPage extends BaseClass implements DemoQADatePickerPageXpath 
{
	private static Logger log = LogManager.getLogger(DemoQADatePickerPage.class);
	WebDriver driver = null;
	BaseClass baseClass = null;
	public String dateandtime;
	public String ActualValue;

	public DemoQADatePickerPage(BaseClass baseClass)
	{
		this.driver = baseClass.driver;
		this.baseClass = baseClass;
	}

	public void datePickerPageVerify() throws Exception
	{
		try {
			driver.get("https://demoqa.com/date-picker/");
			String datePicker = baseClass.getVisibleElement(datePickerText).getText();
			Assert.assertEquals(datePicker,"Date Picker");
			screenshotPath = getScreenShot(driver, "datePicker Loaded");
			logger.pass("datePicker Loaded " + logger.addScreenCaptureFromPath(screenshotPath));
			//logger.pass("Date Picker Page page loaded Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
			//baseClass.logger.log(LogStatus.PASS, " Date Picker Page page loaded" + baseClass.logger.addBase64ScreenShot(baseClass.getBase64Image()));
			}	catch (Exception e) 
				{
				log.error("Date Picker page not loaded");
				//	baseClass.logger.log(LogStatus.FAIL,
						//	"Date Picker page not loaded" + baseClass.logger.addBase64ScreenShot(baseClass.getBase64Image()));
				throw e;
				}
		
	}
	
	public void selectDOB(String month,String date,String year,String dobtime) throws Exception
	{
		try {
			
			baseClass.getVisibleElement(selectDate).click();
			baseClass.selectByVisibleText(selectMonth,month);
			baseClass.selectByVisibleText(selectYear,year);
			
			baseClass.getVisibleElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--0"+date+"']")).click();
			String dob = baseClass.getVisibleElement(selectDate).getAttribute("value");
			System.out.println("date is"+dob);
			Assert.assertTrue(dob.contains("/"+date+"/"+year+""));
			
			//Select Time
			baseClass.getVisibleElement(dateAndTime).click();
			Thread.sleep(3000);
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();  
			actions.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).perform();
			
			baseClass.getVisibleElement(dateAndTime).sendKeys(dobtime);
			 ActualValue = baseClass.getVisibleElement(dateAndTime).getAttribute("value");
			System.out.println("actauslsdad"+ActualValue);
			//logger.pass("Date of Birth selected Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
			//baseClass.test.log(LogStatus.PASS, " Date of Birth selected" + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
			}	catch (Exception e) 
				{
				log.error("Date of Birth not selected ");
//					baseClass.test.log(LogStatus.FAIL,
//							"Date of Birth not selected " + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
				throw e;
				}
	}
}
