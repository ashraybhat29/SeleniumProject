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



public class Assignment1_DemoQA extends BaseClass
{

	private static Logger log = LogManager.getLogger(Assignment1_DemoQA.class);
	
	@Test(description = "Verify drag and drop")
		public void TC01_verifyDragAndDrop() throws Throwable
		{
			log.info("***********TC01_verifyDragAndDrop***************");
			logger = report.createTest("TC01_verifyDragAndDrop");
			
			droppage.droppablePageVerify();
			
			log.info("Drag and drop page is loaded");
			logger.info("Drag and drop page is loaded");
			
			droppage.dragAndDrop();
			
			String Actual = droppage.droppedMessage;
			Assert.assertEquals(Actual, "Dropped");	
			
			log.info("Drag and drop operation performed successfully");	
			logger.pass("Drag and drop operation performed successfully");
		}
	
	@Test(description = "Verify DatePicker", dataProvider= "tc02TestData") 
		public void TC02_verifyDatePicker(String month, String date, String year, String dateandtime) throws Throwable 
		{
			log.info("***********TC02_verifyDatePicker***************");
			logger = report.createTest("TC02_verifyDatePicker");
			
			datepick.datePickerPageVerify();
			
			log.info("DatePicker page is loaded");
			logger.info("DatePicker page is loaded");
			
			datepick.selectDOB(month,date,year,dateandtime);
			
			String Actual = datepick.ActualValue;
			
			Assert.assertEquals("abc", ""+dateandtime+"");
			
			log.info("Date of Birth selected successfully");
			logger.pass("Date of Birth selected successfully");
		}
	@DataProvider
	public Object [][]tc02TestData() throws InvalidFormatException
	{
		Object data[][]= DataHandlers.getTestData("DatePicker");
		return data;
	}
	
	@Test(description = "Verify Selectable")
		public void TC03_verifySelectable() throws Throwable
		{
			logger = report.createTest("TC03_verifySelectable");
			log.info("***********TC03_verifySelectable***************");
	
			selectable.selectablePageVerify();
			
			log.info("selectable page is loaded");
			logger.info("selectable page is loaded");
			selectable.selectItem();
			
			String Actual = selectable.hexbtnBackgroundColor;
			Assert.assertEquals( Actual, "#007bff");
			
			log.info("All 4 Items selected successfully");
			logger.pass("All 4 Items selected successfully");
		}
	
	@Test(description = "Verify Select-Menu")
		public void TC04_verifySelectMenu() throws Throwable
		{
			log.info("***********TC04_verifySelectMenu***************");
			logger = report.createTest("TC04_verifySelectMenu");
			
			selectmenu.selectablePageVerify();
			
			log.info("selectmenu page is loaded");
			logger.info("selectmenu page is loaded");
			
			selectmenu.selectSelectValue("Blue");
			
			String Actual = selectmenu.hexbtnBackgroundColor;
			Assert.assertEquals( Actual, "#ffffff");
			
			log.info("Selection performed successfully");
			logger.pass("Selection performed successfully");
		}
	
	@Test(description = "Verify Practice Form", dataProvider= "tc05TestData") 
		public void TC05_verifyPracticeForm(String fname,String lname, String emailid,String gender, String mobilenumber,
				String month,String date,String year, String sub,String hobbies,String address) throws Throwable
		{
			log.info("***********TC05_verifyPracticeForm***************");
			logger = report.createTest("TC05_verifyPracticeForm");
			
			practiceform.practiceFormPageVerify();
			
			log.info("Practice Form page is loaded");
			logger.info("Practice Form page is loaded");
			
			practiceform.fillForm( fname, lname,  emailid, gender,  mobilenumber,
					 month, date, year,  sub, hobbies, address);
			
			String ActualMsg = practiceform.ExpectedMsg;
			Assert.assertEquals(ActualMsg,"Thanks for submitting the form");
			
			log.info("Practice Form filled and submitted successfully");
			logger.pass("Practice Form filled and submitted successfully");
		}
	
	@DataProvider
	public Object [][]tc05TestData() throws InvalidFormatException
	{
		Object data[][]= DataHandlers.getTestData("PracticeForm");
		return data;
	}
}
