package com.selenium.webdriver.concepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MenuHandling {

	public static void main(String[] args) throws InterruptedException {
		
		// how to hover over to an element
		WebDriver driver = new FirefoxDriver();	
/*		driver.get("https://www.brookstone.com");
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.navigate().refresh();
		Thread.sleep(5000);
				
		WebElement home = driver.findElement(By.partialLinkText("Home"));
		
		Actions action = new Actions(driver);
		action.moveToElement(home).build().perform();
		
*/
		// how to 
		
		driver.get("http://www.makemytrip.com");
		Thread.sleep(9000);
		List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type*='radio']"));
		System.out.println(radioButtons.size());
		
		
		for(int i = 0; i < radioButtons.size(); i ++ ){
			if(radioButtons.get(i).isDisplayed()){
			radioButtons.get(i).click();
			}else{
				System.out.println(radioButtons.get(i).getAttribute("value") + " not visible");
			}
		}

	}

}
