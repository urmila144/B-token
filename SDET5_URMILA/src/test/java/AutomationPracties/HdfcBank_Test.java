package AutomationPracties;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HdfcBank_Test {
	@Test
	
	public void hdfcBank() throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hdfcbank.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("nvpush_cross")).click();
//		driver.findElement(By.xpath("//img[@class='closeSummer']")).click();
//		driver.findElement(By.xpath("//span[@class='glyphicon icon-down-open-big ']")).click();
//		driver.findElement(By.id("onetrust-close-btn-container")).click();
//		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@class='drp1']")).click();
		}

}
