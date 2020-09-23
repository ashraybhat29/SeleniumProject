package com.topgear.qa.xpaths;

import org.openqa.selenium.By;

public interface OlayPageXpath {
	
	public static By acceptCookiesG 	 = 	By.xpath("//font[contains(text(),'Accept all cookies')]");
	public static By registerG      	 =  By.partialLinkText("Register");
	public static By signInG			 =  By.xpath("(//font[contains(text(),'Sign in')])[1]");
	public static String genderG		 =	"//img[@title='%s']";
	public static By firstNameG 		 = 	By.xpath("//input[@data-key='firstName']");
	public static By surNameG	 		 = 	By.xpath("//input[@data-key='lastName']");
	public static By emailG		 		 = 	By.xpath("//input[@data-key='emailAddress']");
	public static By newPasswordG 		 = 	By.xpath("//input[@data-key='newPassword']");
	public static By confirmPasswordG	 = 	By.xpath("//input[@id='phdesktopbody_0_grs_account[password][password]']");
	public static By dayG		 		 = 	By.xpath("//select[@data-key='birthdate[dateselect_day]']");
	public static By monthG		 		 = 	By.xpath("//select[@data-key='birthdate[dateselect_month]']");
	public static By yearG		 		 = 	By.xpath("//select[@data-key='birthdate[dateselect_year]']");
	public static By streetHouseNoG		 = 	By.xpath("//input[@data-key='addressStreet1']");
	public static By postCodeG	 		 = 	By.xpath("//input[@data-key='addressPostalCode']");
	public static By locationG	 		 = 	By.xpath("//input[@data-key='addressCity']");
	public static By checkBoxG	 		 = 	By.xpath("//div[@class='pc_slct rembme']//input[@type='checkbox']");
	public static By createMyAccountG	 = 	By.xpath("//input[@value='Create my account']");
	public static By loginEmailIdG		 = 	By.id("phdesktopbody_0_username");
	public static By loginPasswordG		 = 	By.id("phdesktopbody_0_password");
	public static By loginSignInButtonG	 = 	By.xpath("//input[@type='submit']");
	
	
	
}
