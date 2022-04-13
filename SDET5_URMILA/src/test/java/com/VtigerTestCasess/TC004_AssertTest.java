package com.VtigerTestCasess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generic.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.Generic.Listners_Execution.class)
public class TC004_AssertTest extends BaseClass {
@Test
	public void test() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:8888");
		
		String title = driver.getTitle();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(title,"vtiger");
		
		//Assert.assertEquals(title, "vtiger");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		driver.findElement(By.id("submitButton")).click();
	
		softAssert.assertAll();
		
	}
}
//extends BaseClass