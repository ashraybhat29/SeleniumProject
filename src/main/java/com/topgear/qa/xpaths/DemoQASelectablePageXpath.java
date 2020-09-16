package com.topgear.qa.xpaths;

import org.openqa.selenium.By;

public interface DemoQASelectablePageXpath {
	public static By selectableText			= By.xpath("//div[contains(text(),'Selectable')]");
	public static By selectableItem = By.xpath("//ul[@id='verticalListContainer']//li");

}
