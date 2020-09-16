package com.topgear.qa.xpaths;

import org.openqa.selenium.By;

public interface DemoQAPracticeFormPageXpath 
{
	public static By formname 			= By.cssSelector(".main-header");
	public static By firstName 			= By.cssSelector("#firstName");
	public static By lastName 			= By.cssSelector("#lastName");
	public static By email 				= By.cssSelector("#userEmail");
	public static By genderMale 		= By.xpath("//label[@for='gender-radio-1']");
	public static By genderFemale		= By.xpath("//label[@for='gender-radio-2']");
	public static By genderOther		= By.xpath("//label[@for='gender-radio-3']");
	public static By mobile 			= By.cssSelector("#userNumber");
	public static By dateOfBirth 		= By.cssSelector("#dateOfBirthInput");
	public static By selectMonth 		= By.cssSelector(".react-datepicker__month-select");
	public static By selectYear 		= By.cssSelector(".react-datepicker__year-select");
	public static String selectDOB		= "//div[text()='%s']";
	public static By selectDate 			= By.cssSelector("#datePickerMonthYearInput");
	public static By subjects 			= By.xpath("//*[@id='subjectsContainer']/div/div[1]");
	public static By hobbiesSports 		= By.xpath("//label[@for='hobbies-checkbox-1']");
	public static By hobbiesReading 	= By.cssSelector("#hobbies-checkbox-2");
	public static By hobbiesMusic 		= By.cssSelector("#hobbies-checkbox-3");
	public static By pictureChooseFile 	= By.cssSelector("#uploadPicture");
	public static By currentAddress 	= By.cssSelector("#currentAddress");
	public static By selectState 		= By.xpath("//div[contains(text(),'Select State')]");
	public static By selectCity 		= By.xpath("//div[contains(text(),'Select City')]");
	public static By submit 			= By.cssSelector("#submit");
	public static By close	 			= By.cssSelector("#closeLargeModal");
	public static By thanksmsg	 		= By.xpath("//div[contains(text(),'Thanks for submitting the form')]");
	
}
