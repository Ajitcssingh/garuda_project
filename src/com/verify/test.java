package com.verify;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
  
	public String getExeclData(String SheetName , int rowNum ,int ColNum) throws InvalidFormatException, IOException{
		String excelpath ="C:\\Users\\Ajit Singh\\Desktop\\New folder\\pp.xlsx";
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCell(ColNum);
		String data =cel.getStringCellValue();
		return data;
		
			}	
	@Test
	
	public void test1() throws InterruptedException{
		test ts = new test();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		   System.setProperty("webdriver.chrome.driver","D:/driver/chromedriver.exe");
		   options.addArguments("--disable-extensions");
		   options.addArguments("start-maximized");
		   WebDriver driver = new ChromeDriver(options);
		   driver.get("https://ngenres.cargoflash.com/Index.cshtml");
		 //  driver.manage().deleteAllCookies();
			  
//			  Set<Cookie> allCookies = driver.manage().getCookies();
//			  for (Cookie cookie : allCookies) {
//			      driver.manage().deleteCookieNamed(cookie.getName());
//			  }
			  
			  for(int i=0;i<35; i++){
				  try{
					  String username=  ts.getExeclData("Sheet1", i+1, (i)-i);
					  String password=  ts.getExeclData("Sheet1", i+1, (i+1)-i);
					  
				  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);  
					
				  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
				  driver.findElement(By.xpath("//input[@id='LogInBtn']")).click();
				  WebDriverWait wait = new WebDriverWait(driver, 60);
		 
		   
				  try 
				    {
				        //Handle the alert pop-up using seithTO alert statement
				        Alert alert = driver.switchTo().alert();
				        alert.accept();
				    }
				  catch(Exception e){
					 
				  }

		   //Moving to Export//
			   driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
			driver.switchTo().frame("iMasterFrame");
			driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
			driver.switchTo().defaultContent();
			
			WebElement element=driver.findElement(By.linkText("Reservation"));
			 Actions act=new Actions(driver);
			act.moveToElement(element).perform();
	
			 WebElement menu=driver.findElement(By.linkText("Reservation Booking"));
			 act.click(menu).build().perform();

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
				 //driver.switchTo().frame("iMasterFrame");
				 Thread.sleep(3000);
				 //Selecting agent//
		Robot robot=new Robot();
		 robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//				 //Thread.sleep(8000);//
				
				 //Destination dropdown//
	// driver.switchTo().frame("iMasterFrame");
	 Thread.sleep(5000);
	 String destination=  ts.getExeclData("Sheet1", i+1, (i+2)-i);
	 String dest = destination.toLowerCase();
	 Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='Text_AWBDestination']")).sendKeys(dest);
	 Thread.sleep(3000);
	 //passing destination  in dropdown//
	// driver.findElement(By.xpath("//span[contains(text(),'DEL-NEW DELHI')]")).click();
	 driver.findElement(By.xpath("//span[text()='"+destination+"']")).click();
	
	 
	// select agent
	// driver.switchTo().frame("iMasterFrame");
	 //driver.findElement(By.xpath("//table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/span/span/input")).click();

	 Thread.sleep(3000);
	 String Agent=  ts.getExeclData("Sheet1", i+1, (i+3)-i);
	 String agnt = Agent.toLowerCase();
	 
   driver.findElement(By.xpath("//input[@id='Text_AWBAgent']")).sendKeys(agnt);
	   Thread.sleep(1000);
   driver.findElement(By.xpath("//span[text()='"+Agent+"']")).click();
	   	   
   String product=  ts.getExeclData("Sheet1", i+1, (i+4)-i);
	 String produt = product.toLowerCase();
   driver.findElement(By.xpath("//input[@id='Text_Product']")).sendKeys(produt);
   
	// driver.findElement(By.xpath("//div/table/tbody/tr[2]/td[1]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/span/span/span/span")).click();
	 
	 Thread.sleep(2000);
	 
	 //product select
	 driver.findElement(By.xpath("//span[text()='"+product+"']")).click();

	//Pieces//	
	
	 String Pieces=  ts.getExeclData("Sheet1", i+1, (i+5)-i);
	 String GrossWieght = ts.getExeclData("Sheet1", i+1,(i+6)-i);
	 String CBM = ts.getExeclData("Sheet1",i+1,(i+7)-i);
	 String Length=ts.getExeclData("Sheet1",i+1, (i+8)-i);
	 String Width=ts.getExeclData("Sheet1",i+1, (i+9)-i);
	 String Height=ts.getExeclData("Sheet1", i+1, (i+10)-i);
	 System.out.println("Excel Data print: >>> "+ Pieces+","+GrossWieght+","+CBM+","+Length+","+Width+","+Width);
	System.out.println(Pieces);
		
		 driver.findElement(By.xpath("//input[@id='_tempAWBPieces']")).sendKeys(Pieces);
		
		//Gross Weight//
		 Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@id='_tempAWBGrossWeight']")).sendKeys(GrossWieght);
		 Thread.sleep(5000);
		 //cbm//
		 driver.findElement(By.xpath("//input[@id='_tempAWBVolumeWeight']")).sendKeys(CBM);
	
	//Coomodity dropdown//
		 
		 String comodity=  ts.getExeclData("Sheet1", i+1, (i+11)-i);
		 String cmodity = comodity.toLowerCase();
		 
	   driver.findElement(By.id("Text_Commodity")).sendKeys(cmodity);
		   Thread.sleep(1000);
	   driver.findElement(By.xpath("//span[text()='"+comodity+"']")).click();	 
	   Thread.sleep(3000);
	   String NOG=  ts.getExeclData("Sheet1", i+1, (i+12)-i); 
	   driver.findElement(By.xpath("//input[@id='NatureOfGoods']")).sendKeys(NOG);
	
	//Nature of Goods//
//	driver.switchTo().defaultContent();
//	driver.switchTo().frame("iMasterFrame");
	//Adding  Shipment Dimension//
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='AddDimension']")).click();
	
	//Length in dimension//
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@id='_temptblDimensionTab_Length_1']")).sendKeys(Length);
	//width in dimension//
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@id='_temptblDimensionTab_Width_1']")).sendKeys(Width);
	Thread.sleep(1000);
	//Height in dimension//
	driver.findElement(By.xpath("//input[@id='_temptblDimensionTab_Height_1']")).sendKeys(Height);

	Thread.sleep(4000);
	// update all in dimension//
	driver.findElement(By.xpath("//button[@id='tblDimensionTab_btnUpdateAll']")).click();
//	driver.switchTo().defaultContent();

//	driver.switchTo().frame("iMasterFrame");
	Thread.sleep(4000);
	//Back to Reservation Page//
	driver.findElement(By.xpath(".//input[@id='btnBackToReservation']")).click();
	//driver.switchTo().defaultContent();
	
//	driver.switchTo().frame("iMasterFrame");
	
	String shipper =  ts.getExeclData("Sheet1", i+1, (i+13)-i);
	 String sh = shipper.toLowerCase();
	
	driver.findElement(By.id("Text_SHIPPER_AccountNo")).sendKeys(sh);
	  Thread.sleep(1000);
	   driver.findElement(By.xpath("//span[text()='"+shipper+"']")).click();
	
	Thread.sleep(1000);
	   String consine  =  ts.getExeclData("Sheet1", i+1, (i+14)-i);
		 String con = consine .toLowerCase();
		
		driver.findElement(By.id("Text_CONSIGNEE_AccountNo")).sendKeys(con);
		  Thread.sleep(1000);
		   driver.findElement(By.xpath("//span[text()='"+consine+"']")).click();
		

	Thread.sleep(1000);
	/*Robot down=new Robot();
	down.keyPress(KeyEvent.VK_PAGE_DOWN);
	down.keyPress(KeyEvent.VK_PAGE_DOWN);*/
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,1000)", "");

	//Search Button for searching flight//
	driver.findElement(By.id("ItinerarySearch")).click();
	//driver.switchTo().defaultContent();
	Thread.sleep(3000);
	//page down//
	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	robot.keyPress(KeyEvent.VK_PAGE_DOWN);

	Thread.sleep(5000);
	//Select flight//
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='tblFlightSearchResult']/tbody/tr[1]/td[15]/button/span[text()='Select']")));
	Thread.sleep(1000);
	driver.findElement(By.xpath("//table[@id='tblFlightSearchResult']/tbody/tr[1]/td[15]/button/span[text()='Select']")).click();

	//driver.findElement(By.xpath("//button[@id='151782']")).click();
	
//	driver.switchTo().defaultContent();
//	driver.switchTo().frame("iMasterFrame");
	Thread.sleep(5000);    
	//Save booking//
	driver.findElement(By.xpath("//button[@id='btnSave']")).click();
	//driver.switchTo().defaultContent();
	//Execution//
	Thread.sleep(1000);
	//driver.switchTo().frame("iMasterFrame");
	driver.findElement(By.xpath("//table/tbody/tr[1]/td[25]/input[@title='EXECUTE']")).click();
	//driver.switchTo().defaultContent();
	Thread.sleep(4000);
	////page down//
	js.executeScript("window.scrollBy(0,240)","");
	////Execution save //
	//driver.switchTo().frame("iMasterFrame");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[@id='btnExecute']")).click();
	driver.switchTo().defaultContent(); 
	Thread.sleep(3000);
 	driver.findElement(By.xpath("//a[@id='logout']/img")).click();
			  
			  }
	
			  catch(Exception e){
				  driver.switchTo().defaultContent();
				  driver.findElement(By.xpath("//a[@id='logout']/img")).click();
				  Thread.sleep(1000);
				  
			  }
			  
		}	
		
driver.close();		


		   
	
	
}}
