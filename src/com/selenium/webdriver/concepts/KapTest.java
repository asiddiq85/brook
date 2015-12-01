package com.selenium.webdriver.concepts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class KapTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver(); // creating a webdriver instance to open FF
				
		driver.manage().window().maximize(); // maximize the browser
		
//		driver.get("http://kaptest.com");  // navigates to a URL/
		driver.get("https://mbfx16210.shop.herschelsupply.com.moovapp.com/");  // navigates to a URL
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.id("submit")).click();				
		
//		String title = driver.getTitle(); // get the title of the page you are on		
//		System.out.println(title);
//				
		List<WebElement> listOfElementsWithTagA = driver.findElements(By.tagName("a"));

		Map<Integer, String> map = new HashMap<Integer, String>();
		
		int invalidURLCount = 0; int count = listOfElementsWithTagA.size();
		
		for(WebElement element: listOfElementsWithTagA){
						
			try{
				if(!element.getAttribute("id").equals(""))
				map.put(count, element.getAttribute("id"));							
				
			}catch(IllegalArgumentException ill){
				
			}catch(ArithmeticException ae){
				map.put(1, "v");
			}
			catch(Exception exe){
				invalidURLCount = invalidURLCount + 1;
				
			}
			finally{
				count = count - 1;
				driver.navigate().back();
			}
			
		}
		
		for(Integer key: map.keySet()){
			
			System.out.println(key + " : " + map.get(key));
			try{
			driver.findElement(By.id(map.get(key))).click();
			driver.navigate().back();
			
			}catch(ElementNotVisibleException eNVe){
				invalidURLCount = invalidURLCount + 1;
				
			}catch(ElementNotFoundException eNFe){
				System.out.println(eNFe.getMessage());
				
			}catch(NoSuchElementException nSEe){
				System.out.println(nSEe.getMessage());
			}
			
		}
		driver.quit();
		
		// creates a list of elements on the page based on the tagName (tagName = a in this case)
		
//		System.out.println(listOfElementsWithTagA.size());
//		
//		listOfElementsWithTagA.get(300).click(); // will click on 301th link -- assuming you have that many links
		
//		Thread.sleep(5000);
		
		
//		driver.quit();

	}

}
