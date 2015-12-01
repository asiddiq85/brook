package herschel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Shop {
	
	public void selectRadioButton(WebDriver driver, String category){
		driver.findElement(By.linkText("All")).click();
		List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".collection-name> a"));
		
		for(WebElement checkbox : checkBoxes){
			
			if(checkbox.getAttribute("title").equals(category)){
				checkbox.click();
				break;
			}		
		}
		
		
	}
	
	public void selectAPouch(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='main']/div/div[2]/ul/li[5]/a/div/div/img[2]")).click();
		Thread.sleep(1000);		
		
				
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='product-add']/input")));
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='product-add']/input"))));
//		driver.findElement(By.xpath("//*[@id='product-add']/input")).click();
//		if(!driver.findElement(By.id("checkout-proceed")).isDisplayed()){
//			driver.findElement(By.id("open-cart")).click();
//		}
//		driver.findElement(By.xpath("//*[@id='checkout-proceed']/input")).click();
	}
	String getPriceCurrency(WebDriver driver){
		String priceCurrency = driver.findElement(By.cssSelector("p[class*='product-price']")).getText();
		return priceCurrency;
	}
	
	
	public void checkOut(WebDriver driver){
		driver.findElement(By.id("open-cart")).click();
		driver.findElement(By.cssSelector("input[value*='Checkout']")).click();
	}

}
