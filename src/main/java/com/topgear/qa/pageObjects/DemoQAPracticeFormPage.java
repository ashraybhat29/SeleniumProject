package com.topgear.qa.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.topgear.qa.base.BaseClass;
import com.topgear.qa.xpaths.DemoQAPracticeFormPageXpath;

public class DemoQAPracticeFormPage extends BaseClass implements DemoQAPracticeFormPageXpath 
{
	private static Logger log = LogManager.getLogger(DemoQAPracticeFormPage.class);
	public String ExpectedMsg;
	WebDriver driver = null;
	BaseClass baseClass = null;

	public DemoQAPracticeFormPage(BaseClass baseClass) 
	{
		this.driver = baseClass.driver;
		this.baseClass = baseClass;
	}

	public void practiceFormPageVerify() throws Exception
	{
		try {
			driver.get("http://demoqa.com/automation-practice-form");
			String practiceFormName = baseClass.getVisibleElement(formname).getText();
			Assert.assertEquals("Practice Form",practiceFormName);
			screenshotPath = getScreenShot(driver, "practiceFormPage Loaded");
			//baseClass.test.log(LogStatus.PASS, " Practice Form page loaded" + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
			}	catch (Exception e) 
				{
				log.error("Practice Form page not loaded");
//				baseClass.test.log(LogStatus.FAIL,
//					"Practice Form page not loaded " + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
			throw e;
		}
		
	}
	public void fillForm(String fname,String lname, String emailid,String gender, String mobilenumber,
			String month,String date,String year, String sub,String hobbies,String address) throws Throwable 
	{
		try {
			baseClass.getVisibleElement(firstName).sendKeys(fname);
			baseClass.getVisibleElement(lastName).sendKeys(lname);
			baseClass.getVisibleElement(email).sendKeys(emailid);
			
			if(gender.equalsIgnoreCase("Male"))
			{
				baseClass.getVisibleElement(genderMale).click();
			}
			else if(gender.equalsIgnoreCase("Female"))
			{
				baseClass.getVisibleElement(genderFemale).click();
			}
			else
			{
				baseClass.getVisibleElement(genderOther).click();
			}
			baseClass.getVisibleElement(mobile).sendKeys(mobilenumber);
			baseClass.getVisibleElement(dateOfBirth).click();
			baseClass.selectByVisibleText(selectMonth,month);
			baseClass.selectByVisibleText(selectYear,year);
			baseClass.getVisibleElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--0"+date+"']")).click();
//			Thread.sleep(2000);
//			baseClass.getVisibleElement(subjects).click();
//			Thread.sleep(2000);
//			baseClass.getVisibleElement(subjects).sendKeys("Ashray");
//			Thread.sleep(2000);
			
			if(hobbies.equalsIgnoreCase("Sports"))
			{
				baseClass.getVisibleElement(hobbiesSports).click();
			}
			else if(hobbies.equalsIgnoreCase("Reading"))
			{
				baseClass.getVisibleElement(hobbiesReading).click();
			}
			else
			{
				baseClass.getVisibleElement(hobbiesMusic).click();
			}
			
			
			baseClass.getVisibleElement(currentAddress).sendKeys(address);
			baseClass.getVisibleElement(submit).click();
			ExpectedMsg = baseClass.getVisibleElement(thanksmsg).getText();
			
			//baseClass.test.log(LogStatus.PASS, " Practice Form Filled successfully" + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
			//baseClass.getVisibleElement(close).click();
			
			} 	catch (Exception e)
				{
				log.error("Failed filling the form");
//					baseClass.test.log(LogStatus.FAIL,
//					"Failed filling the form " + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
				throw e;
				}
	}

}
