package com.selenium.webdriver.concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BrookstoneTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();	
		driver.get("https://www.brookstone.com");
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		WebElement logInLink = driver.findElement(By.cssSelector("a[title$=' In']"));
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("string argument 0", "need an instance of an Object");
		
		
//  <a class="user-login"  title="Log In"</a>
		// first you need the html tag of the element: a
		// then put [] after the a
		// now, inside the [], put your unique identifier: class
		// how to customize the identifier: first way is to say:
		    // class*='user-login'
		    // class^='user-'
		    // class$='-login'
		
		// how to generate a random string
		
		try{
			
			if(logInLink.isDisplayed()){
				driver.findElement(By.cssSelector("a[title$=' In']")).click();
			}else{
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a[title$=' In']"))));
				driver.findElement(By.cssSelector("a[title$=' In']")).click();
			}
		
//			driver.findElement(By.xpath("//*[@id='wrapper']/header/section[1]/div/div[2]/ul/ul/li/a")).click();;						
		}catch(NoSuchElementException exe){
			System.out.println(exe.getMessage());
			throw new NoSuchElementException("wrong expression");
		}finally{
			driver.quit();
		}
	}

}
