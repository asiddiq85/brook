package webdriver.concepts;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovements {

	public static void main(String[] args) throws InterruptedException {
		
		
		/*	this used to be done by an interface called Mouse
		 * 	now it's done with the Actions class
		 */
		
		WebDriver driver = new FirefoxDriver();		
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		driver.get("http://www.americangolf.co.uk");
		
		//starting to interact with the mouse
		Actions action = new Actions(driver);
		// moving mouse to an element
		WebElement golfClub = driver.findElement(By.linkText("Golf Clubs"));
		action.moveToElement(golfClub).build().perform();
		driver.findElement(By.partialLinkText("Drivers")).click();
		
		// dragging an object
		WebElement icon = driver.findElement(By.xpath("//*[@id='secondary']/div[1]/div[2]/div[1]/div[1]/span[1]"));
		action.dragAndDropBy(icon, 70, 0).build().perform();
		
		// locating elements inside an element
		WebElement americanGolf = driver.findElement(By.id("CLUBS_1"));
		
		List<WebElement> linksInsideGolfClubs =  americanGolf.findElements(By.tagName("a"));
		
		int linkCount =  linksInsideGolfClubs.size();
		WebElement golfClubR = driver.findElement(By.linkText("Golf Clubs"));
		action.moveToElement(golfClubR).build().perform();
		Random r = new Random();		
		linksInsideGolfClubs.get(r.nextInt(linkCount)).click();
		
		
		
		
		
	}

}
