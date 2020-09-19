package com.topgear.qa.pageObjects;


import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;


import com.topgear.qa.base.BaseClass;
import com.topgear.qa.xpaths.MakeMyTripPageXpath;



public class MakeMyTripPage  extends BaseClass   implements MakeMyTripPageXpath 
{
	private static Logger log = LogManager.getLogger(MakeMyTripPage.class);

	String depPrice = null;
    String retPrice = null;
    public String reviewMsg = null;
	WebDriver driver 	= null;
	BaseClass baseClass = null;
	

	public MakeMyTripPage(BaseClass baseClass)
	{
		this.driver = baseClass.driver;
		this.baseClass = baseClass;
	}
	
	
	public  void switchToFrame1(WebDriver driver) throws Exception
	{
		try
		{
			WebElement myFrame= baseClass.getVisibleElement(iframe);
			driver.switchTo().frame(myFrame);
			baseClass.getVisibleElement(iframeClose).click();
			driver.switchTo().defaultContent();
			screenshotPath = getScreenShot(driver, "Iframe Closed");
			logger.pass("Iframe is closed " + logger.addScreenCaptureFromPath(screenshotPath));
		} 	catch (Exception e)
			{
			logger.fail("Iframe is not closed " + logger.addScreenCaptureFromPath(screenshotPath));
			throw e;
			}
	}
	
	public void clickOnRoundWay() throws Exception
	{
		try {
	
			baseClass.getVisibleElement(login).click();
			baseClass.getVisibleElement(makemytriplogo);
			baseClass.getVisibleElement(roundwayRadioButton).click();
			screenshotPath = getScreenShot(driver, "Trip selected");
			logger.pass("RoundTrip is selected " + logger.addScreenCaptureFromPath(screenshotPath));
		}	catch (Exception e) {
			logger.pass("RoundTrip is not selected " + logger.addScreenCaptureFromPath(screenshotPath));
			throw e;
		}
		
	}
	
	
	 public void selectFromAndTo(String fromCityVal,String toCityVal) throws Throwable {
	        try {
	            baseClass.getVisibleElement(fromCity).click();
	            baseClass.getVisibleElement(By.xpath(String.format(cityName,fromCityVal))).click();
	        
	            baseClass.getVisibleElement(toCity).click();
	            baseClass.getVisibleElement(By.xpath(String.format(cityName,toCityVal))).click();
	            screenshotPath = getScreenShot(driver, "city selected");
	            logger.pass("From and To city is selected" + logger.addScreenCaptureFromPath(screenshotPath));
	        } catch (Exception e) {
	        	logger.pass("From and To city is not selected" + logger.addScreenCaptureFromPath(screenshotPath));
	            throw e;
	        }
	    }
	 
	public void selectDepartureDate(String depDate) throws Exception
	{
		try {
			baseClass.getVisibleElement(departureDate).click();
		
			String flag = "false";

			while (flag == "false") {
				if ( baseClass.getAllElements(By.xpath(String.format(selectDateFromCal,depDate))).size() > 0)
				{
					baseClass.getVisibleElement(By.xpath(String.format(selectDateFromCal,depDate))).click();
					flag = "true";
				} else {
					baseClass.getVisibleElement(nextButton).click();
				
				}
			}
			 screenshotPath = getScreenShot(driver, "Departure Date");
			logger.pass("Departure Date is selected" + logger.addScreenCaptureFromPath(screenshotPath));
		}	catch (Exception e) {
			logger.pass("Departure Date is not selected" + logger.addScreenCaptureFromPath(screenshotPath));
			throw e;
		}
	}
	public void selectReturnDate(String returnDate) throws Exception
	{
		try {
			baseClass.getVisibleElement(returnDateCal).click();
	
			String flag = "false";

			while (flag == "false") {
				if ( baseClass.getAllElements(By.xpath(String.format(selectDateFromCal,returnDate))).size() > 0)
				{
					baseClass.getVisibleElement(By.xpath(String.format(selectDateFromCal,returnDate))).click();
					flag = "true";
				} else {
					baseClass.getVisibleElement(nextButton).click();
					
				}
			}
			 screenshotPath = getScreenShot(driver, "Return Date");
			logger.pass("Return Date is selected" + logger.addScreenCaptureFromPath(screenshotPath));
		}	catch (Exception e) {
			logger.pass("Return Date is not selected" + logger.addScreenCaptureFromPath(screenshotPath));
			throw e;
		}
	}
	
	public void clickSearch() throws Exception
	{
		try {
			baseClass.getVisibleElement(searchButton).click();
			screenshotPath = getScreenShot(driver, "Search button");
			logger.pass("Search Button is Clicked" + logger.addScreenCaptureFromPath(screenshotPath));
		}	catch (Exception e) {
			logger.pass("Search Button is not Clicked" + logger.addScreenCaptureFromPath(screenshotPath));
			throw e;
		}
	}
	
	public void selectLowPrice() throws Exception
	{
		try {
			
			baseClass.getVisibleElement(departureSortButton).click();
			System.out.println("1");
		
			baseClass.getVisibleElement(sortLowToHighDD).click();
			System.out.println("2");
		
			baseClass.getVisibleElement(departurePrice).click();
			System.out.println("3");
			baseClass.getVisibleElement(returnPrice).click();
			System.out.println("4");
			depPrice =baseClass.getVisibleElement(departurePrice).getText();
			retPrice =baseClass.getVisibleElement(returnPrice).getText();
			System.out.println("price dep"+depPrice);
			System.out.println("price ret"+retPrice);
		    Thread.sleep(2000);
		    baseClass.getVisibleElement(bookButton).click();
			
		    String parent =driver.getWindowHandle();
		    System.out.println("parent window"+parent);
		    baseClass.getVisibleElement(continueButton).click();
		    Thread.sleep(2000);
		    
		   Set<String> allwind =driver.getWindowHandles();
		   int count =allwind.size();
		   System.out.println("wondow count"+count);
		   
		   for(String child:allwind)
		   {
			   if(!parent.equalsIgnoreCase(child))
			   {
				   driver.switchTo().window(child);
			   }
		   }
			screenshotPath = getScreenShot(driver, "Continue button");
			logger.pass("Continue Button is Clicked" + logger.addScreenCaptureFromPath(screenshotPath));
		}	catch (Exception e) {
			logger.pass("Continue Button is not Clicked" + logger.addScreenCaptureFromPath(screenshotPath));
			throw e;
		}
	}
	
	public void reviewPage() throws Exception
	{
		try {
				reviewMsg  = baseClass.getVisibleElement(reviewLabel).getText();
			
		    
		    screenshotPath = getScreenShot(driver, "Review");
			logger.pass("Review Page Verified" + logger.addScreenCaptureFromPath(screenshotPath));
		}	catch (Exception e) {
			logger.pass("Review Page not Verified" + logger.addScreenCaptureFromPath(screenshotPath));
			throw e;
		}
	}
	
}
