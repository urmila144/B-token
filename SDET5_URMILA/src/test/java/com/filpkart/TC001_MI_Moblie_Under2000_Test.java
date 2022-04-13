package com.filpkart;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_MI_Moblie_Under2000_Test {
	
	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("mobiles under 20000");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		Thread.sleep(2000);
		
		WebElement wbe = driver.findElement(By.xpath("//div[@class='_4rR01T'][1]"));
		System.out.println(wbe.getText());
		Thread.sleep(2000);
		//WebElement wbe1 = driver.findElement(By.xpath("//div[text( )='₹14,149']"));
		//System.out.println(wbe1.getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@title='Mi']")).click();
		WebElement wbe2 = driver.findElement(By.xpath("//div[text( )='Redmi Note 11 (Horizon Blue, 64 GB)']"));
		System.out.println(wbe2.getText());
		
		
	}

}
