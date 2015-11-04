package com.brookstone;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrookStone {

	public static void main(String[] args) throws Exception {
		
		
		String root = System.getProperty("user.dir");
		Properties prop = new Properties();
		
		FileInputStream fin = new FileInputStream(root + "\\src\\config\\herschel_or.properties");
		
		prop.load(fin);
		
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to(prop.getProperty("url"));
		

		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));  // navigates to a URL
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		driver.findElement(By.id("submit")).click();
		
		ContextChooser cc = new ContextChooser("Bahamas", "Polish Zloty");
		cc.contextChooser(driver);
		cc.continueShopping(driver);
		
		
		Electronics electronics = new Electronics();
		electronics.hoverToElectronics(driver);
		
		electronics.loadAnItem(driver, "http://mbfx16198.brookstone.com.moovapp.com/2-in-1-leather-case-and-backup-battery/976420p.html");
		electronics.checkElectronicPrice(driver);
		
	}

}
