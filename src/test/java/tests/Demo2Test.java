package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.DriverManager;

public class Demo2Test extends BaseTest{
	
	@Test(enabled = false)
	public void navigateToTestNGPage() {
		DriverManager.getDriver().navigate().to("https://testng.org/doc/");
		Assert.assertTrue(false);
	}
	
	@Test(enabled = true)
	public void navigateToGooglePage() {
		DriverManager.getDriver().navigate().to("https://www.google.com/");
		Assert.assertTrue(false);
	}
}
