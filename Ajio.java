package week3.day2.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Lauch URL
		driver.get("https://www.ajio.com");

		// search box type as bags and press enter
		driver.findElement(By.name("searchVal")).sendKeys("bags", Keys.ENTER);

		// click on Gender - Men
		driver.findElement(By.xpath("//label[@for='Men']")).click();

		// click on Fashion Bag
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'Fashion Bags')]")).click();
		// driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();

		// Printing the count of the Items Found
		Thread.sleep(1000);
		WebElement count = driver.findElement(By.xpath("//label[contains(text(),'Fashion Bags')]"));
		String count1 = count.getText();
		String num = count1.replaceAll("[\\D]", "");
		System.out.println("Count of Items Found : " + num);

		// List of Brands and Print it
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='brands']")).click();

		// click on more
		driver.findElement(By.xpath("(//div[@class='cat-facets '])[4]/div[2]/div")).click();

		List<WebElement> brand = driver.findElements(By.xpath("(//input[@name='brand'])"));
		System.out.println('\n' + "List of Brands:");
		for (WebElement brandNames : brand) {

			System.out.println(brandNames.getAttribute("value"));
		}

		driver.findElement(By.xpath("//div[@class='ic-close-quickview']")).click();

		// Get Bag details
		// dynamically scroll the page to load the content fully

		driver.findElement(By.xpath("//div[@class='five-grid']")).click();
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,(document.body.scrollHeight/2))", "");
		Thread.sleep(2000);
		
	List<WebElement> bagName1 = driver.findElements(By.xpath("//div[@class='name']"));
		
		System.out.println(bagName1.size());
		
		for (WebElement webElement : bagName1) {
			
			System.out.println(webElement.getText());
			
		}

	

		
		
		

		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * js.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
		 * Thread.sleep(5000);
		 * 
		 * 
		 * 
		 * long initialHeight = (Long)
		 * js.executeScript("return document.body.scrollHeight"); while (true) {
		 * js.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
		 * Thread.sleep(2000); long curentHeight = (Long)
		 * js.executeScript("return document.body.scrollHeight");
		 * 
		 * if (initialHeight == curentHeight ) { break; } initialHeight = curentHeight;
		 * }
		 * 
		 * Thread.sleep(2000);
		 * 
		 * // To use if not dynamic scroll
		 * 
		 * // js.executeScript("window.scrollTo(0,document.body.scrollHeight)", ""); //
		 * // Thread.sleep(5000); //
		 * 
		 * // List<WebElement> bagBrand = //
		 * driver.findElements(By.xpath("(//div[@class='contentHolder'])/div[1]"));
		 * 
		 * // div[@class='name']
		 * 
		 * List<WebElement> bagName = driver.findElements(By.className("name"));
		 * 
		 * System.out.println(bagName.size());
		 * 
		 * for (WebElement name : bagName) { System.out.println(name.getText());
		 * 
		 * }
		 * 
		 * 
		 * List<WebElement> bagName =
		 * driver.findElements(By.xpath("(//div[@class='contentHolder'])/div[2]"));
		 * 
		 * System.out.println('\n' + "List of BagNames: "); for (WebElement name :
		 * bagName) {
		 * 
		 * System.out.println(name.getText()); }
		 * 
		 * 
		 * List<WebElement> bagName2 =
		 * driver.findElements(By.xpath("((//div[@class='preview'])/div[2])//div[2]"));
		 * for (WebElement name1 : bagName2) { System.out.println(name1.getText()); }
		 * 
		 * 
		 * }
		 */
	}

}
