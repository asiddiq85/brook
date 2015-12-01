package com.selenium.webdriver.concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumLessonOne {
	
	

	public static void main(String[] args) throws InterruptedException {						
		WebDriver driver = new FirefoxDriver(); // creating a webdriver instance to open FF
		driver.manage().window().maximize(); // maximize the browser
		driver.get("http://yahoo.com");  // navigates to a URL
		String title = driver.getTitle(); // get the title of the page you are on
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.findElement(By.linkText("Sing In")).click();
		List<WebElement> elements = new ArrayList<WebElement>();
		
		elements = driver.findElements(By.tagName("a"));
		for(WebElement e: elements){
			String linkText = e.getText();
			if(linkText.equals("Sports")){
//				Actions action = new Actions(driver);
//				action.moveToElement(e).build().perform();
				Thread.sleep(5000);							
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", e);
//				e.click();
//				System.out.println(linkText);
				break;
				}
		}
		try{
			List<WebElement> popupElements= driver.findElements(By.cssSelector("button[class*='Btn Primary']"));
			for(WebElement ele: popupElements){
				System.out.println(ele.getText());
				if(ele.getText().equals("No Thanks")){
					ele.click();
					break;
				}
			}
					//driver.findElements(By.cssSelector("button[class*='Btn Primary']");
			driver.findElement(By.cssSelector("button[class*='Btn Primary']")).click();

			
			
		}catch (Exception exe){
			System.out.println("Caught an exception");
			System.out.println(exe.getMessage());
			
		}

		Thread.sleep(5000);
//		driver.navigate().refresh();
		// making a comparison if the title of the page contains some characters
		if(title.contains("oog")){
			System.out.println("we landed on google.");
			
		}
		
		//making a comparison if the title of the page is the same as the comparing value
		if(title.equals("Google")){
			System.out.println("welcome to google");
		}		
		
		WebElement searchBox = driver.findElement(By.id("lst-ib"));// creating a webElement object
		searchBox.sendKeys("Hello Google"); //type something -'Hello World' in this case- in the input filed
		Thread.sleep(1000); //wait 1000 miliseconds [1 second]
		searchBox.clear(); // clear the text inside the input field
		Thread.sleep(3000); // sleep for 3 seconds
		
		driver.quit(); // quits the browser

		
	}

}
