package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.topgear.qa.base.BaseClass;
import com.topgear.qa.util.DataHandlers;

public class Assignment2_MakeMyTrip extends BaseClass
{
	private static Logger log = LogManager.getLogger(Assignment2_MakeMyTrip.class);

	@Test(description = "Make My Trip Test Case", dataProvider= "makeMyTrip")
	public void bookTikcet(String FromCity, String ToCity, String DepartureDate, String ReturnDate) throws Throwable 
	{
	
		logger = report.createTest("TC01_Book_Ticket_MakeMyTrip");
		log.info("***********TC01_Book_Ticket_MakeMyTrip***************");
	
		driver.get("https://www.makemytrip.com/");
		logger.info("Make My Trip page loaded");
		log.info("Make My Trip page loaded");
		
		makemytrip.switchToFrame1(driver);
		logger.info("Iframe has been identified and closed");
		log.info("Iframe has been identified and closed");
		
		makemytrip.clickOnRoundWay();
		logger.info("Roundway Selected");
		log.info("Roundway Selected");
		
		makemytrip.selectFromAndTo(FromCity,ToCity);
		logger.info("Selected From and To City");
		log.info("Selected From and To City");
		
		makemytrip.selectDepartureDate(DepartureDate);
		logger.info("Departure Date seleted");
		log.info("Departure Date seleted");
	
		makemytrip.selectReturnDate(ReturnDate);
		logger.info("Return Date seleted");
		log.info("Return Date seleted");
		
		makemytrip.clickSearch();
		logger.info("Clicked on Search Button");
		log.info("Clicked on Search Button");
		
		makemytrip.selectLowPrice();
		logger.info("Seleted Low Price");
		log.info("Seleted Low Price");
		
		makemytrip.reviewPage();
		Assert.assertEquals("Review your booking", makemytrip.reviewMsg);
		logger.info("Review Page loaded");
		log.info("Review Page loaded");
		
	}
	
	@DataProvider
	public Object [][]makeMyTrip() throws InvalidFormatException
	{
		Object data[][]= DataHandlers.getTestData("MakeMyTrip");
		return data;
	}
}