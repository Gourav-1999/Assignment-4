//package com.test;
//import java.io.FileNotFoundException;
//import java.time.Duration;
//import java.util.Iterator;
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.utilities.TestBase;
//import com.utilities.YamlReaderFile;
//
//public class Test1 extends TestBase {
//
//	TestBase t = new TestBase();
//	YamlReaderFile read = new YamlReaderFile();
//	
//	//WebDriver driver;
//
//	
//	@BeforeTest
//	public void launchBrowser() throws Exception {
//		//System.out.println(read.getData("selectradiobutton"));
//		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\gourav.vig\\eclipse-workspace\\NDTV\\drivers\\chromedriver\\chromedriver.exe");
//		//driver = new ChromeDriver();
//		TestBase.initialization();
//		System.out.println(read.getData("radiobuttonexample.selectradiobutton"));
//
//	}
//	
//	@Test(priority = 0)
//	public void selectRadioButton() throws Exception {
//		String xpath=read.getData("radiobuttonexample.selectradiobutton").replace("car", prop.getProperty("car3"));
//		
//		System.out.println(xpath);
//		driver.findElement(By.xpath(xpath)).click();
//		
//	}
//	
//	@Test(priority = 1)
//	public void selectClassExample() throws Exception {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		String xpath1= read.getData("selectclassexample.clickselectclass");
//		driver.findElement(By.xpath(xpath1)).click();
//		String xpath = read.getData("selectclassexample.selectclass").replace("car", prop.getProperty("car2") );
//		driver.findElement(By.xpath(xpath)).click();
//	}
//	@Test(priority = 2)
//	public void multipleSelect() throws Exception {
//		String xpath = read.getData("multipleselectexample.multipleselect").replace("fruit", prop.getProperty("fruit1"));
//		driver.findElement(By.xpath(xpath)).click();
//	}
//	@Test(priority = 3)
//	public void checkBoxExample() throws Exception {
//		String xpath = read.getData("checkboxexample.selectcheckbox").replace("car", prop.getProperty("car2"));
//		driver.findElement(By.xpath(xpath)).click();
//	}
//	@Test(priority = 4)
//	public void swithWindowExample() throws FileNotFoundException {
//		String xpath = read.getData("switchwindowexample.clickwindow");
//		driver.findElement(By.xpath(xpath)).click();
//		 // window handles
//	      Set w = driver.getWindowHandles();
//	      // window handles iterate
//	      Iterator t = w.iterator();
//	      String ch = (String) t.next();
//	      String pw = (String) t.next();
//	      // switching child window
//	      driver.switchTo().window(pw);
//	      System.out.println("Child window title "+ driver.getTitle());
//	      // close the child browser window
//	      driver.close();
//	      // switching parent window
//	      driver.switchTo().window(ch);
//	      System.out.println("Parent window title: "+ driver.getTitle());
//	}
//	@Test(priority = 5)
//	public void swithTabExample() throws Exception {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		String xpath = read.getData("switchtabexample.clicktab");
//		driver.findElement(By.xpath(xpath)).click();
//		String parent=driver.getWindowHandle();
//		Set<String>s1=driver.getWindowHandles();
//		Iterator<String> I1= s1.iterator();
//		while(I1.hasNext())
//		{
//		  String child_window=I1.next();
//		  if(!parent.equals(child_window))
//		  {
//		    driver.switchTo().window(child_window);
//		    System.out.println(driver.switchTo().window(child_window).getTitle());
//		    driver.close();
//		  }
//		}
//		driver.switchTo().window(parent);
//		System.out.println(driver.switchTo().window(parent).getTitle());
//	}
//}
