package com.payment;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class test {
   
	@Test
	
	public void verifytest(){
		
		ChromeOptions options =new ChromeOptions();
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
				 
				 driver.findElement(By.xpath("//button[text()='Search']")).click();
				 
			driver.findElement(By.xpath("//div[3]/table/tbody/tr[3]/td[17]/input")).click();
				 
				 
				 
				 
	}
}
