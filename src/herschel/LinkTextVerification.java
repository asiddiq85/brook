package herschel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkTextVerification {
	private WebDriver driver;
	
	public LinkTextVerification(WebDriver driver){
		this.driver = driver;
	}
	
	String contactLink(){
		return driver.findElement(By.xpath("//*[@id='menu-footer']/li[1]/a")).getAttribute("href");
	}
	
	String shippingLink(){
		return driver.findElement(By.xpath("//*[@id='menu-footer']/li[2]/a")).getAttribute("href");
				
	}
	
	String returnLink(){
		return driver.findElement(By.xpath("//*[@id='menu-footer']/li[4]/a")).getAttribute("href");		
		
	}

}
