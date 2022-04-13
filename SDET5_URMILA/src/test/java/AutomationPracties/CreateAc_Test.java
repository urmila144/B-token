package AutomationPracties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateAc_Test {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("http://automationpractice.com");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@class='login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("urmiladevip14@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("12b01a05d1");
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("DRESSES");
		driver.findElement(By.name("submit_search")).click();
		Thread.sleep(2000);
		WebElement button = driver.findElement(By.xpath("(//div[@class=\"product-container\"])[1]"));
		JavascriptException js=(JavascriptException)driver;
	






		//		driver.findElement(By.xpath("//a[@title=\"Close\"]")).click();
		//		//driver.findElement(By.xpath("//button[@name='Submit']")).click();
		//		Thread.sleep(3000);
		//		driver.findElement(By.id("add_to_cart")).click();
		//		//		Thread.sleep(2000);
		//		//				 
		//		//
		//		//		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id=\"fancybox-frame1649075136890\"]")));
		//		//		 driver.findElement(By.xpath("//[@id='add_to_cart']/button")).click();
		//		//		
		//		//driver.findElement(By.xpath("//a[@class='fancybox-item fancybox-close']")).click();
		//		//driver.findElement(By.name("Submit")).click();

	}

}
