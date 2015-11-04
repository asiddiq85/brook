package com.brookstone;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Electronics {
	
	public void hoverToElectronics(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.partialLinkText("Electronics"))).build().perform();
		WebElement element = driver.findElement(By.partialLinkText("Electronics"));
		action.click(element);
		System.out.println("moved!");		
//		List<WebElement> hoverElectronics = driver.findElements(By.xpath("//*[@id='wrapper']/header/nav/div[1]/div/ul/li[1]/div"));				
		
	}
	
	public void loadAnItem(WebDriver driver, String url){
		driver.get(url);
	}
	public void checkElectronicPrice(WebDriver driver) throws Exception{
		String localizedPrice = driver.findElement(By.xpath(".//*[@id='product-content']/div[1]/div/div[2]")).getText();
		if(localizedPrice.contains("$")) 
			throw new Exception("Here is a non matching price");
		
	}

}
