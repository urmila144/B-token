package com.crm.TESTCASES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.Generic.Fake_Data;
import com.Generic.PropFile_Util;
import com.Generic.WebDriverUtils;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.OrgINfoPAge;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization_TC0001 {
	@Test
	//public static void main(String[] args) throws Throwable {
		public void createOrganization() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverUtils driverUtils = new WebDriverUtils(driver);
		
		LoginPage loginpage = new LoginPage(driver);
		driverUtils.pageloadtimeout();
		//driver.get("http://localhost:8888");
		
		PropFile_Util propFile_Util = new PropFile_Util();
		driver.get(propFile_Util.readdatafrompropfile("URL"));

		driverUtils.maximisewindow();

		loginpage.loginToApp();
		//driver.manage().window().maximize();
		//driver.findElement(By.name("user_name")).sendKeys("admin");
		//driver.findElement(By.name("user_password")).sendKeys("admin");
		//driver.findElement(By.id("submitButton")).click();
//		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("GREEN14");
		Fake_Data data= new Fake_Data();
		
		HomePage homePage = new HomePage(driver);
		homePage.getOrglink().click();
		
		Thread.sleep(3000);
		
		OrgINfoPAge orginfopage = new  OrgINfoPAge(driver);
		orginfopage.getCreateorgbtn().click();
//		
//		CreateNewOrgPage newOrgPage = new CreateNewOrgPage(driver);
//		String orgname=data.getOrgname();
//		newOrgPage.getorgnametxtbox().sendKeys(orgname);
//		
//		WebDriverUtils.fistDD(newOrgPage.getIndustry(),"Chemicals");
//		WebDriverUtils.secondDD(newOrgPage.getType(),"Customer");
//		WebDriverUtils.thirdDD(newOrgPage.getRating(),"Customer");

//		WebElement fistDD = driver.findElement(By.xpath("//select[@name='industry']"));
//		Select sal=new Select(fistDD);
//		sal.selectByVisibleText("Chemicals");
//		
//		Thread.sleep(3000);
		
//		WebElement secondDD = driver.findElement(By.xpath("//select[@name='accounttype']"));
//		Select sal2 = new Select(secondDD);
//		sal2.selectByVisibleText("Customer");
		
//		Thread.sleep(2000);		
		
//		WebElement thirdDD = driver.findElement(By.xpath("//select[@name='rating']"));
//		Select sal3=new Select(thirdDD);
//		sal3.selectByVisibleText("Active");
//		
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//		
//		Thread.sleep(3000);
//		
//		driver.findElement(By.xpath("//a[text( )='Organizations']")).click();
//		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("GREEN4");
//		Thread.sleep(3000);
//		
//		WebElement fourDD = driver.findElement(By.xpath("//select[@name='search_field']"));
//		Select sal4=new Select(fourDD);
//		sal4.selectByVisibleText("Organization Name");
//		
//		driver.findElement(By.xpath("//input[@name='submit']")).click();
//		Thread.sleep(3000);
//
//        WebElement fiveDD = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//        Actions action = new Actions(driver);
//        action.moveToElement(fiveDD).perform();
//        
//        driver.findElement(By.xpath("//a[text( )='Sign Out']")).click();
//        
		}
	}
	

