package com.koinpro.testCases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.koinpro.pageObjects.LoginPage;
import com.koinpro.pageObjects.kycPageLocators;

public class Bank_VerifyTest extends BaseClass {
	@Test
	public void bankVerfication01() throws InterruptedException {
		kycPageLocators kp = new kycPageLocators(driver);
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clicksignUp();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		kp.clicksetting();
		kp.clickBankVerify_Link();
		String[] stt = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
				"t", "u", "v", "w", "x", "y", "z", "payment", "india" };
		List<String> stringList = new ArrayList<>();
		for (int j = 0; j < stt.length; j++) {
			String stt1 = stt[j];
			System.out.println(stt1);
			System.out.println("now you can verfy your bank Account for deposit or withdrawal purpose");
			driver.findElement(By.id("typeahead-format")).sendKeys(stt1);
			Thread.sleep(2000);
			List<WebElement> bankName = driver
					.findElements(By.xpath("//button[@class='dropdown-item ng-star-inserted']"));
			System.out.println(bankName.size());

			for (int i = 0; i < bankName.size(); i++) {
				String bank = bankName.get(i).getText();
				stringList.add(bank);
//				System.out.println(bank);
			}
			driver.findElement(By.id("typeahead-format")).clear();
			Thread.sleep(2000);
		}
		Set<String> uniqueStrings = new HashSet<>(stringList);
		List<String> uniqueList = new ArrayList<>(uniqueStrings);

		System.out.println("--------------------------------------------------------------------");

		for (String printBank : uniqueList) {
			System.out.println(printBank);
		}
		System.out.println("--------------------------------------------------------------------");

		for (int k = 0; k < 2; k++) {
			String element = uniqueList.get(k);
			WebElement bankName = driver.findElement(By.id("typeahead-format"));
			bankName.clear();
			bankName.sendKeys(element);
			bankName.sendKeys(Keys.ENTER);
			WebElement Account = driver.findElement(By.xpath("//input[@placeholder='Account Number']"));
			Account.clear();
			Account.sendKeys("9182101839");

			WebElement confirmAccount = driver.findElement(By.xpath("//input[@placeholder='Re Account Number']"));
			confirmAccount.clear();
			confirmAccount.sendKeys("9182101839");

			WebElement ifsc = driver.findElement(By.xpath("//input[@placeholder='Ifsc']"));
			ifsc.clear();
			ifsc.sendKeys("PYTM0123456");

			WebElement submit = driver.findElement(By.xpath("//button[@class='button lgeLPf']"));
			submit.click();
			Thread.sleep(4000);
			if (driver.getPageSource().contains("Invalid Beneficiary Bank Account number")
					|| driver.getPageSource().contains("bankName is required")) {
				System.out.println("Bank verificatio failed with Bank name : "+element);
				Assert.assertTrue(true);
			}

			else {
				Assert.assertTrue(false);
			}
			Thread.sleep(2000);

		}

//Invalid Beneficiary Details
//We have sent Rs 1 in Your Bank Account With UTR NO 308****504. Please check your Statement and enter complete UTR to Verify your Bank Account
	}

}
