package com.VtigerTestCasess;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Generic.BaseClass;
import com.Generic.Fake_Data;
import com.ObjectRepo.ContactInfoPage;
import com.ObjectRepo.ContactOrg_popup;
import com.ObjectRepo.CreateContactPage;
import com.ObjectRepo.HomePage;
public class TC003_ContactWithOrgTest extends BaseClass
{

@Test(groups = "integration")
public void createcontactwithorgTest() throws InterruptedException, IOException 
{
	HomePage homePage = new HomePage(driver);
	
	HomePage.getContactslink().click();

	ContactInfoPage contactInfoPage = new ContactInfoPage(driver);
	contactInfoPage.getCreatecontactsimg().click();

	CreateContactPage  contactPage = new CreateContactPage(driver);

	Fake_Data fake_Data = new Fake_Data();
	String contactname=fake_Data.lastname();
	contactPage.getLastNameEdt().sendKeys(contactname);

	contactPage.getOrganizationLookUpImage().click();
	// window switching

	driverUtils.switchTowindow("Accounts");
	ContactOrg_popup org_popup = new ContactOrg_popup(driver);
	org_popup.searchandSelectforOrg("Mango");

	driverUtils.switchTowindow("Contact");

	contactPage.getSaveBtn().click();

	Thread.sleep(3000);
	homePage.getContactslink().click();

	//validation
	contactInfoPage.checkcontactcreated(contactname, "Last Name");

	Thread.sleep(3000);

	String fname=driver.findElement(By.xpath("//span[@vtfieldname='lastname']/..")).getText();

	Assert.assertEquals(fname, contactname);
	
}

@Test(groups="smoke")
public void createcontactTest() throws InterruptedException, IOException
{
	HomePage homePage = new HomePage(driver);
	homePage.getContactslink().click();

	ContactInfoPage contactInfoPage = new ContactInfoPage(driver);
	contactInfoPage.getCreatecontactsimg().click();

	CreateContactPage  contactPage = new CreateContactPage(driver);

	Fake_Data fake_Data = new Fake_Data();
	String contactname=fake_Data.lastname();
	contactPage.getLastNameEdt().sendKeys(contactname);
	
	contactPage.getSaveBtn().click();

	Thread.sleep(3000);
	homePage.getContactslink().click();

	contactInfoPage.checkcontactcreated(contactname, "Last Name");

	Thread.sleep(3000);

	String fname=driver.findElement(By.xpath("//span[@vtfieldname='lastname']/..")).getText();

	Assert.assertEquals(fname, contactname);
}
}
