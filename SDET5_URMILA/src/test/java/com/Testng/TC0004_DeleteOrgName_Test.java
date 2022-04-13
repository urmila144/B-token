package com.Testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC0004_DeleteOrgName_Test {
	@Test
	public void delete() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.name("search_text")).sendKeys("CON1");
		
//		WebElement DD = driver.findElement(By.xpath("//select[@id='bas_searchfield']"));
//		Select sal=new Select(DD);
//		sal.selectByVisibleText()
//		driver.findElement(By.name("submit")).click();
//		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
	}
}
