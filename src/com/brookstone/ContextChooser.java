package com.brookstone;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class ContextChooser {
	String country;
	String currency;
	
	public ContextChooser(String country, String currency){
		this.currency = currency;
		this.country = country;
	}

	
	public String getCountryCode(String country){
		Map<String,String> countryCodeList = new HashMap<String,String>();
		countryCodeList.put("Aruba", "AW");
		countryCodeList.put("Austria", "AT");
		countryCodeList.put("Bangladesh", "BD");
		countryCodeList.put("Pakistan", "PK");
		countryCodeList.put("Australia", "AU");
		countryCodeList.put("Bahamas", "BS");
		countryCodeList.put("Canada", "CA");
		countryCodeList.put("Costa Rica", "CR");
		countryCodeList.put("Georgia", "GE");
		countryCodeList.put("Monaco", "MC");
		countryCodeList.put("Mexico", "MC");
		countryCodeList.put("Panama", "PA");
		countryCodeList.put("Belgium", "BG");
		countryCodeList.put("Guernsey", "GG");
		countryCodeList.put("Haiti", "HT");
		countryCodeList.put("Hong Kong", "HK");
		countryCodeList.put("Iceland", "IS");
		countryCodeList.put("Ireland", "ID");
		return countryCodeList.get(country);
		
	}
			
	public void contextChooser(WebDriver driver) throws Exception{
		/*
		 * make sure to give country code NOT the country name
		 */
				
		WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("bfx-cc-flag-link")));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("bfx-cc-flag-link"))));
		driver.findElement(By.id("bfx-cc-flag-link")).click();	
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("bfx-cc-flag-link")));
		
//		FluentWait<WebDriver> fWait = new FluentWait<WebDriver> (driver);
//		fWait.wait(55);
//		
		
		Select selectCountry = new Select(driver.findElement(By.id("bfx-cc-countries-select")));
		System.out.println("Trying to select: " + country);
		selectCountry.selectByVisibleText(country);		
//		List<WebElement>countryList = selectCountry.getAllSelectedOptions();
		
		Thread.sleep(2000);
		
		WebElement currencyChooser = driver.findElement(By.id("bfx-cc-currencies-select"));
		Select select = new Select(currencyChooser);
		System.out.println("Trying to select currency: " + currency);
		
		select.selectByVisibleText(currency);
		
		driver.findElement(By.id("bfx-cc-btn")).click();
		
	}
	public void continueShopping(WebDriver driver){
		if (this.flagShown(driver)){		
			driver.findElement(By.id("bfx-wm-continue-button")).click();
		}
	}
	private boolean flagShown(WebDriver driver){
		if (driver.findElement(By.id("bfx-wm-continue-button")).isDisplayed()){
			return true;
		}else{
			return false;
		}
		
	}


}
