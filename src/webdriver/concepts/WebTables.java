package webdriver.concepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTables {
	static WebDriver driver = new FirefoxDriver();
	public static void main(String[] args) throws InterruptedException {
		
				
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		driver.get("http://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		
		/*		tbody = table body
		 * 		tr = table row
		 * 		td = (intersecting) column
		 * 
		 * 		building table xpath 
		 *		//table[@class='dataTable'] -- the full table including column header
		 *     //table[@class='dataTable']/tbody -- table without column header
		 *     //table[@class='dataTable']/tbody/tr[2]  - row number 2
		 *     //table[@class='dataTable']/tbody/tr[2]/td[3] - 2nd row 3rd column
		 */			
		
//		for(WebElement element : driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"))){
//			// print all the rows' texts			
//			System.out.println(element.getText());
//		}
//		
//		
//		
//		for(WebElement element : driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td"))){
//			// print all the rows' texts			
//			System.out.println(element.getText());
//		}
		
//		printCompanyNameStockPrice();
		
		getRowWithData("data");
				

		
	}
	// practice in class
	public static void printCompanyNameStockPrice(){
		String companyName = "//table[@class='dataTable']/tbody/tr/td[1]";
		String currentPrice = "//table[@class='dataTable']/tbody/tr/td[3]";
		
		List<WebElement> companyNames = driver.findElements(By.xpath(companyName));
		List<WebElement> currentPrices = driver.findElements(By.xpath(currentPrice));
		System.out.println("Company: \t" + "\t \t Price");
		for(int i = 0; i < companyNames.size(); i ++ ){	
			
			System.out.println(companyNames.get(i).getText()  + currentPrices.get(i).getText());
		}
		System.out.println("company: ");
		for(WebElement ele : driver.findElements(By.xpath(companyName))){			
			System.out.println(ele.getText() );			
		}
	}
	
//	write a method/function which return the cell number with some data
	public static int getRowWithData(String data){
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		for (WebElement row : rows){
			System.out.println(row.getText());
		}
		return 0;
	}
	
}
