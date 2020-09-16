package com.topgear.qa.xpaths;

import org.openqa.selenium.By;

public interface DemoQASelectMenuPageXpath {
	public static By selectMenuText			= By.xpath("(//div[contains(text(),'Select Menu')])[1]");
	public static By selectValue 			= By.xpath("//div[contains(text(),'Select Option')]");
	public static By selectValueOptions 	= By.cssSelector("#react-select-2-option-0-0");
	public static By selectOne 				= By.xpath("//div[contains(text(),'Select Title')]");
	public static By oldStyleSelectMenu		= By.xpath("//select[@id='oldSelectMenu']");
	public static By multiselectDropDown	= By.xpath("(//div[@class=//div[contains(text(),'Select Menu')]' css-1hwfws3'])[3]");
	public static By standardMultiSelect	= By.xpath("//select[@id='cars']/option");
	public static By afterselection			= By.xpath("//select[@id='cars']");

}
