package com.selenium.webdriver.concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class DownloadFile {
	
	public static void main(String[] args) throws InterruptedException{
		FirefoxProfile ffProfile = new FirefoxProfile();
		
		ffProfile.setPreference("browser.download.folderList", 2);
		ffProfile.setEnableNativeEvents(true);
		
//		
		ffProfile.setPreference("browser.download.dir", "C:\\Users\\Abubakar Siddiq\\Desktop\\sDownload");
		ffProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword, application/s-rar-compressed,"
				+ "application/octet-stream, application/csv,text/csv,  application/vnd.ms-excel");				 
		
		WebDriver driver = new FirefoxDriver(ffProfile);
		
//		driver.get("http://qtpselenium.com/test/testdownload.php");
//		driver.findElement(By.xpath("html/body/a[2]")).click();  // doesn't work
//		
//		WebElement electronics = driver.findElement(By.linkText("Electronics"));
		Actions action = new Actions(driver);
		
//		driver.get("https://brookstone.com");
//		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//		driver.findElement(By.cssSelector("button[title*='Close']")).click();
//		
//		action.moveToElement(electronics).build().perform();
		
		driver.get("https://jqueryui.com/demos/draggable");
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5000L, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
//		driver.findElement(By.partialLinkText("Sortable")).click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class*=demo-frame]")));
		System.out.println("switching successful");
//		WebElement drag =  driver.findElement(By.xpath("//*[@id='draggable']"));
		WebElement drag = driver.findElement(By.cssSelector("div[id*='draggable']"));
		action.dragAndDropBy(drag, 80, 80).build().perform();
		driver.switchTo().defaultContent();
		
		
		
		driver.findElement(By.linkText("Droppable")).click();
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class*=demo-frame]")));
		WebElement dragable = driver.findElement(By.cssSelector("div[id*='draggable']"));
		WebElement droppable = driver.findElement(By.cssSelector("div[id*='droppable']"));
		
		action.dragAndDrop(dragable, droppable).build().perform();
		driver.switchTo().defaultContent();
		
	
	}

}
