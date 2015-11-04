package herschel;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.brookstone.ContextChooser;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import junit.framework.Assert;

public class HerschelTest {
	
	public static void main(String[] args) throws Exception {
		
		
		String root = System.getProperty("user.dir");
		Properties prop = new Properties();
		
		FileInputStream fin = new FileInputStream(root + "\\src\\config\\herschel_or.properties");
		
		prop.load(fin);
		
		WebDriver driver = new FirefoxDriver(); // creating a webdriver instance to open FF				
		
		driver.get(prop.getProperty("url"));  // navigates to a URL
		driver.manage().window().maximize(); // maximize the browser
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		driver.findElement(By.id("submit")).click();
		
		ContextChooser cc = new ContextChooser("Bahamas", "Taka");
		cc.contextChooser(driver);
		cc.continueShopping(driver);
		
		
		
		LinkTextVerification links = new LinkTextVerification(driver);
		Assert.assertEquals(links.contactLink(),"http://shop.borderfree.com/help");
		Assert.assertEquals(links.shippingLink(), "http://shop.borderfree.com/help");
		Assert.assertEquals(links.returnLink(), "http://shop.borderfree.com/help");
		
		
		
		Shop shop = new Shop();
		shop.selectRadioButton(driver, "Pouches");
		shop.selectAPouch(driver);
		
		
		Assert.assertTrue(shop.getPriceCurrency(driver).contains("BDT"));
		shop.addToCart(driver);
		
		shop.checkOut(driver);
		
		driver.quit();
		System.out.println("TEST PASSED...");
	}
	
	
	
	public static void checkLinks(WebDriver driver){
		List<WebElement> listOfElementsWithTagA = driver.findElements(By.tagName("a"));

		Map<Integer, String> map = new HashMap<Integer, String>();
		
		int invalidURLCount = 0; int count = listOfElementsWithTagA.size();
		
		for(WebElement element: listOfElementsWithTagA){
						
			try{
				if(!element.getAttribute("id").equals(""))
				map.put(count, element.getAttribute("id"));							
				
			}catch(Exception exe){
				invalidURLCount = invalidURLCount + 1;
				
			}finally{
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

		
	}

}
