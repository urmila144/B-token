package com.AMAZON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortingOrder_RepeatedTest {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		 List<WebElement> se = driver.findElements(By.xpath("//select[@id='searchDropdownBox']//option"));
	
	TreeSet t=new TreeSet();
	for (WebElement opt : se) {
		String ddval=opt.getText();
		t.add(ddval);
	}

	System.out.println(t);
		
	}
	
}
