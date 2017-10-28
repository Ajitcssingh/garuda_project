package com.Import_inbond;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class inbond_test {

	@Test
	
	public void test1() throws InterruptedException{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
	    System.setProperty("webdriver.chrome.driver","D:/driver/chromedriver.exe");
	    options.addArguments("--disable-extensions");
	    options.addArguments("start-maximized");
	    WebDriver driver = new ChromeDriver(options);
	    //navigate to url//
			  driver.get("http://ngenres.cargoflash.com/Index.cshtml");
			  
			  
			  driver.manage().deleteAllCookies();
			  
			  Set<Cookie> allCookies = driver.manage().getCookies();
			  for (Cookie cookie : allCookies) {
			      driver.manage().deleteCookieNamed(cookie.getName());		      
		}
			 
				  
			  WebDriverWait wait= new WebDriverWait(driver,160);
			  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ajit");
			  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("cargo");
//			  String captchaVal 
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
				WebElement element= driver.findElement(By.linkText("Import"));
				Actions act=new Actions(driver);
				act.moveToElement(element).perform();
				Thread.sleep(2000);
				WebElement ele=driver.findElement(By.linkText("Inbound Flight"));
				act.click(ele).build().perform();
				
			// put on flight number
				driver.findElement(By.xpath("//input[@id='Text_searchFlightNo']")).sendKeys("ga-0420");
				
	}
	}