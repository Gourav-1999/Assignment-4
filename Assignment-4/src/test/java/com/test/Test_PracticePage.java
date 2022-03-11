package com.test;

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
	@Test(priority = 0)
	public void test_selectRadioButton() throws Exception {
		page.selectRadioButton();
	}
	@Test(priority = 1)
	public void test_selectClassExample() throws Exception {
		page.selectClassExample();
	}
	@Test(priority = 2)
	public void test_multipleSelect() throws Exception {
		page.multipleSelect();
	}
	@Test(priority = 3)
	public void test_checkBoxExample() throws Exception {
		page.checkBoxExample();
	}
	@Test(priority = 4)
	public void test_swithWindowExample() throws Exception {
		page.swithWindowExample();
	}
	@Test(priority = 5)
	public void test_swithTabExample() throws Exception {
		page.swithTabExample();
	}
	@Test(priority = 6)
	public void test_SwitchToAlertExample() throws Exception {
		page.switchToAlertExample();
	}
	@Test(priority = 7)
	public void test_WebTableExample() throws Exception {
		page.webTableExample();
	}
	@Test(priority = 8)
	public void test_EnableDisableExample() throws Exception {
		page.enableDisableExample();
	}
	@Test(priority = 9)
	public void test_ElementDisplayedExample() throws Exception {
		page.elementDisplayedExample();
	}
	@Test(priority = 10)
	public void test_MouseHoverExample() throws Exception {
		page.mousehOverExample();
	}
	@Test(priority = 11)
	public void test_IFrame() throws Exception {
		page.iframe();
	}
}
