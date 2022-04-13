package com.VtigerTestCasess;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generic.BaseClass;
import com.Generic.Fake_Data;
import com.Generic.PropFile_Util;
import com.ObjectRepo.CreateNewOrgPage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.OrgINfoPAge;

public class TC002_CreateOrgTest extends BaseClass {

	
		@Test(groups="smoke")
		
		public void createorg() throws InterruptedException, IOException
		{
			PropFile_Util file_Util= new PropFile_Util();
			Fake_Data data = new Fake_Data();

			//login vtigercrm
//			WebDriverManager.chromedriver().setup();
//			WebDriver driver=new ChromeDriver();
//			WebDriverUtils driverUtils= new WebDriverUtils(driver);
//			driverUtils.pageloadtimeout();
//			driverUtils.maximisewindow();

			//driver.get(file_Util.readdatafrompropfile("url"));

			LoginPage loginPage = new LoginPage(driver);
			loginPage.loginToApp();

			HomePage homePage= new HomePage(driver);
			homePage.getOrglink().click();
			//Create New Organisation
			OrgINfoPAge orgINfoPAge = new  OrgINfoPAge(driver);
			orgINfoPAge.getCreateorgbtn().click();

			CreateNewOrgPage newOrgPage = new CreateNewOrgPage(driver);
			String orgname=data.getOrgname();
			newOrgPage.getorgnametxtbox().sendKeys(orgname);

			newOrgPage.getSaveorgbtn().click();
			Thread.sleep(3000);

			homePage.getOrglink().click();

			orgINfoPAge.searchforOrg(orgname, "accountname");

			String actual_orgname=	driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
			
			Assert.assertEquals(actual_orgname,orgname);
//			SoftAssert softassert=new SoftAssert();
//			softassert.assertEquals(actual_orgname, orgname, "error msg");
//			softassert.assertAll();

//			if(actual_orgname.equals(orgname)) 
//			{
//				System.out.println("TC Passed");	
//			}
//			else {
//				System.out.println("FAil");
//			}	

			homePage.logoutfromApp();

			driverUtils.closeBrowser();
		}

	}

