package com.brookstone;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
	
	private static final int RANDOM_STRING_LENGTH = 10; // a global variable
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";	
	
	public boolean signUpPageDisplayed(WebDriver driver){
		/*
		 * the following method return true or false
		 * it checks if the item log in link is displayed or not
		 */
		driver.navigate().refresh();
		WebElement logIn = driver.findElement(By.cssSelector("a[class*='user-login']"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(logIn));
		
		
		
		if (logIn.isDisplayed()){
			return true;
		}else{						
			return false;
		}						
	}
	
	public void quitBrowser(WebDriver driver){
		/*
		 * quits the browser
		 */
		driver.quit();
		System.out.println("Driver has quit!");
	}
	
	public void launchSignInPage(WebDriver driver){
		driver.findElement(By.xpath("//*[@id='wrapper']/header/section[1]/div/div[2]/ul/ul/li/a")).click();
	}
	
	public void createAccount(WebDriver driver){
		/*
		 * handles creating an account
		 */
		driver.findElement(By.name("dwfrm_login_register")).click();
		
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);
		driver.findElement(By.id("dwfrm_profile_customer_firstname")).sendKeys("First Name");
		driver.findElement(By.id("dwfrm_profile_customer_lastname")).sendKeys("First Name");
		
		driver.findElement(By.id("dwfrm_profile_customer_email")).sendKeys(randomEmail());
		driver.findElement(By.id("dwfrm_profile_customer_emailconfirm")).sendKeys(randomEmail());
		
//		List<Type>
		List<WebElement> dobSelectors = driver.findElements(By.cssSelector("path[id*='rect']"));  
		// there are more than one with the cssSelector so we are making a list
		dobSelectors.get(0).click();  // selecting the first element
		
		// .//*[@id='RegistrationForm']/fieldset/div[5]/div[1]/div/div[3]/ul/li[6]
		driver.findElement(By.xpath("//*[@id='RegistrationForm']/fieldset/div[5]/div[1]/div/div[3]/ul/li[4]")).click();
		
		dobSelectors.get(1).click();
		driver.findElement(By.xpath("//*[@id='RegistrationForm']/fieldset/div[5]/div[2]/div/div[3]/ul/li[8]")).click();
		dobSelectors.get(2).click();
		driver.findElement(By.xpath("//*[@id='RegistrationForm']/fieldset/div[5]/div[3]/div/div[3]/ul/li[7]")).click();
		driver.findElement(By.id("dwfrm_profile_login_password")).sendKeys("Password*8");		
		driver.findElement(By.id("dwfrm_profile_login_passwordconfirm")).sendKeys("Password*8");
		System.out.println("finished entering data.");
	}
	
	private String randomEmail(){
		/*
		 * creates a random email address and returns an email address with @mailinator.com domain
		 */
		StringBuffer randStr = new StringBuffer();		
		
        for(int i = 0; i < RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString() + "@mailinator.com";
		
	}
	private int getRandomNumber() {
		/*
		 * returns a random number based on char list length
		 */
        int randomInt = 0;
        Random randomGenerator = new Random();        
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
//        System.out.println("randomInt is: " + randomInt);
        if (randomInt - 1 == -1) {
//        	System.out.println("returning random from if");
            return randomInt;
            
        } else {
//        	System.out.println("returning random from ELSE");
            return randomInt - 1;
       

	
        }
	}
}
