package com.multi_poemail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class test {
  
	
static int rowsize;
	@Test
	public void check () throws InterruptedException, AWTException{
		
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
//		  String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
//		//  String captchaVal = driver.findElement(By.xpath("//img[@src='/Handler/CaptchaHandler.ashx']")).getText(); 
//		 
//		  //this will read the captcha
//		  System.out.println(captchaVal);
//		  driver.findElement(By.xpath("//input[@id='CaptchaCode']")).sendKeys(captchaVal);
//		  
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
			 
			 
		     driver.findElement(By.xpath("//div/table[2]/tbody/tr/td[16]/button[@id='btnSearch']")).click();
		     Thread.sleep(1000);
		     
		     driver.findElement(By.xpath("//span[text()='CN38CGK120091']//following::td[14]/input")).click();
		     Thread.sleep(2000);
		     wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/table/tfoot/tr/td/button[@id='tblAirMailTrans_btnAppendRow']")));
		     
		     rowsize = driver.findElements(By.xpath("(//table[@id='tblAirMailTrans'])[1]/tbody/tr")).size();
		     Thread.sleep(2000);
		  for(int i=rowsize+1;i<=100;i++){ 
			  
			 // try{
				  
			  Thread.sleep(5000);
		    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tblAirMailTrans_btnAppendRow")));	 
		     driver.findElement(By.cssSelector("#tblAirMailTrans_btnAppendRow")).click();
		     Thread.sleep(1000);
		     Robot robot=new Robot();
		 	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	 //	robot.keyPress(KeyEvent.VK_TAB);
		 	//robot.keyPress(KeyEvent.VK_ENTER);

		     JavascriptExecutor jse = (JavascriptExecutor)driver;
			 	jse.executeScript("window.scrollBy(0,1400)", "");
			 	Thread.sleep(1000);
		    // driver.findElement(By.xpath("//div/div/div/table/tbody/tr/td[3]/span/span/span/span")).click();
		     driver.findElement(By.xpath("//tr[1]/td/div/div/div/table/tbody/tr["+i+"]/td[3]/span/span/input")).sendKeys("id");
		     
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='tblAirMailTrans_OriCountryCode_"+i+"-list']//span[text()='ID-INDONESIA']")));
		     
		     Thread.sleep(2000);
		     driver.findElement(By.xpath("//div[@id='tblAirMailTrans_OriCountryCode_"+i+"-list']//span[text()='ID-INDONESIA']")).click();
		     
		     //driver.findElement(By.xpath("//div/div/div/table/tbody/tr/td[4]/span/span/span/span")).click();
		     Thread.sleep(2000);
		     driver.findElement(By.xpath("//div/div/table/tbody/tr["+i+"]/td[4]/span/span/input")).sendKeys("jkt");
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='tblAirMailTrans_OriCityCode_"+i+"-list']//span[text()='JKT-JAKARTA']")));
		     driver.findElement(By.xpath("//div[@id='tblAirMailTrans_OriCityCode_"+i+"-list']//span[text()='JKT-JAKARTA']")).click();
		     
		    // driver.findElement(By.xpath("//div/div/div/table/tbody/tr/td[5]/span/span/span/span")).click();
		    
		     driver.findElement(By.xpath("//tr[1]/td/div/div/div/table/tbody/tr["+i+"]/td[5]/span/span/input")).sendKeys("a-aalborg");
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='tblAirMailTrans_OriOEQualifier_"+i+"-list']//span[text()='A-AALBORG']")));
		     driver.findElement(By.xpath("//div[@id='tblAirMailTrans_OriOEQualifier_"+i+"-list']//span[text()='A-AALBORG']")).click();
		     Thread.sleep(2000);
		     //driver.findElement(By.xpath("//div/div/table/tbody/tr/td[6]/span/span/span/span")).click();
		     driver.switchTo().defaultContent();
		     
		     driver.switchTo().frame("iMasterFrame");
		    // driver.findElement(By.xpath("//div/div/div/table/tbody/tr/td[6]/span/span/span/span")).click();
		     driver.findElement(By.xpath("//tr[1]/td/div/div/div/table/tbody/tr["+i+"]/td[6]/span/span/input")).sendKeys("id");
		    // driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		    Thread.sleep(2000);
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='tblAirMailTrans_DestCountryCode_"+i+"-list']//span[text()='ID-INDONESIA']")));
		     driver.findElement(By.xpath("//div[@id='tblAirMailTrans_DestCountryCode_"+i+"-list']//span[text()='ID-INDONESIA']")).click();
		     
		     //driver.findElement(By.xpath("//div/div/table/tbody/tr/td[7]/span/span/span/span")).click();
		     Thread.sleep(3000);
		     driver.findElement(By.xpath("//tr[1]/td/div/div/div/table/tbody/tr["+i+"]/td[7]/span/span/input")).sendKeys("dps");
		     Thread.sleep(2000);
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='tblAirMailTrans_DestCityCode_"+i+"-list']//span[text()='DPS-DENPASAR']")));
		     driver.findElement(By.xpath("//div[@id='tblAirMailTrans_DestCityCode_"+i+"-list']//span[text()='DPS-DENPASAR']")).click();
		     Thread.sleep(3000);
		     driver.findElement(By.xpath("//div[@id='divAirMailDetails']//table[@id='tblAirMailTrans']/tbody/tr["+i+"]/td[8]/span/span/input")).sendKeys("a-aachen");
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='tblAirMailTrans_DestOEQualifier_"+i+"-list']//span[text()='A-AACHEN']")));
		     driver.findElement(By.xpath("//div[@id='tblAirMailTrans_DestOEQualifier_"+i+"-list']//span[text()='A-AACHEN']")).click();
		     
		     driver.findElement(By.xpath("//div[@id='divAirMailDetails']//table[@id='tblAirMailTrans']/tbody/tr["+i+"]/td[9]/span/span/input")).sendKeys("f-first class");
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='tblAirMailTrans_MailCategory_"+i+"-list']//span[text()='F-FIRST CLASS']")));
		     Thread.sleep(2000);
		     driver.findElement(By.xpath("//div[@id='tblAirMailTrans_MailCategory_"+i+"-list']//span[text()='F-FIRST CLASS']")).click();
		     
		     driver.findElement(By.xpath("//div[@id='divAirMailDetails']//table[@id='tblAirMailTrans']/tbody/tr["+i+"]/td[10]/span/span/input")).sendKeys("f1");
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='tblAirMailTrans_MailSubCategory_"+i+"-list']//span[text()='F1']")));
		     driver.findElement(By.xpath("//div[@id='tblAirMailTrans_MailSubCategory_"+i+"-list']//span[text()='F1']")).click();
		     
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='divAirMailDetails']//table[@id='tblAirMailTrans']/tbody/tr["+i+"]/td[11]/input[1]")));
		     driver.findElement(By.xpath("//div[@id='divAirMailDetails']//table[@id='tblAirMailTrans']/tbody/tr["+i+"]/td[11]/input[1]")).sendKeys("1");
		     Thread.sleep(5000);
		     driver.findElement(By.xpath("//div[@id='divAirMailDetails']//table[@id='tblAirMailTrans']/tbody/tr["+i+"]/td[12]/input[1]")).sendKeys(""+i);
		     Thread.sleep(5000);
		     driver.findElement(By.xpath("//div[@id='divAirMailDetails']//table[@id='tblAirMailTrans']/tbody/tr["+i+"]/td[13]/input[1]")).sendKeys("1");
		     Thread.sleep(5000);
		     driver.findElement(By.xpath("//div[@id='divAirMailDetails']//table[@id='tblAirMailTrans']/tbody/tr["+i+"]/td[14]/input[1]")).sendKeys("1");
		     Thread.sleep(5000);
		     driver.findElement(By.xpath("//div[@id='divAirMailDetails']//table[@id='tblAirMailTrans']/tbody/tr["+i+"]/td[15]/input[1]")).sendKeys("1");
		     Thread.sleep(5000);
		     driver.findElement(By.xpath("//div[@id='divAirMailDetails']//table[@id='tblAirMailTrans']/tbody/tr["+i+"]/td[16]/input[1]")).sendKeys("1");
		     Thread.sleep(5000);
		     driver.findElement(By.xpath("//div[@id='divAirMailDetails']//table[@id='tblAirMailTrans']/tbody/tr["+i+"]/td[17]/span/span/input")).sendKeys("ake03579ga");
		     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='tblAirMailTrans_ULDStock_"+i+"-list']//span[contains(text(),'AKE03579GA')]")));
		     driver.findElement(By.xpath("//div[@id='tblAirMailTrans_ULDStock_"+i+"-list']//span[contains(text(),'AKE03579GA')]")).click();
		    

		     
		     driver.findElement(By.xpath("//div[@id='divAirMailDetails']//table[@id='tblAirMailTrans']/tbody/tr["+i+"]/td[18]/input")).click();
		     
		     
			
				  
				  
			  
		     Thread.sleep(5000);
		     
		     jse.executeScript("window.scrollBy(-500,-0)");
		     
		   
		     
			//  }catch(Exception t){
		     
			//  }
		     
			}

			
		     driver.switchTo().defaultContent();
		     Thread.sleep(2000);
		     driver.findElement(By.xpath("//a[@id='logout']/img")).click();
		   
		   
		   
		   
//		   
//		   List<WebElement> links = driver.findElements(By.tagName("a"));
//		   
//			System.out.println(links.size());
//	 
//			for (int i = 1; i<=links.size(); i=i+1)
//	 
//			{
//	 
//				System.out.println(links.get(i).getText());
	 
			}
	 
	}
	
//
