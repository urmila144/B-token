package com.VtigerTestCasess;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Generic.BaseClass;
import com.Generic.Fake_Data;
import com.Generic.PropFile_Util;
import com.Generic.WebDriverUtils;
import com.ObjectRepo.ContactInfoPage;
import com.ObjectRepo.ContactOrg_popup;
import com.ObjectRepo.CreateContactPage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_ContactWithOrg extends BaseClass{

		@Test
		public void createcontactwithorg() throws InterruptedException, IOException 
		//public void createcontactwithorg() throws InterruptedException, IOException 
		{

			//login vtigercrm
			Fake_Data data= new Fake_Data();
			WebDriverManager.geckodriver().setup(;)
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get("http://localhost:8888");
			driver.manage().window().maximize();
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();

			// TC003 Start

			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

			WebElement salutationtype = driver.findElement(By.name("salutationtype"));

			Select select = new Select(salutationtype);
			select.selectByValue("Mr.");

			driver.findElement(By.name("firstname")).sendKeys("GHAN");
			driver.findElement(By.name("lastname")).sendKeys("SHYAM");

			// window switching
			driver.findElement(By.xpath("//img[@alt='Select']")).click();
			WebDriverUtils driverUtils = new WebDriverUtils(driver);
			LoginPage loginPage = new LoginPage(driver);
			driverUtils.maximisewindow();
			driverUtils.pageloadtimeout();

			Set<String> windows = driver.getWindowHandles();
			PropFile_Util propFile_Util = new PropFile_Util();
			driver.get(propFile_Util.readdatafrompropfile("url"));

			Iterator<String> it = windows.iterator();
			loginPage.loginToApp();

			String parentid =	it.next();
			HomePage homePage = new HomePage(driver);
			homePage.getContactslink().click();
			// TC003 Start

			String childid=	it.next();
			ContactInfoPage contactInfoPage = new ContactInfoPage(driver);
			contactInfoPage.getCreatecontactsimg().click();

			driver.switchTo().window(childid);
			CreateContactPage  contactPage = new CreateContactPage(driver);

			driver.findElement(By.id("search_txt")).sendKeys("MANGO");
			Fake_Data fake_Data = new Fake_Data();
			String contactname=fake_Data.lastname();
			contactPage.getLastNameEdt().sendKeys(contactname);

			driver.findElement(By.name("search")).click();
			contactPage.getOrganizationLookUpImage().click();
			// window switching

			Thread.sleep(5000);
			driverUtils.switchTowindow("Accounts");
			ContactOrg_popup org_popup = new ContactOrg_popup(driver);
			org_popup.searchandSelectforOrg("Mango");

			driver.findElement(By.id("1")).click();

			driver.switchTo().window(parentid);
			driverUtils.switchTowindow("Contact");

			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			contactPage.getSaveBtn().click();

			Thread.sleep(3000);

			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			homePage.getContactslink().click();

			//validation
			contactInfoPage.checkcontactcreated(contactname, "Last Name");

			driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("GHAN");

			WebElement ddforcontacts=driver.findElement(By.id("bas_searchfield"));

			Select select1 = new Select(ddforcontacts);
			select1.selectByValue("firstname");

			driver.findElement(By.name("submit")).click();

			Thread.sleep(3000);

			String fname=driver.findElement(By.xpath("//span[@vtfieldname='firstname']/..")).getText();
			String fname1=driver.findElement(By.xpath("//span[@vtfieldname='lastname']/..")).getText();

			Assert.assertEquals(contactname, fname1);
//			if(fname.equals("GHAN")) {
//			if(fname.equals(contactname)) {
//				System.out.println("TC Pass");
//			}
//			else {
//				System.out.println("TC Fail");
			}
			//logout vtigercrm
//			WebElement ele1=driver.findElement(By.xpath("(//td[@class='small'])[2]"));
//			Actions act=new Actions(driver);
//			act.moveToElement(ele1).perform();
//			WebElement ele2=driver.findElement(By.xpath("//a[text()='Sign Out']"));
//			act.moveToElement(ele2).perform();
//			ele2.click();
//
//			Thread.sleep(8000);
//			driver.close();
//
//			homePage.logoutfromApp();
//
//			driverUtils.closeBrowser();

		//}
	//}
}
