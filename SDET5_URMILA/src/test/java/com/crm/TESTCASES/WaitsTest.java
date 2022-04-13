package com.crm.TESTCASES;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class WaitsTest {
	
	WebDriver driver = new ChromeDriver();
	
	@FindBys(value= {@FindBy(name="user_name"),@FindBy(xpath="//input[@name='user_name']")})
	WebElement username;
	
	public WaitsTest()
	{
		PageFactory.initElements(driver, this);
		
	}
	@FindAll(value= { @FindBy (name="user_pasd"),@FindBy(xpath="//input[@name='user_password']")})
	WebElement password;
	
	@FindBy(id="submitButton")
	WebElement loginbtn;
	@Test
	public void test()
	{
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    username.sendKeys("admin");
	    driver.navigate().refresh();
	    password.sendKeys("admin");
	    loginbtn.click();
	}
			
	}
	
	


