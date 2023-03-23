package com.koinpro.testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.koinpro.pageObjects.ForgetPasswordLocators;
import com.koinpro.pageObjects.LoginPage;

public class ForgetPasswordTest extends BaseClass {

	String email = randomEmail();

	@Test
	public void ForgetPassword_Test001() throws InterruptedException, IOException {
		ForgetPasswordLocators fp = new ForgetPasswordLocators(driver);
		System.out.println("Forget password Email is : " + email);
		// signUp a new user
		RegisterUser(email);

		// email Verification
		verify_Newly_AddedCustomer(email);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.navigate().to(baseURL);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		logger.info("ulr is opened");
		fp.clickForgetLink();
//		logger.info("Forget password link clicked");
		fp.enterforgetemail(email);
//		logger.info("foget password email is provided");
		fp.clickGetLink();
//		logger.info("Get link is clecked");
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='cursorPointer']")));

		if (driver.getPageSource().contains("Reset Link send to your mail registered mail id.")) {
			System.out.println("link sent on registered mail id");
		} else {
			System.out.println("link sent on registered mail id");
		}

		driver.get("https://yopmail.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement emailbox = driver.findElement(By.id("login"));
		emailbox.sendKeys(email);
		emailbox.submit();

		try {
			Thread.sleep(4000); // 120,000 milliseconds = 2 minutes
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("total frame : " + size);

		driver.switchTo().frame(2);

		String link = driver.findElement(By.xpath("//a[normalize-space()='Reset My Password']")).getAttribute("href");
		System.out.println("url of the forget password :" + link);
		Thread.sleep(2000);

		driver.get(link);
		WebElement pass = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		pass.click();
		pass.sendKeys("Abc@12345");
		WebElement Con_pass = driver.findElement(By.xpath("//input[@placeholder='Confirm Password']"));
		Con_pass.click();
		Con_pass.sendKeys("Abc@12345");
		driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary btn-lg']")).click();
		Thread.sleep(2000);
		if (driver.getPageSource().contains("Password Reset")) {
			System.out.println("password reset success Now login with current password");
		} else {
			System.out.println("password reset failed");
		}

		String windows = driver.getWindowHandle();
		System.out.println("window handle value " + windows);
		if (driver.switchTo().window(windows).getTitle().contains("ifmail")) {
			driver.close();
		}

		// Again login to the Account with new password
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		lp.setUserName(email);
		lp.setPassword("Abc@12345");
		// lp.eyeButton();
		lp.clicksignUp();

		Thread.sleep(2000);

		if (driver.getPageSource().contains("Logged In Successfully.")) {
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void checkLogin_With_previousPassword() {
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		lp.setUserName(email);
		lp.setPassword("Abc@1234");
		// lp.eyeButton();
		lp.clicksignUp();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (driver.getPageSource().contains("Invalid Password")) {
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void ForgetPassword_Test002_Timecheck() throws InterruptedException, IOException {
		ForgetPasswordLocators fp = new ForgetPasswordLocators(driver);
		driver.get(baseURL);
//		logger.info("ulr is opened");
		fp.clickForgetLink();
//		logger.info("Forget password link clicked");
		fp.enterforgetemail(email);
//		logger.info("foget password email is provided");
		fp.clickGetLink();
//		logger.info("Get link is clecked");
		Thread.sleep(2000);
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		if (driver.getPageSource().contains("Link recently sent, try after sometime.")) {
			Assert.assertTrue(true);
//		logger.info("Forget password passed");
		} else {
//	    logger.info("Forget password failed");
			Assert.assertTrue(false);
		}

	}

	@Test
	public void ForgetPassword_Test003_NoUser() throws InterruptedException, IOException {
		ForgetPasswordLocators fp = new ForgetPasswordLocators(driver);
		driver.get(baseURL);
//		logger.info("ulr is opened");
		fp.clickForgetLink();
//		logger.info("Forget password link clicked");
		fp.enterforgetemail("mgdfddsd916288@gmail.com");
//		logger.info("foget password email is provided");
		fp.clickGetLink();
//		logger.info("Get link is clecked");
		Thread.sleep(2000);
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		if (driver.getPageSource().contains("No user found with this email.")) {
			Assert.assertTrue(true);
//		logger.info("Forget password passed");
		} else {
//	    logger.info("Forget password failed");

			Assert.assertTrue(false);
		}

	}

	@Test
	public void ForgetPassword_Test004_invalid_Email_Format() throws InterruptedException, IOException {
		ForgetPasswordLocators fp = new ForgetPasswordLocators(driver);
		driver.get(baseURL);
//		logger.info("ulr is opened");
		fp.clickForgetLink();
//		logger.info("Forget password link clicked");
		fp.enterforgetemail("mgdfddsd916288@gmail.123");
//		logger.info("foget password email is provided");
		fp.clickGetLink();
//		logger.info("Get link is clecked");
		Thread.sleep(2000);
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		if (driver.getPageSource().contains("Email is Invalid.")) {
			Assert.assertTrue(true);
//		logger.info("Forget password passed");
		} else {
//	    logger.info("Forget password failed");

			Assert.assertTrue(false);
		}

	}

}
