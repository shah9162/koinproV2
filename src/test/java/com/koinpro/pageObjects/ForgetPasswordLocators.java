package com.koinpro.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordLocators {
WebDriver ldriver;
	
	public ForgetPasswordLocators(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//*[@class='cursorPointer']")
	@CacheLookup
	WebElement forgetPassword;
	
	@FindBy(id="forgot-password-email")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath="//button[@class='btn-md btn-theme w-100']")
	@CacheLookup
	WebElement GetLink;
	
	@FindBy(linkText="Resend")
	@CacheLookup
	WebElement ResendLink;
	
	
	
	public void clickForgetLink() {
		forgetPassword.click();
	}
	
	public void enterforgetemail(String email) {
		txtpassword.sendKeys(email);
	}
	
	public void clickGetLink() {
		GetLink.click();
	}
	
	public void clickResendLink() {
		ResendLink.click();
	}
	


}
