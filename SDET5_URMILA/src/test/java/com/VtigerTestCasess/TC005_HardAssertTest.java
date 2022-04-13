package com.VtigerTestCasess;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Generic.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.Generic.Listners_Execution.class)
public class TC005_HardAssertTest 
{
	public WebDriver driver;
	public static WebDriver sdriver;
	
@Test

	public void hard() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		sdriver=driver;
		 driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		 String title = driver.getTitle();
		
		Assert.assertEquals(title, "vtiger");
		
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("n");
		driver.findElement(By.id("submitButton")).click();
	
	}
}
