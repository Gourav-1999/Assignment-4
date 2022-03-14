package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.utilities.YamlReaderFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	static WebDriver driver;
	static YamlReaderFile read = new YamlReaderFile();
	public static void iframe() throws Exception {
		
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		
		String xpath1= read.getData("iframe.clickselectcourse");
		WebElement web = driver.findElement(By.xpath(xpath1));
		Select s = new Select(web);
		s.selectByVisibleText("Test Automation");
//		String xpath = read.getData("selectclassexample.selectclass").replace("courses", propReaderFile.getData("course"));
//		driver.findElement(By.xpath(xpath)).click();
		driver.switchTo().parentFrame();
	}
	
	public static void mousehOverExample() throws Exception {
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
	
	public static void main(String[] args) throws Exception {
//		String str1 = "Apple,Orange,Mango";
//		List<String> fruit1 = Arrays.asList(str1.split(","));
//		System.out.println(fruit1);
//		String[] fruit = str1.split(",");
//		System.out.println(fruit[0]+" "+fruit[1]);
//		System.out.println(read.getData("cars.car1"));
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://courses.letskodeit.com/practice");
		mousehOverExample();
		iframe();
		
	}
}
