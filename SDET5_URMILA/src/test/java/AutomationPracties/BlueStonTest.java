package AutomationPracties;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlueStonTest {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bluestone.com");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Actions ac=new Actions(driver);
		WebElement ring=driver.findElement(By.xpath("//a[@href='https://www.bluestone.com/jewellery/rings.html']"));
		ac.moveToElement(ring).build().perform();
		
		driver.findElement(By.xpath("//a[@title='Diamond Rings']")).click();
		 List<WebElement> ele = driver.findElements(By.xpath("//span[@class='new-price']"));
		 ArrayList list=new ArrayList();
		 
		 for(WebElement price:ele) {
			 String value=price.getText();
			String s=value.replaceAll("\\D+", "");
			list.add(s);
		 }
		 System.out.println(list);
	}

}
