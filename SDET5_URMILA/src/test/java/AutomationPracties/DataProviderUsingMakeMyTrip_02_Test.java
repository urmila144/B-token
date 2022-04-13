package AutomationPracties;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderUsingMakeMyTrip_02_Test {
	
	@Test(dataProvider = "data")
	public void dataprovider(String src,String dest) throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//li[@data-cy='account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("fromCity")).sendKeys(src);
		driver.findElement(By.xpath("//div[text()='"+src+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("toCity")).sendKeys(dest);
		driver.findElement(By.xpath("//div[text()='"+dest+"']")).click();

		driver.findElement(By.xpath("//label[@for='departure']")).click();
		
		
	}
        @DataProvider
        public Object[][] data()
        {
        	Object arr[][]=new Object[2][2];
        	
        	arr[0][0]="BOM";
        	arr[0][1]="HYD";
        	
        	arr[1][0]="HYD";
        	arr[1][1]="BLR";
        	return arr;
      
        	
        	
        }
		
	}


