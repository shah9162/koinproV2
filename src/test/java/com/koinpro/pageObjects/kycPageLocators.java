package com.koinpro.pageObjects;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class kycPageLocators {
	WebDriver mdriver;
	public kycPageLocators(WebDriver rdriver){
		mdriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Profile']")
	@CacheLookup
	WebElement mainMenu; // 
	
	@FindBy(xpath="//a[normalize-space()='Wallet']")
	@CacheLookup
	WebElement wallet;
	
	@FindBy(xpath="//li[contains(a/text(),'INR')]")
	@CacheLookup
	WebElement inr;
	
	@FindBy(xpath="//a[normalize-space()='Users']")
	@CacheLookup
	WebElement Users;
	
	@FindBy(xpath="//a[normalize-space()='All Kyc']")
	@CacheLookup
	WebElement AllKyc;
	
	@FindBy(xpath="//a[normalize-space()='Setting']")
	@CacheLookup
	WebElement subMenu;
	
	@FindBy(xpath="//span[normalize-space()='Verify KYC']")
	@CacheLookup
	WebElement kyclink;
	
	@FindBy(xpath="//span[normalize-space()='Bank Verify']")
	@CacheLookup
	WebElement bankVerify;
	
	@FindBy(xpath="//span[normalize-space()='PROFILE']")
	@CacheLookup
	WebElement profileLink;
	
	@FindBy(xpath="//button[@class='cursorPointer btn btn-outline-primary btn-sm mr-4 active']")
	@CacheLookup
	WebElement MannualKyc;
	
	@FindBy(xpath="//input[contains(@placeholder, 'Name')]")
	@CacheLookup
	WebElement name;
	
	@FindBy(xpath="//input[contains(@placeholder, 'Email id')]")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath="//input[contains(@placeholder, 'Address')]")
	@CacheLookup
	WebElement address;
	
	@FindBy(xpath="//input[contains(@placeholder, 'PostCode')]")
	@CacheLookup
	WebElement pincode;
	
	@FindBy(xpath="//input[contains(@placeholder, 'City')]")
	@CacheLookup
	WebElement city;
	
	@FindBy(xpath="//input[contains(@placeholder, 'country')]")
	@CacheLookup
	WebElement country;
	
	@FindBy(xpath="//input[contains(@placeholder, 'state')]")
	@CacheLookup
	WebElement state;
	
	@FindBy(xpath="//button[contains(@class, 'button lgeLPf')]")
	@CacheLookup
	WebElement saveProfile;
	
	@FindBy(xpath="//div[@class='card-body my-cus']//div[1]//div[1]//div[1]//span[1]")
	@CacheLookup
	WebElement pancard;
                	
	@FindBy(xpath="//span[@class='input-group-text bg-danger cursorPointer']")
	@CacheLookup
	WebElement reuploadpancard;
	
	
	@FindBy(xpath="//input[contains(@placeholder,'Enter Pan Number.')]")
	@CacheLookup
	WebElement pancardText;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/app-root/div/app-profile-base/app-profile-view-base/div[1]/div/div/div[2]/div/div/div/div/div/div/div[2]/app-kyc-base/app-kyc/div/div[2]/div/div/div/div[2]/div/div/span")
	@CacheLookup
	WebElement aadharFront;
	
	@FindBy(xpath="//input[contains(@placeholder,'Enter Aadhaar Number.')]")
	@CacheLookup
	WebElement aadharText;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/app-root/div/app-profile-base/app-profile-view-base/div[1]/div/div/div[2]/div/div/div/div/div/div/div[2]/app-kyc-base/app-kyc/div/div[2]/div/div/div/div[3]/div/div/span")
	@CacheLookup
	WebElement aadharBack;
	
	@FindBy(xpath="//*[@id=\"main-wrapper\"]/app-root/div/app-profile-base/app-profile-view-base/div[1]/div/div/div[2]/div/div/div/div/div/div/div[2]/app-kyc-base/app-kyc/div/div[2]/div/div/div/div[5]/div/div/span")
	@CacheLookup
	WebElement image;
	
	@FindBy(css="button.button[type=button]")
	@CacheLookup
	WebElement sumbmit;
	//button[@class='button']
	
	public void clicksetting() {
		Actions actions = new Actions(mdriver);
		actions.moveToElement(mainMenu).perform();
		subMenu.click();
	}
	
	public void clickInr() {
		Actions actions = new Actions(mdriver);
		actions.moveToElement(wallet).perform();
		inr.click();
	}
	
	public void clickAllKyc() {
		Actions actions = new Actions(mdriver);
		actions.moveToElement(Users).perform();
		AllKyc.click();
	}
	
	public void clickKyc_Link() {
		kyclink.click();
	}
	
	public void clickBankVerify_Link() {
		bankVerify.click();
	}
	
	public void clickManualKyc() {
		MannualKyc.click();
	}
	
	public void clickProfile_Link() {
		profileLink.click();
	}
	
	
	public void enterName(String Name) {
		name.clear();
	     name.sendKeys(Name);
	}
	
	public void enterAddress(String Address) {
		address.clear();
	     address.sendKeys(Address);
	}
	
	public void enterPincode(String Pincode) {
		pincode.clear();
	     pincode.sendKeys(String.valueOf(Pincode));
	}
	
	public void enterCity(String City) {
		city.clear();
	
	     city.sendKeys(City);
	}
	
	public void enterCounter(String Country) {
		country.clear();
	     country.sendKeys(Country);
	}
	
	public void enterState(String State) {
		state.clear();
	     state.sendKeys(State);
	}
	
	public void clickSaveProfileButton() {
		saveProfile.click();
	}
	
	//
	public void uploadpancard() {
		pancard.click();
	}
	
	public void reupload_uploadpancard() {
		reuploadpancard.click();
	}
	
	public void enterPancardNumber() {
		pancardText.clear();
		String generatedstring=	RandomStringUtils.randomAlphabetic(5);
		String generatedNumber = RandomStringUtils.randomNumeric(4);
		String panNumber=generatedstring+generatedNumber+"M";
		pancardText.sendKeys(panNumber);
	}
	
	public void uploadAadharFront() {
		aadharFront.click();
	}
	
	public void enterAadharnumber() {
		 aadharText.clear();
		 String generatedAdharNumber = RandomStringUtils.randomNumeric(12);
		 aadharText.sendKeys(generatedAdharNumber);
	}
	
	public void uploadAadharback() {
		aadharBack.click();
	}
	
	public void uploadImage() {
		 image.click();
	}
	
	 public void clickSubmitButton() {
		 sumbmit.click();
	 }
	

}
