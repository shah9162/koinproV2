package com.koinpro.testCases;

import org.testng.annotations.Test;

import com.koinpro.pageObjects.SignUp;

public class SignupTest extends BaseClass{
	
	@Test
	public void TC_SignUpTest_001() throws InterruptedException {
		driver.get(signUpURL);
		SignUp su = new SignUp(driver);
		su.setName("test");
		su.setEmail("test02528@gmail.com");
		su.setMobile("9162889450");
		su.setpassword("Abc@1234");
		System.out.println("before term");
//	Thread.sleep(2000);
		su.clickTermndCondition();
		System.out.println("after term");
		su.clickSignUp();
		System.out.println("signUp success");
	}

}
