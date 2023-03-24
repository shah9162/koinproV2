package com.koinpro.testCases;

import com.koinpro.pageObjects.LoginPage;
import com.koinpro.pageObjects.kycPageLocators;

public class Bank_VerifyTest extends BaseClass {
	public void bankVerfication01() {
		kycPageLocators kp = new kycPageLocators(driver);
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clicksignUp();
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
