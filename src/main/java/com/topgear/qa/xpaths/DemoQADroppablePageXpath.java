package com.topgear.qa.xpaths;

import org.openqa.selenium.By;

public interface DemoQADroppablePageXpath {
	
	public static By droppableText		= By.xpath("//div[contains(text(),'Droppable')]");
	public static By dragMe 			= By.cssSelector("#draggable");
	public static By dropHere 			= By.xpath("//div[@id='droppableExample-tabpane-simple']/div[@id='simpleDropContainer']/div[@id='droppable']");
	public static By droppedMsg			= By.xpath("//p[contains(text(),'Dropped')]");

}
