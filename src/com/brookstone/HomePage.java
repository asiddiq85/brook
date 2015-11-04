package com.brookstone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	public void gotoHomePage(WebDriver driver){
		driver.findElement(By.id("svg2")).click();
		System.out.println(driver.getTitle());
		
		
	}

}
