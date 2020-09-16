package com.topgear.qa.xpaths;

import org.openqa.selenium.By;

public interface MakeMyTripPageXpath
{
	public static By login 					= By.cssSelector(".bgGradient");
	public static By makemytriplogo 		= By.xpath("//img[@alt='Make My Trip']");
	public static By onwayRadioButton		= By.xpath("//li[@data-cy='Oneway']");
	public static By roundwayRadioButton	= By.xpath("//li[@data-cy='roundTrip']");
	public static By fromCity				= By.xpath("//label[@for='fromCity']");
	public static By fromCityType			= By.xpath("//input[@placeholder='From']");
	
	public static By toCity					= By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']");
	public static By selectCity				= By.xpath("//ul[@role='listbox'][@class='react-autosuggest__suggestions-list']//li");
	public static By departureDate			= By.xpath("//label[@for='departure']");
	public static By returnDate				= By.xpath("//div[@data-cy='returnArea']");
	public static By searchButton			= By.xpath("//a[contains(text(),'Search')]");
	public static By downArrowSort			= By.xpath("//span[@class='down sort-arrow']");
	public static By upArrowSort			= By.xpath("//span[@class='up sort-arrow']");
	public static By viewPriceButton		= By.xpath("//button[@class='ViewFareBtn  text-uppercase '][@id='bookbutton-RKEY:ed60f1c4-7a91-4950-8713-929cc0229ed6:1_0']");
	public static By bookNowButton			= By.xpath("//button[@class='btn fli_primary_btn text-uppercase '][@xpath='1']");
	public static By reviewLabel			= By.xpath("//h4[contains(text(),'Review your booking')]");
	
	 public static By from=By.xpath("//*[@id='fromCity']");
	    public static String cityName="//p[contains(text(),'%s')]";
	    public static By to=By.xpath("//span[text()='To']");
}
