package com.take_value_excel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class test {

@Test
public void check() throws InterruptedException, AWTException{
	ChromeOptions options = new ChromeOptions();
	options.addArguments("incognito");
	   System.setProperty("webdriver.chrome.driver","D:/driver/chromedriver.exe");
	   options.addArguments("--disable-extensions");
	   options.addArguments("start-maximized");
	   WebDriver driver = new ChromeDriver(options);
	   driver.get("https://ngenres.cargoflash.com/Index.cshtml");

	   driver.findElement(By.xpath(".//input[@id='email']")).sendKeys("ajit");  

	   driver.findElement(By.xpath(".//input[@id='password']")).sendKeys("cargo");
	   driver.findElement(By.xpath(".//input[@id='LogInBtn']")).click();
	   
	   try{
	   
	  //handling alert//
	  Alert  alert=driver.switchTo().alert();
	  alert.accept();
	   } catch (Exception error)
	   {
	     
	   }
	   //Moving to Export//
		   
		driver.switchTo().frame("iMasterFrame");
		driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement element=driver.findElement(By.linkText("Reservation"));
		 Actions act=new Actions(driver);
		act.moveToElement(element).perform();

		 WebElement ele=driver.findElement(By.linkText("Reservation Booking"));
		 act.click(ele).build().perform();

		 //New booking button//
		 

			//Loop for creating multiple booking//
			driver.switchTo().frame("iMasterFrame");
			//Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[text()='New Booking']")).click();
			//driver.switchTo().defaultContent();
			Thread.sleep(3000);
			 //Page Scroll down//
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("window.scrollBy(0,250)","");
			//driver.switchTo().defaultContent();
			 driver.findElement(By.xpath("//input[@id='Text_AWBDestination']")).sendKeys("sin");
			// driver.switchTo().defaultContent();
			// driver.switchTo().frame("iMasterFrame");
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//span[contains(text(),'SIN-SINGAPORE')]")).click();
			// driver.switchTo().defaultContent();
			 //Selecting agent//
			 //driver.switchTo().frame("iMasterFrame");
			
			 driver.findElement(By.xpath("//input[@id='Text_AWBAgent']")).sendKeys("jak");
			// driver.switchTo().defaultContent();
			 //driver.switchTo().frame("iMasterFrame");
			 
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//span[contains(text(),'JAKARTA UAT AGENT')]")).click();
			// driver.switchTo().defaultContent();
		//	driver.switchTo().frame("iMasterFrame");
			 driver.findElement(By.xpath("//input[@id='Text_Product']")).sendKeys("GEB");
			Thread.sleep(5000);
			 driver.findElement(By.xpath("//input[@id='_tempAWBPieces']")).sendKeys("2");
			// driver.switchTo().defaultContent();
			// driver.switchTo().frame("iMasterFrame");
			Thread.sleep(9000);
			//js.executeScript("document.getElementById('AWBGrossWeight').value= '5';");
			driver.findElement(By.xpath("//input[@id='_tempAWBGrossWeight']")).sendKeys("10");//
			 driver.findElement(By.xpath("//input[@id='_tempAWBCBM']")).sendKeys("2");
			// driver.switchTo().defaultContent();
			 //cbm//
			// driver.switchTo().frame("iMasterFrame");
			 Thread.sleep(5000);
			 driver.findElement(By.xpath("//input[@id='_tempAWBCBM']")).sendKeys("1");
		//driver.switchTo().defaultContent();	
		//driver.switchTo().frame("iMasterFrame");
		Thread.sleep(3000);
		driver.findElement(By.xpath(" .//input[@id='Text_Commodity']//following::span[2]")).click();
	//	driver.switchTo().defaultContent();
		//driver.switchTo().frame("iMasterFrame");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//div[@id='Text_Commodity-list']/ul/li/span")).click();
		//driver.switchTo().defaultContent();
		//driver.switchTo().frame("iMasterFrame");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//input[@id='NatureOfGoods']")).sendKeys("Fruits");
		//driver.switchTo().defaultContent();
		//driver.switchTo().frame("iMasterFrame");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//input[@id='ItinerarySearch']")).click();
		//driver.switchTo().defaultContent();
		Thread.sleep(3000);
		Robot robot =new Robot ();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		//driver.switchTo().frame("iMasterFrame");
		//Select flight//
		Thread.sleep(6000);
		//click on the flight//
		driver.findElement(By.xpath("//button[@id='15046814']")).click();
		//driver.switchTo().defaultContent();
		//driver.switchTo().frame("iMasterFrame");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='btnSave']")).click();
		driver.switchTo().defaultContent();
}
}