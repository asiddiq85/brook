package webdriver.concepts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IFrame {

	public static void main(String[] args) throws IOException {
		
		String projPath = System.getProperty("user.dir");
		String xmlFilePath = projPath + "\\src\\data\\xml_input.xml";
		
		
		BufferedReader br = new BufferedReader(new FileReader(xmlFilePath));
		StringBuilder sb = new StringBuilder();
	    try {	        
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        
	    } finally {
	        br.close();
	    }
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://172.21.1.174/cgi-bin/e3/setCheckoutSession.pl");
		driver.findElement(By.name("apiUsername")).clear();
		driver.findElement(By.name("apiUsername")).sendKeys("techknights_stage0");
		
		driver.findElement(By.name("apiPassword")).clear();
		driver.findElement(By.name("apiPassword")).sendKeys("Bdzm4GZ3");
				
		driver.findElement(By.name("payload")).clear();
		driver.findElement(By.name("payload")).sendKeys(sb);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type*='submit']")));
		
		driver.findElement(By.cssSelector("input[type*='submit']")).click();
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("envoy")));
//		WebElement mainPage = driver.findElement(By.id("checkout-page"));
//		List<WebElement> listOfElement = mainPage.findElements(By.tagName("section"));
//		for(WebElement e : listOfElement){
//			
//			System.out.println(e + " :: " + e.getAttribute("id"));
//		}
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("cc-frame")));			
		driver.findElement(By.name("cc-number")).sendKeys("5105105105105100");
		System.out.println("Entered cc info");
		
		driver.quit();
		
	}

}
