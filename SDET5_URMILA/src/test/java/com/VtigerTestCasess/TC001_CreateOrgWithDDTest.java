package com.VtigerTestCasess;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Generic.BaseClass;
import com.Generic.PropFile_Util;
import com.ObjectRepo.CreateNewOrgPage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.OrgINfoPAge;


public class TC001_CreateOrgWithDDTest extends BaseClass{

	@Test(groups="smoke")
	public void createorgwithDDTest() throws InterruptedException, IOException 
	{
		HomePage homePage = new HomePage(driver);
		homePage.getOrglink().click();

		OrgINfoPAge orgINfoPAge = new  OrgINfoPAge(driver);
		orgINfoPAge.getCreateorgbtn().click();

		CreateNewOrgPage newOrgPage = new CreateNewOrgPage(driver);
		String orgname=data.getOrgname();
		newOrgPage.getorgnametxtbox().sendKeys(orgname);

		driverUtils.selectValuefromDD(newOrgPage.getIndustry(), "Chemicals");
		driverUtils.selectValuefromDD(newOrgPage.getRating(), "Active");
		driverUtils.selectValuefromDD(newOrgPage.getType(), "Customer");

		newOrgPage.getSaveorgbtn().click();
		Thread.sleep(3000);

		homePage.getOrglink().click();

		orgINfoPAge.searchforOrg(orgname, "accountname");

		Thread.sleep(3000);
		//String title = driver.getTitle();

		String actual_orgname=	driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		Assert.assertEquals(actual_orgname,"orgname");

		//logout vtigercrm

		homePage.logoutfromApp();

		driverUtils.closeBrowser();

	}

}
