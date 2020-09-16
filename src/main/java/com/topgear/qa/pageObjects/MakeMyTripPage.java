package com.topgear.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.topgear.qa.base.BaseClass;
import com.topgear.qa.xpaths.MakeMyTripPageXpath;

public class MakeMyTripPage implements MakeMyTripPageXpath {

	
	WebDriver driver 	= null;
	BaseClass baseClass = null;

	public MakeMyTripPage(BaseClass baseClass)
	{
		this.driver = baseClass.driver;
		this.baseClass = baseClass;
	}
	
	public void clickOnOneWay() throws Exception
	{
		try {
			baseClass.getVisibleElement(login).click();
			baseClass.getVisibleElement(makemytriplogo);
			baseClass.getVisibleElement(roundwayRadioButton).click();
	//		baseClass.test.log(LogStatus.PASS, " makemy trip" + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
		}	catch (Exception e) {
//			baseClass.test.log(LogStatus.FAIL,
//				"fail make my trip " + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
			throw e;
		}
		
	}
	
	public void selectFromCity(String fromCitySearch) throws Exception
	{
		try {
			baseClass.getVisibleElement(fromCity).click();
			baseClass.getVisibleElement(fromCityType).sendKeys(fromCitySearch);
			baseClass.waitForInvisibelity(selectCity);
			List<WebElement> listofoptions = driver.findElements(By.xpath("//ul[@role='listbox'][@class='react-autosuggest__suggestions-list']//li"));
			
			for(WebElement cn:listofoptions)
			{
				if(cn.getText().trim().equals(fromCitySearch))
				{
					Thread.sleep(1000);
					cn.click();
					System.out.println(cn);
					break;
				}
			}
			
			Thread.sleep(5000);
		//	baseClass.test.log(LogStatus.PASS, " From City selected" + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
		}	catch (Exception e) {
//			baseClass.test.log(LogStatus.FAIL,
//				"From City not selected " + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
			throw e;
		}
	}
	
	
	 public void selectFromAndTo(String fromCity,String toCity) throws Throwable {
	        try {
	            baseClass.getVisibleElement(from).click();
	            baseClass.getVisibleElement(By.xpath(String.format(cityName,fromCity))).click();
	            Thread.sleep(2000);
	            baseClass.getVisibleElement(to).click();
	            baseClass.getVisibleElement(By.xpath(String.format(cityName,toCity))).click();
	       //     baseClass.test.log(LogStatus.PASS, "Selected from and To city" + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
	        } catch (Exception e) {
	        //    baseClass.test.log(LogStatus.FAIL, "Failed to select from and to city " + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
	            throw e;
	        }
	    }
	 
	public void selectToCity(String toCitySearch) throws Exception
	{
		try {
			baseClass.getVisibleElement(fromCity).click();
			baseClass.getVisibleElement(fromCity).sendKeys(toCitySearch);
			List<WebElement> cityOptions=driver.findElements(selectCity);
			for(int i=0; i<cityOptions.size();i++)
			{
				WebElement ele = cityOptions.get(i);
				String cityName = ele.getText();
				if(cityName.equalsIgnoreCase(toCitySearch))
					{
						{
							ele.click();
							break;
						}
					}
			}
			
			Thread.sleep(5000);
	//		baseClass.test.log(LogStatus.PASS, " From City selected" + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
		}	catch (Exception e) {
//			baseClass.test.log(LogStatus.FAIL,
//				"From City not selected " + baseClass.test.addBase64ScreenShot(baseClass.getBase64Image()));
			throw e;
		}
	}
}
