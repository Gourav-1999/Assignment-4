package com.pages;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.test.TestBase;
import com.utilities.XLUtility;
import com.utilities.YamlReaderFile;
import com.utilities.propReaderFile;

import junit.framework.Assert;

public class PracticePage extends TestBase {
	

	
	YamlReaderFile read = new YamlReaderFile();
	//propReaderFile prop = new propReaderFile();
   // Properties pro = prop.prop;
	String path = ".\\DataFiles\\test1.xlsx";
	XLUtility u = new XLUtility(path);
	public PracticePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void selectRadioButton() throws Exception {
		String xpath=read.getData("radiobuttonexample.selectradiobutton");
		WebElement web = driver.findElement(By.xpath(xpath.replace("car", propReaderFile.getData("car3"))));
		
		web.click();
		Assert.assertEquals(true, web.isSelected());
		System.out.println("Radio button is sellected");
		
	}
	
	public void selectClassExample() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String xpath1= read.getData("selectclassexample.clickselectclass");
		WebElement web1 = driver.findElement(By.xpath(xpath1));
		web1.click();
		String xpath = read.getData("selectclassexample.selectclass").replace("car", propReaderFile.getData("car2"));
		WebElement web2 = driver.findElement(By.xpath(xpath));
		web2.click();
		if(web2.isSelected()) {
			Assert.assertTrue(true);
			System.out.println("successfull select class");
		}else {
			System.out.println("not successfull select class");
		}
		
	}
	
	public void multipleSelect() throws Exception {
		String xpath = read.getData("multipleselectexample.multipleselect");
		String fruit = propReaderFile.getData("fruits");
		List<String> fruits = Arrays.asList(fruit.split(","));
		for(String s: fruits) {
			WebElement web = driver.findElement(By.xpath(xpath.replace("fruits", s)));
			web.click();
			Assert.assertEquals(true, web.isSelected());
			System.out.println("fruits selected");
			
		}
	}
	
	public void checkBoxExample() throws Exception {
		String xpath = read.getData("checkboxexample.selectcheckbox");
		String car = propReaderFile.getData("cars");
		List<String> cars= Arrays.asList(car.split(","));
		
		for(String s: cars) {
			
			WebElement web = driver.findElement(By.xpath(xpath.replace("cars", s)));
			web.click();
			Assert.assertEquals(true, web.isSelected());
			System.out.println("check box is selected");
		}
		
	}
	
	public void swithWindowExample() throws FileNotFoundException {
		String xpath = read.getData("switchwindowexample.clickwindow");
		driver.findElement(By.xpath(xpath)).click();
		 // window handles
	      Set w = driver.getWindowHandles();
	      // window handles iterate
	      Iterator t = w.iterator();
	      String ch = (String) t.next();
	      String pw = (String) t.next();
	      // switching child window
	      driver.switchTo().window(pw);
	      System.out.println("Child window title "+ driver.getTitle());
	      if(driver.getTitle().equals("All Courses")) {
	    	  Assert.assertTrue(true);
	      }
	      // close the child browser window
	      driver.close();
	      // switching parent window
	      driver.switchTo().window(ch);
	      System.out.println("Parent window title: "+ driver.getTitle());
	      if(driver.getTitle().equals("Practice Page")) {
	    	  Assert.assertTrue(true);
	      }
	}
	
	public void swithTabExample() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String xpath = read.getData("switchtabexample.clicktab");
		driver.findElement(By.xpath(xpath)).click();
		String parent=driver.getWindowHandle();
		Set<String>s1=driver.getWindowHandles();
		Iterator<String> I1= s1.iterator();
		while(I1.hasNext())
		{
		  String child_window=I1.next();
		  if(!parent.equals(child_window))
		  {
		    driver.switchTo().window(child_window);
		    System.out.println(driver.switchTo().window(child_window).getTitle());
		    if(driver.getTitle().equals("All Courses")) {
		    	  Assert.assertTrue(true);
		      }
		    driver.close();
		  }
		}
		driver.switchTo().window(parent);
		System.out.println(driver.switchTo().window(parent).getTitle());
		if(driver.getTitle().equals("Practice Page")) {
	    	  Assert.assertTrue(true);
	      }
	}
	
	public void switchToAlertExample() throws Exception {
		String xpath1 = read.getData("switchtoalertexample.entername");
		driver.findElement(By.xpath(xpath1)).sendKeys("qwe");
		String xpath2 = read.getData("switchtoalertexample.clickalert");
		driver.findElement(By.xpath(xpath2)).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath(xpath1)).sendKeys("asd");
		String xpath3 = read.getData("switchtoalertexample.clickconfirm");
		driver.findElement(By.xpath(xpath3)).click();
		driver.switchTo().alert().dismiss();
	}
	
	public void webTableExample() throws Exception {
		//write headers in excel sheet
//		u.setCellData("sheet1", 0, 0, "Author");
//		u.setCellData("sheet1", 0, 1, "Course");
//		u.setCellData("sheet1", 0, 2, "Price");
		
		//capture table rows
		String xpath = read.getData("webtableexample.table1");
		WebElement table = driver.findElement(By.xpath(xpath));
		int rows = table.findElements(By.xpath("tr")).size();
		System.out.println(rows);
		for(int r=2;r<=rows;r++) {
			//read data from web table
			String Author = table.findElement(By.xpath("tr["+r+"]//td[1]")).getText();
			String Course = table.findElement(By.xpath("tr["+r+"]//td[2]")).getText();
			String Price = table.findElement(By.xpath("tr["+r+"]//td[3]")).getText();
			
			System.out.println(Author+Course+Price);
			
			//writing data into excel sheet
			u.setCellData("sheet1", r, 0, Author);
			u.setCellData("sheet1", r, 1, Course);
			u.setCellData("sheet1", r, 2, Price);
		}
		System.out.println("Data Retrieving from web table succesfully...");
	}
	
	public void enableDisableExample() throws Exception {
		String xpath1 = read.getData("enabledisableexample.enterfield");
		WebElement web = driver.findElement(By.xpath(xpath1));
		web.sendKeys("jkl");
		String xpath2 = read.getData("enabledisableexample.disable");
		String xpath3 = read.getData("enabledisableexample.enable");
		driver.findElement(By.xpath(xpath2)).click();
		if (!web.isEnabled()) {
			driver.findElement(By.xpath(xpath3)).click();
			web.sendKeys("ustaad");
		}
	}
	
	public void elementDisplayedExample() throws Exception {
		String xpath1 = read.getData("elementdisplayedexample.writefield");
		WebElement web = driver.findElement(By.xpath(xpath1));
		web.sendKeys("baba ji");
		String xpath2 = read.getData("elementdisplayedexample.hide");
		driver.findElement(By.xpath(xpath2)).click();
		String xpath3 = read.getData("elementdisplayedexample.show");
		if(!web.isDisplayed()) {
			driver.findElement(By.xpath(xpath3)).click();
		}
	}
	
	public void mousehOverExample() throws Exception {
		String xpath1 = read.getData("mousehoverexample.clickmousehover");
		WebElement web = driver.findElement(By.xpath(xpath1));
		Actions a = new Actions(driver);
		a.moveToElement(web).build().perform();
		String xpath2 = read.getData("mousehoverexample.clicktop");
		driver.findElement(By.xpath(xpath2)).click();
		Thread.sleep(3000);
		String xpath3 = read.getData("mousehoverexample.clickreload");
		WebElement web1 = driver.findElement(By.xpath(xpath3));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		a.moveToElement(web).build().perform();
		web1.click();
	}
	public void iframe() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver,20);
//		Thread.sleep(3000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,700)", "");
//		String xpath1 = read.getData("iframe.clickselectcourse");
//		WebElement web = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath1)));
//		web.click();
//		Select s = new Select(web);
//		s.selectByVisibleText("Test Automation");
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,700)", "");
//		String xpath1= read.getData("iframe.clickselectcourse");
//		driver.findElement(By.xpath(xpath1)).click();
//		String xpath = read.getData("selectclassexample.selectclass").replace("courses", propReaderFile.getData("course"));
//		driver.findElement(By.xpath(xpath)).click();
		driver.switchTo().frame("courses-iframe");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,700)", "");
		String xpath1= read.getData("iframe.clickselectcourse");
		driver.findElement(By.xpath(xpath1)).click();
		String xpath = read.getData("selectclassexample.selectclass").replace("courses", propReaderFile.getData("course"));
		driver.findElement(By.xpath(xpath)).click();
	}
}
