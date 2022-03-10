package com.pages;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.TestBase;
import com.utilities.YamlReaderFile;
import com.utilities.propReaderFile;

public class PracticePage extends TestBase {
	

	//WebDriver driver;
	YamlReaderFile read = new YamlReaderFile();
	propReaderFile prop = new propReaderFile();
	
	public PracticePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void selectRadioButton() throws Exception {
		String xpath=read.getData("radiobuttonexample.selectradiobutton").replace("car", prop.setCar1());
		
		System.out.println(xpath);
		driver.findElement(By.xpath(xpath)).click();
		
	}
	
	public void selectClassExample() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String xpath1= read.getData("selectclassexample.clickselectclass");
		driver.findElement(By.xpath(xpath1)).click();
		String xpath = read.getData("selectclassexample.selectclass").replace("car", prop.setCar2() );
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void multipleSelect() throws Exception {
		String xpath = read.getData("multipleselectexample.multipleselect").replace("fruit", prop.setFruit1());
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void checkBoxExample() throws Exception {
		String xpath = read.getData("checkboxexample.selectcheckbox").replace("car", prop.setCar3());
		driver.findElement(By.xpath(xpath)).click();
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
	      // close the child browser window
	      driver.close();
	      // switching parent window
	      driver.switchTo().window(ch);
	      System.out.println("Parent window title: "+ driver.getTitle());
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
		    driver.close();
		  }
		}
		driver.switchTo().window(parent);
		System.out.println(driver.switchTo().window(parent).getTitle());
	}
	
}
