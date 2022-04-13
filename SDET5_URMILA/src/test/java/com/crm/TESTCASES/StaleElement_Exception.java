package com.crm.TESTCASES;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElement_Exception {
	@Test
	public void StaleElement() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement un = driver.findElement(By.name("user_name"));
		WebElement pwd = driver.findElement(By.name("user_password"));
		WebElement submitbtn = driver.findElement(By.id("submitButton"));
		
		un.sendKeys("admin");
		driver.navigate().refresh();
		pwd.sendKeys("admin");
		submitbtn.click();
		
		
	}

}
