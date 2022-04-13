package com.practiesTESTNG;

import org.testng.annotations.Test;

public class GroupExcution1_Test {

	@Test(groups="regressionTest")
	public void group() {
		System.out.println("Indian bank");
	}
	
	@Test(groups="smokeTest")
	public void group1() {
		System.out.println("KVC bank");
	}
	
	@Test(groups="regressionTest")
	public void group2() {
		System.out.println("ICIC bank");
	}
	
	@Test(groups="regressionTest")
	public void group3() {
		System.out.println("SBI");
	}
}
