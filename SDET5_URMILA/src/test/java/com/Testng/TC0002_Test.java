package com.Testng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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

public class TC0002_Test {
	@Test
	//public static void main(String[] args) throws Throwable {
		public void org() throws IOException, InterruptedException    {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		FileInputStream fis = new FileInputStream(".\\Common.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
	
		driver.get(prop.getProperty("URL"));
		
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(prop.getProperty("UN"));
		driver.findElement(By.name("user_password")).sendKeys(prop.getProperty("PWD"));
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Thread.sleep(2000);
		
		FileInputStream fis1=new FileInputStream(".\\excel.xlsx");
		Workbook wb= WorkbookFactory.create(fis1);
		String value=wb.getSheet("Sheet1").getRow(12).getCell(0).getStringCellValue();
		
		Random num=new Random();
		int rnum = num.nextInt();
		String orgname=value+rnum;
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		
		
		WebElement fistDD = driver.findElement(By.xpath("//select[@name='industry']"));
		Select sal=new Select(fistDD);
		sal.selectByVisibleText("Chemicals");
		
		Thread.sleep(3000);
		
		WebElement secondDD = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select sal2 = new Select(secondDD);
		sal2.selectByVisibleText("Customer");
		
		Thread.sleep(2000);
		
		WebElement threeDD = driver.findElement(By.xpath("//select[@name='rating']"));
		Select sal3=new Select(threeDD);
		sal3.selectByVisibleText("Active");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(3000);
		
		//validation
		
		driver.findElement(By.xpath("//a[text( )='Organizations']")).click();
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("GREEN9");
		Thread.sleep(3000);
		
		WebElement fourDD = driver.findElement(By.xpath("//select[@name='search_field']"));
		Select sal4=new Select(fourDD);
		sal4.selectByVisibleText("Organization Name");
				
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(3000);
		//validation
		
		String actual_orgname = driver.findElement(By.xpath("//a[text( )='Organizations']")).getText();
		System.out.println(actual_orgname);
    	if(actual_orgname.equals(orgname))
		{
			System.out.println("TC Passed");
     	}
		else
		{
			System.out.println("Fail");
		}
		
		//logout
        WebElement fiveDD = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        Actions action = new Actions(driver);
        action.moveToElement(fiveDD).perform();
        driver.findElement(By.xpath("//a[text( )='Sign Out']")).click();
     
	}
	 public void Delete() {
    	 WebDriver driver = new ChromeDriver();
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    	 driver.findElement(By.xpath("//a[text()='Organizations']")).click();
    	 driver.findElement(By.name("search_text")).sendKeys("abc1");
    	 driver.findElement(By.xpath("//a[text()='Contacts']")).click();
    	 //driver.findElement(By.id("basicsearchcolumns_real")).sendKeys("Organization Name");
    	 driver.findElement(By.name("submit")).click();
    	 
    	 driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
    	 
     }
}

