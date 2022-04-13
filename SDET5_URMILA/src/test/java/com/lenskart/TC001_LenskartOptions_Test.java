package com.lenskart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_LenskartOptions_Test {
	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.lenskart.com");
		driver.findElement(By.xpath("//input[@placeholder='What are you looking for ']")).click();
		Thread.sleep(3000);
		
	   List<WebElement> options = driver.findElements(By.xpath("//ul[@class='trending_list menu-link']//li"));
	  for (WebElement names : options) {
		 String list= names.getText();
		 System.out.println(list);
		
	}
	}
	}


