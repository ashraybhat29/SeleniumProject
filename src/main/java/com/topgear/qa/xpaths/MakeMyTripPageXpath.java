package com.topgear.qa.xpaths;

import org.openqa.selenium.By;

public interface MakeMyTripPageXpath
{
	public static By iframe 				= By.xpath("//iframe[@title='notification-frame-31753606']");
	public static By iframeClose 			= By.xpath("//i[@class='wewidgeticon we_close']");
	public static By login 					= By.cssSelector(".bgGradient");
	public static By makemytriplogo 		= By.xpath("//img[@alt='Make My Trip']");
	public static By onwayRadioButton		= By.xpath("//li[@data-cy='Oneway']");
	public static By roundwayRadioButton	= By.xpath("//li[@data-cy='roundTrip']");
	
	
	public static By fromCity				= By.xpath("//*[@id='fromCity']");
	public static String cityName			=	"//p[contains(text(),'%s')]";
	public static By toCity					= By.xpath("//span[text()='To']");
	
	public static By departureDate			= By.xpath("//label[@for='departure']");
	public static String selectDateFromCal 	= "//div[@class='DayPicker-Day'][@aria-label='%s']";
	public static By returnDateCal 			= By.xpath("(//span[@class='selectedDateField appendBottom8 pointer'])[2]");
	public static By nextButton 			= By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']");
	
	public static By searchButton			= By.xpath("//a[contains(text(),'Search')]");
	
	public static By downArrowSort			= By.xpath("//span[@class='down sort-arrow']");
	public static By upArrowSort			= By.xpath("//span[@class='up sort-arrow']");
	public static By departureSortButton	= By.xpath(" //*[@id='sorter_btn_onward']");
	public static By sortLowToHighDD 		= By.xpath("(//span[text()='Price']/following-sibling::p[text()='Low to High'])[1]");
	
	public static By departurePrice			= By.xpath("(//div[@class='splitVw-sctn pull-left']//span[@class='actual-price'])[1]");
														
	public static By returnPrice 			= By.xpath("(//div[@class='splitVw-sctn pull-right']//span[@class='actual-price'])[1]");
	
	
	public static By bookButton 			= By.xpath("//button[text()='Book Now']");
	
	public static By continueButton			= By.xpath(" //button[contains(text(),'Continue')]");
	public static By reviewLabel			= By.xpath("//h4[contains(text(),'Review your booking')]");
	
	
	
}
