package com.practiesTESTNG;

import org.testng.annotations.Test;

public class GroupExcution_Test {

	@Test(groups="regressionTest")
	public void group() {
		System.out.println("Indian bank");
	}
	
	@Test(groups="smokeTest")
	public void group1() {
		System.out.println("SBI");
	}
	
	@Test(groups="regressionTest")
	public void group2() {
		System.out.println("Indian bank");
	}
	
	@Test(groups="regressionTest")
	public void group3() {
		System.out.println("SBI");
	}
}

