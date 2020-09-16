package com.topgear.qa.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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

import com.topgear.qa.pageObjects.*;



public class BaseClass {
	public static  WebDriver 				driver		  =		null;
	public static  ExtentTest 				test;
	public 		   ExtentReports 			report;
	public 		   ITestResult 				iTestResult   = 	null;
	public         DemoQADroppablePage 		droppage 	  = 	null;
	public         DemoQADatePickerPage 	datepick 	  = 	null;
	public         DemoQASelectablePage 	selectable 	  = 	null;
	//public         MakeMyTripPage 			makemytrip	  = 	null;
	public         DemoQASelectMenuPage 	selectmenu 	  = 	null;
	public         DemoQAPracticeFormPage 	practiceform  =  	 null;

	
	public String defaultBrowser = "chrome";

	
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(@Optional String browser, Method method) throws InterruptedException, IOException {
		Test testMethod = method.getAnnotation(Test.class);
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
		report.loadConfig(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\extent-config.xml"));
		test = report.startTest(testMethod.description());
		if (browser != null) {
			this.openBrowser(browser);
		} else {
			this.openBrowser(defaultBrowser);
		}
	
		droppage		= new DemoQADroppablePage(this);
		datepick 		= new DemoQADatePickerPage(this);
		selectable   	= new DemoQASelectablePage(this);
		selectmenu 		= new DemoQASelectMenuPage(this);
		//makemytrip 		= new MakeMyTripPage(this);
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
	public void closeBrowser(Method method) throws IOException {
		Test testMethod = method.getAnnotation(Test.class);
		if (!iTestResult.isSuccess()) {
			test.log(LogStatus.FAIL, "Test "+testMethod.description()+" is failed");
			test.addBase64ScreenShot(getBase64Image());
		}
		driver.quit();
		
	}
	
	
	
	public  void captureScreenshot(String screenshotName) throws IOException
	{
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"/resources.Screenshots/"+screenshotName+".jpg"));
		System.out.println("Screenshot " +screenshotName+"saved successfully under resources folder");
		Reporter.log("Captured the screenshot and saved under resources folder");
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
