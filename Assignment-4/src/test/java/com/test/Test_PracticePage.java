package com.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.PracticePage;

public class Test_PracticePage extends TestBase{
	
	PracticePage page = new PracticePage(driver);
	TestBase t = new TestBase();

	@BeforeTest
	public void launchBrowser() throws Exception {
		
		t.initialization();

	}
	@AfterTest
	public void closeBrowser() {
		t.tearDown();
	}
	@Test(priority = 0)
	public void test_selectRadioButton() throws Exception {
		page.selectRadioButton();
		logger.info("Select Radio Button Test Passed");
	}
	@Test(priority = 1)
	public void test_selectClassExample() throws Exception {
		page.selectClassExample();
		logger.info("Select Class Test Passed");
	}
	@Test(priority = 2)
	public void test_multipleSelect() throws Exception {
		page.multipleSelect();
		logger.info("Multiple Select Test Passed");
	}
	@Test(priority = 3)
	public void test_checkBoxExample() throws Exception {
		page.checkBoxExample();
		logger.info("Check Box Test Passed");
	}
	@Test(priority = 4)
	public void test_swithWindowExample() throws Exception {
		page.swithWindowExample();
		logger.info("Switch Window Test Passed");
	}
	@Test(priority = 5)
	public void test_swithTabExample() throws Exception {
		page.swithTabExample();
		logger.info("Switch Tab Test Passed");
	}
	@Test(priority = 6)
	public void test_SwitchToAlertExample() throws Exception {
		page.switchToAlertExample();
		logger.info("Switch To Alert Test Passed");
	}
	@Test(priority = 7)
	public void test_WebTableExample() throws Exception {
		page.webTableExample();
		logger.info("Web Table Test Passed");
	}
	@Test(priority = 8)
	public void test_EnableDisableExample() throws Exception {
		page.enableDisableExample();
		logger.info("Enable Disable Test Passed");
	}
	@Test(priority = 9)
	public void test_ElementDisplayedExample() throws Exception {
		page.elementDisplayedExample();
		logger.info("Element Disable Test Passed");
	}
	@Test(priority = 10)
	public void test_MouseHoverExample() throws Exception {
		page.mousehOverExample();
		logger.info("Mouse Hover Test Passed");
	}
//	@Test(priority = 11)
//	public void test_IFrame() throws Exception {
//		page.iframe();
//		logger.info("I Frame Test Passed");
//	}
}
