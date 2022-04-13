package com.crm.TESTCASES;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MmtTakeFeatureDate_04_Test {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//li[@data-cy='account']")).click();
		Thread.sleep(2000);
		
		String src="BOM";
		String dest="DEL";
		
		driver.findElement(By.id("fromCity")).sendKeys(src);
		driver.findElement(By.xpath("//div[text()='"+src+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("toCity")).sendKeys(dest);
		driver.findElement(By.xpath("//div[text()='"+dest+"']")).click();

		driver.findElement(By.xpath("//label[@for='departure']")).click();
		Thread.sleep(3000);
		for (int i = 0; i < 11; i++) 
		{
			try 
			{
				driver.findElement(By.xpath("//div[@aria-label='Thu Oct 06 2022']")).click();
				break;
				
			} 
			catch (Exception e) 
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();				
			}
		}
	}

}
