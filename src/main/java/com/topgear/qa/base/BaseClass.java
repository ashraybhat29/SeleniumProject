package com.topgear.qa.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.events.EventFiringWebDriver;
//
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import com.topgear.qa.pageObjects.*;



public class BaseClass {
	public static  WebDriver 				driver		  =		null;
//	public static  ExtentTest 				test;
//	public 		   ExtentReports 			report;
//	public 		   ITestResult 				iTestResult   = 	null;
	public         DemoQADroppablePage 		droppage 	  = 	null;
	public         DemoQADatePickerPage 	datepick 	  = 	null;
	public         DemoQASelectablePage 	selectable 	  = 	null;
	public         MakeMyTripPage 			makemytrip	  = 	null;
	public         DemoQASelectMenuPage 	selectmenu 	  = 	null;
	public         DemoQAPracticeFormPage 	practiceform  =  	 null;

	
//	public ExtentHtmlReporter htmlReporter;
//	public ExtentReports extent;
//	public static ExtentTest logger;
	public static String screenshotPath;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	
	public String defaultBrowser = "chrome";

	
	@BeforeTest
	public void setUpSuite()
	{
	ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/ExtentReport "+getCurrentDateTime()+".html"));
	report = new ExtentReports();
	report.attachReporter(extent);
	
	// Create an object of Extent Reports
	report = new ExtentReports();
	report.attachReporter(extent);
	report.setSystemInfo("Host Name", "SeleniumTestNG Automation");
	report.setSystemInfo("Environment", "Testing");
	report.setSystemInfo("User Name", "Ashray Bhat");
	extent.config().setDocumentTitle("TestNG Automation ");
	// Name of the report
	extent.config().setReportName("Ashray Bhat ");
	// Dark Theme
	extent.config().setTheme(Theme.DARK);
	}

	
	
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(@Optional String browser, Method method) throws InterruptedException, IOException {
		if (browser != null) {
			this.openBrowser(browser);
		} else {
			this.openBrowser(defaultBrowser);
		}
	
		droppage		= new DemoQADroppablePage(this);
		datepick 		= new DemoQADatePickerPage(this);
		selectable   	= new DemoQASelectablePage(this);
		selectmenu 		= new DemoQASelectMenuPage(this);
		makemytrip 		= new MakeMyTripPage(this);
		practiceform	= new DemoQAPracticeFormPage(this);
	}

	public void openBrowser(String webBrowser) throws InterruptedException, IOException
	{
		
		if(webBrowser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\topgear\\qa\\resources\\chromedriver_85.exe");
			driver=new ChromeDriver();
			Reporter.log("Opened Chrome Browser");
		}
		else if(webBrowser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src/main//java//resources//geckodriver.exe");
			driver=new FirefoxDriver(); 
			Reporter.log("Opened firefox Browser");
		}
		else if(webBrowser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//src//main//java//resources//IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			Reporter.log("Opened IE Browser");
		}
	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
//MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
//We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.
//String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
			 screenshotPath = getScreenShot(driver, result.getName());
//To add it in the extent report
			logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			 screenshotPath = getScreenShot(driver, result.getName());
			logger.pass("Test Case passed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
	
		}
	
		report.flush();
		driver.quit();
	}
	
	//This method is to capture the screenshot and return the path of the screenshot.
		public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
	// after execution, you could see a folder "FailedTestsScreenshots" under src folder
			String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		}
	
	public  void captureScreenshot(String screenshotName) throws IOException
	{
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"/resources.Screenshots/"+screenshotName+".jpg"));
		System.out.println("Screenshot " +screenshotName+"saved successfully under resources folder");
		Reporter.log("Captured the screenshot and saved under resources folder");
	}
	
	public static String getCurrentDateTime()
	{
	DateFormat customeFormat = new SimpleDateFormat("MM_dd_yyy_HH_mm_ss");

	Date currentDate = new Date();

	return customeFormat.format(currentDate);
	}

	public  void switchToCheckoutWindow()
	{
		String mainWindow = driver.getWindowHandle();
		ArrayList<String> windowHandles = new ArrayList<String> (driver.getWindowHandles());
		for(String window : windowHandles)
		{
			if(!window.equals(mainWindow))
				driver.switchTo().window(window);
		}
		Reporter.log("Switched to product window");
	}
	public static String getBase64Image() {
		TakesScreenshot newScreen = (TakesScreenshot) driver;
		String scnShot = newScreen.getScreenshotAs(OutputType.BASE64);
		return "data:image/jpg;base64, " + scnShot;
	}

	public void waitForInvisibelityOfElement(By xpath) {
		
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(xpath));
		
	}
	public WebElement getVisibleElement(By xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpath)));
		return element;
	}
	
	
	public void waitForInvisibelity(By xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpath));
	}
	public Boolean verifyElementDisplayed(By xpath) {
		Boolean flag=false;
	try{
		flag=driver.findElement(xpath).isDisplayed();
	}
	catch (Exception e){}
	return flag;
	}

	public void selectByVisibleText(By xpath,String text) {
		Select select= new Select(driver.findElement(xpath));
		select.selectByVisibleText(text);
	}

	public List<WebElement> getSelectOptions(By xpath) {
		Select select= new Select(driver.findElement(xpath));
		return  select.getAllSelectedOptions();
	}
	
	 
	 public List<WebElement> getAllElements(By xpath)
	    {
	    	return driver.findElements(xpath);
	    }
}
