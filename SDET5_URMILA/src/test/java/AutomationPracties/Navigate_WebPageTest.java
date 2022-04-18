package AutomationPracties;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigate_WebPageTest {
	@Test
	public void navigate() throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
	
		driver.navigate().to("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("urmiladevipedasingu144@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("12b01a05d1");
		driver.findElement(By.name("login")).click();
	
		Thread.sleep(1000);
		
		driver.navigate().forward();
		Thread.sleep(1000);
		
		driver.navigate().back();
		Thread.sleep(1000);
		
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		driver.quit();
	}

}
