package com.pomail_booking;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class booking_verify {
	

@Test
	

	public void test1() throws InterruptedException, AWTException{
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
    System.setProperty("webdriver.chrome.driver","D:/driver/chromedriver.exe");
    options.addArguments("--disable-extensions");
    options.addArguments("start-maximized");
    WebDriver driver = new ChromeDriver(options);
    //navigate to url//
		  driver.get("https://ngenres.cargoflash.com/Index.cshtml");
		  
		  driver.manage().deleteAllCookies();
		  
		  Set<Cookie> allCookies = driver.manage().getCookies();
		  for (Cookie cookie : allCookies) {
		      driver.manage().deleteCookieNamed(cookie.getName());
		      
	}
		  WebDriverWait wait= new WebDriverWait(driver,60);
		  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ajit");
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("cargo");
		  driver.findElement(By.xpath("//input[@id='LogInBtn']")).click();
		  
		   try{
		   
		  //handling alert//
		  Alert  alert=driver.switchTo().alert();
		  alert.accept();
		   } catch (Exception error)
		   {
		     
		   
		   //Moving to Export//
			   
			driver.switchTo().frame("iMasterFrame");
			driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
			driver.switchTo().defaultContent();
		   }
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			WebElement element=driver.findElement(By.linkText("Mail"));
			 Actions act=new Actions(driver);
			act.moveToElement(element).perform();

			 WebElement ele=driver.findElement(By.linkText("Export Airmail"));
			 act.click(ele).build().perform();
			 
			 driver.switchTo().frame("iMasterFrame");
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='New Airmail']")));
	     
	     
			 driver.findElement(By.xpath("//button[text()='New Airmail']")).click();
			 
			 driver.findElement(By.xpath("//div/table[1]/tbody/tr[2]/td[2]/span/span/input[@id='Text_AirlineCode']")).sendKeys("ga");
			Thread.sleep(2000); 
		driver.findElement(By.xpath("//span[contains(text(),'GA-GARUDA AIRLINE')]")).click();
		//driver.switchTo().defaultContent();
		
		//driver.switchTo().frame("iMasterFrame");
		//click on origin
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='Text_ShipmentOrigin']")).sendKeys("jkt");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='JKT-JAKARTA']")).click();
		//destination 
		Thread.sleep(1000);
		driver.findElement(By.id("Text_ShipmentDest")).sendKeys("dps");
		
		driver.findElement(By.xpath("//span[text()='DPS-DENPASAR']")).click();
		driver.findElement(By.id("Text_MailNo")).sendKeys("cn38");
		driver.findElement(By.xpath("//li[text()='CN38']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("CN38No")).sendKeys("00988");
		driver.findElement(By.id("Text_IssuingAgent")).sendKeys("gpa");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='GPATES']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Text_SPHC")).sendKeys("mal");
		driver.findElement(By.xpath("//span[text()='MAL']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.id("Text_MailCategory")).sendKeys("air");
		driver.findElement(By.xpath("//span[text()='A-AIRMAIL']")).click();
		driver.findElement(By.id("_tempTotalPieces")).sendKeys("1");
		driver.findElement(By.id("_tempGrossWeight")).sendKeys("20");
		driver.findElement(By.id("_tempCBM")).sendKeys("0.9");
		
		Thread.sleep(1000);
		
	
		//Search Button for searching flight//
		driver.findElement(By.id("ItinerarySearch")).click();
//		driver.switchTo().defaultContent();
		Thread.sleep(10000);
		//page down//
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		//robot.keyPress(KeyEvent.VK_TAB);
		//robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//button[@id='14849956']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='tblFlightSearchResult']/tbody/tr[1]/td[15]/button/span[text()='Select']")));
		driver.findElement(By.xpath("//table[@id='tblFlightSearchResult']/tbody/tr[1]/td[15]/button/span[text()='Select']")).click();


}
}