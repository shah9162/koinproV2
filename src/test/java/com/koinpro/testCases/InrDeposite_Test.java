package com.koinpro.testCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import com.koinpro.pageObjects.LoginPage;
import com.koinpro.pageObjects.kycPageLocators;

public class InrDeposite_Test extends BaseClass {
	String utr= RandomStringUtils.randomNumeric(7);
	
	@Test
	public void check_Inr_Deposite() throws InterruptedException, FindFailed {
		kycPageLocators kp = new kycPageLocators(driver);
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clicksignUp();
		Thread.sleep(6000);
		kp.clickInr();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.id("bank_acc")).sendKeys("200");
		driver.findElement(By.id("utr")).sendKeys(utr);
		driver.findElement(By.xpath("//span[normalize-space()='Upload File']")).click();
		UploadImage("AadharBack.jpg");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("svg[fill='currentColor'][class='bi bi-trash3 cursorPointer']")));
		driver.findElement(By.cssSelector("svg[fill='currentColor'][class='bi bi-trash3 cursorPointer']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Upload File']")).click();
		UploadImage("AadharBack.jpg");
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("svg[fill='currentColor'][class='bi bi-trash3 cursorPointer']")));
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(2000);

		if (driver.getPageSource().contains("Successfully Added Request.")) { // Complete KYC in order to deposit fiat
																				// INR.
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}
}

