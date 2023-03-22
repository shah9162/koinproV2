package com.koinpro.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.koinpro.pageObjects.LoginPage;
import com.koinpro.utilities.ExtentManager;
import com.koinpro.utilities.ListenerClass;
import com.koinpro.utilities.XLUtils;

public class LoginTest extends BaseClass {
	

	public static String path = System.getProperty("user.dir")
			+ "/src/test/java/com/koinpro/testData/Koinpro_Testcases.xlsx";

	@Test
	public void TC_LoginTest_001() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		lp.setUserName("msd916288@gmail.com");
		lp.setPassword("Abc@1234");
		//		lp.eyeButton();
		lp.clicksignUp();

		Thread.sleep(2000);
	
		if (driver.getPageSource().contains("Logged In Successfully.")) {
			Assert.assertTrue(true);
			
		} else {
			Assert.assertTrue(false);
		}
	
//	ExtentManager.test.createNode("login with invalid password");
    
	}
	

	@Test
	public void TC_LoginTest_002() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		lp.setUserName("msd916288@gmail.com");
		lp.setPassword("Abc@5248");
		//		lp.eyeButton();
		lp.clicksignUp();

		Thread.sleep(2000);

		if (driver.getPageSource().contains("Invalid Password")) {
			
			Assert.assertTrue(true);
		} else {
		   Assert.assertTrue(false);
		}

	}

	@Test
	public void TC_LoginTest_003() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		lp.setUserName("msd5416288@gmail.com");
		lp.setPassword("Abc@1234");
		//		lp.eyeButton();
		lp.clicksignUp();

		Thread.sleep(2000);

		if (driver.getPageSource().contains("No user exists with this email.")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@Test
	public void TC_LoginTest_004() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		lp.setUserName("msd5416288@gmail.123");
		lp.setPassword("Abc@1234");
		//		lp.eyeButton();
		lp.clicksignUp();

		Thread.sleep(2000);

		if (driver.getPageSource().contains("Email is Invalid.")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@Test
	public void TC_LoginTest_005() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		lp.setUserName("msd916288@gmail.com");
		lp.setPassword("abc@123");
		//		lp.eyeButton();
		lp.clicksignUp();

		Thread.sleep(3000);

		if (driver.getPageSource().contains("Invalid Password")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@Test
	public void TC_LoginTest_006() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		lp.setUserName("");
		lp.setPassword("Abc@1234");
		//		lp.eyeButton();
		lp.clicksignUp();

		Thread.sleep(2000);

		if (driver.getPageSource().contains("Email is empty.")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@Test
	public void TC_LoginTest_007() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		lp.setUserName("msd916288@gmail.com");
		lp.setPassword("");
		//		lp.eyeButton();
		lp.clicksignUp();

		Thread.sleep(2000);

		if (driver.getPageSource().contains("Password is empty.")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

}
