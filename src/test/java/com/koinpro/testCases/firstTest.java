package com.koinpro.testCases;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.koinpro.pageObjects.LoginPage;
import com.koinpro.utilities.ExtentManager;

public class firstTest extends BaseClass {
	
	@Test
	public void FirstTest001() throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		
	
		driver.get(baseURL);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.eyeButton();
		
		lp.clicksignUp();
		Thread.sleep(2000);
	
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
		String actualtitle = driver.getTitle();
		if(driver.getPageSource().contains("Logged In Successfully.")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	
	}
	
	@Test(enabled=false)
	public void secondTest001() {
		driver.get(baseURL);
		String actualtitle = driver.getTitle();
		if(actualtitle.contains("INR crypto currency exchange with Spot Trading123")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	
	}
	
	@Test
	public void sampleTest() {
		
		Assert.assertTrue(false);
		ExtentManager.test.createNode("validation1");
		Assert.assertTrue(true);
		ExtentManager.test.createNode("validation2");
		Assert.assertTrue(true);
		ExtentManager.test.createNode("validation3");
		Assert.assertTrue(true);
		ExtentManager.test.createNode("validation4");
		Assert.assertTrue(true);
	}

}
