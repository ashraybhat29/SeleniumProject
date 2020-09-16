package com.topgear.qa.xpaths;

import org.openqa.selenium.By;

public interface DemoQADatePickerPageXpath {
	
	public static By datePickerText			= By.xpath("//div[contains(text(),'Date Picker')]");
	public static By selectDate 			= By.cssSelector("#datePickerMonthYearInput");
	public static By selectMonth 			= By.cssSelector(".react-datepicker__month-select");
	public static By selectYear 			= By.cssSelector(".react-datepicker__year-select");
	public static String selectDOB			= "//div[text()='%s']";
	public static By selectDateOfBirth		= By.xpath("//div[@class='react-datepicker__month']//div");
	public static By dateAndTime 			= By.cssSelector("#dateAndTimePickerInput");
	public static By selectTime 			= By.xpath("//ul[@class='react-datepicker__time-list']//li");
	
	public static By dateandTimeMonth 		= By.xpath("//div[@class='react-datepicker__month-read-view']");
	public static By dateandTimeMonth1to12 		= By.xpath("//div[@class='react-datepicker__month-dropdown']//div");
	
	
	public static By dateandTimeYear 		= By.xpath("//div[@class='react-datepicker__year-read-view']");
	public static By dateandTimeYear1to10	= By.xpath("//div[@class='react-datepicker__month-dropdown']//div");
	public static By upArrow				= By.xpath("(//div[@class='react-datepicker__year-option']//a)[1]");
	public static By downArrow				= By.xpath("(//div[@class='react-datepicker__year-option']//a)[2]");
}
