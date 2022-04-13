package com.Testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Contact_TC0003_Test {
	@Test
	//public static void main(String[] args) throws Throwable {
	
	public void neworg() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			
			FileInputStream fis = new FileInputStream(".\\Common.properties");
			Properties prop=new Properties();
			prop.load(fis);
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get(prop.getProperty("url"));
			
			driver.manage().window().maximize();
			driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("username"));
			driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.xpath("//a[text( )='Contacts']")).click();
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			WebElement fistDD = driver.findElement(By.xpath("//select[@name='salutationtype']"));
			Select sal=new Select(fistDD);
			sal.selectByVisibleText("Mrs.");
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("GOPI");
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("SIRISHA");
			
			//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			driver.findElement(By.xpath("//img[@alt='Select']")).click();
			
			Set<String> win = driver.getWindowHandles();

			Iterator<String> itr = win.iterator();
			String parent = itr.next();
			String child = itr.next();
			
			driver.switchTo().window(child);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("urmila");
		WebElement	childDD=driver.findElement(By.name("search_field"));
			Select sel=new Select(childDD);
			sel.selectByVisibleText("Organization Name");
			driver.findElement(By.xpath("//input[@name='search']")).click();
			driver.findElement(By.xpath("//a[@id='1']")).click();
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			WebElement fiveDD = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	        Actions action = new Actions(driver);
	        action.moveToElement(fiveDD).perform();
	        driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	        
	}
	     public void Delete() {
	    	 WebDriver driver = new ChromeDriver();
	 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	    	 driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	    	 driver.findElement(By.name("search_text")).sendKeys("abc1");
	    	 driver.findElement(By.id("basicsearchcolumns_real")).sendKeys("Organization Name");
	    	 driver.findElement(By.name("submit")).click();
	    	 
	    	 driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
	    	 
	     }
	
}
