package com.koinpro.testCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import com.koinpro.pageObjects.LoginPage;
import com.koinpro.pageObjects.kycPageLocators;

public class kycUpdate extends BaseClass{
	 String Email =	randomEmail();
	 
	@Test
	public void kycVerification001() throws InterruptedException, FindFailed {
		kycPageLocators kp = new kycPageLocators(driver);
		LoginPage lp = new LoginPage(driver);
	   
	    RegisterUser(Email);
	    verify_Newly_AddedCustomer(Email);
	
		
		driver.navigate().to(baseURL);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		lp.setUserName(Email);
		lp.setPassword(password);
		lp.clicksignUp();
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Thread.sleep(2000);
		kp.clicksetting();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		kp.clickKyc_Link();
	
		if(driver.findElement(By.xpath("//div[@class='card ng-star-inserted']")).getText().contains("Complete user details section in order to start KYC!!!")) {
			System.out.println("Complete user details section in order to start KYC!!! ");
			kp.clickProfile_Link();
		}
		else {
			System.out.println("there is some problem with script");
		};
		
		//fill profile section
		kp.enterAddress("Gomti nagar");
		kp.enterPincode("226010");
		kp.enterCity("Lucknow");
		kp.enterCounter("India");
		kp.enterState("UP");
		kp.clickSaveProfileButton();
		
		if(driver.getPageSource().contains("Details Successfully Updated.")) {
			System.out.println("Profile details updated successfully noe start doing kyc mannual or E-Kyc");
			}
		
		kp.clickKyc_Link();
		kp.clickManualKyc();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		System.out.println("Manual kuc page is now Opening");
		
		kp.uploadpancard();
		System.out.println("upload pan is clicked");
		UploadImage("pancard.jpg");
		
		 
		kp.uploadAadharFront();
		System.out.println("upload aadhar front is clicked");
	    UploadImage("AadharFront.jpg");
	    
	    kp.uploadAadharback();
	    System.out.println("upload aadhar back is clicked");
	    UploadImage("AadharBack.jpg");
	    
	    kp.uploadImage();
	    System.out.println("upload image is clicked");
	    UploadImage("Image01.png");
	  
	    kp.enterPancardNumber();
	    System.out.println("pan number entered");
	      
	    kp.enterAadharnumber();
	    System.out.println("Aadhar entered");
	    Thread.sleep(6000);
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,300)");

	    Thread.sleep(1000);
//	    kp.clickSubmitButton();
	     driver.findElement(By.cssSelector("button.button[type=button]")).click();;
	   
	    Thread.sleep(2000);
//	     driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		
	    if(driver.findElement(By.xpath("//div[@class='card-body my-cus']")).getText().contains("KYC verification is in progress !!!")) {
	    	Assert.assertTrue(true);
	    }
	    else {
	    	Assert.assertTrue(false);
	    }
	
	}
	
	@Test
	public void kycVerification002_rejectionInAdmin() throws InterruptedException, FindFailed {
		kycPageLocators kp = new kycPageLocators(driver);
		LoginPage lp = new LoginPage(driver);
	    driver.get(baseURL);
		lp.setUserName("aniketjaiswal094@gmail.com");
		lp.setPassword("MarijuanaPed09xx#");
		lp.clicksignUp();
		Thread.sleep(4000);
		kp.clickAllKyc();
		Thread.sleep(2000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Search here...')]")));
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search here...')]")).sendKeys(Email);
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Reject']")).click();
		String str = " it is for testing purpose";
		driver.findElement(By.xpath("//input[@placeholder='Rejection Reason']")).sendKeys(str);
		driver.findElement(By.xpath("//label[normalize-space()='Pan']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-danger'][normalize-space()='Reject']")).click();
		Thread.sleep(2000);
		
		if(driver.findElement(By.xpath("//td[normalize-space()='REJECTED']")).getText().contains("REJECTED")){
		    Assert.assertTrue(true);
			System.out.println("kyc rejected due to"+str);
		}
		else {
			Assert.assertTrue(false);
			System.out.println("There is issue with kyc rejection in Admin portal");
		}
	}
	
	@Test
	public void kycVerification003_Re_UploadPan() throws InterruptedException, FindFailed {
		kycPageLocators kp = new kycPageLocators(driver);
		LoginPage lp = new LoginPage(driver);
		
		driver.get(baseURL);
		lp.setUserName(Email);
		lp.setPassword("Abc@1234");
		lp.clicksignUp();
		Thread.sleep(2000);
		kp.clicksetting();
		kp.clickKyc_Link();
		kp.reupload_uploadpancard();
		System.out.println("upload pan is clicked");
		UploadImage("pancard.jpg");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button.button[type=button]")).click();
		Thread.sleep(2000);
		
		   if(driver.findElement(By.xpath("//div[@class='card-body my-cus']")).getText().contains("KYC verification is in progress !!!")) {
		    	Assert.assertTrue(true);
		    }
		    else {
		    	Assert.assertTrue(false);
		    }
	}
	
	@Test
	public void kycVerification004_rejectionInAdmin() throws InterruptedException, FindFailed {
		kycPageLocators kp = new kycPageLocators(driver);
		LoginPage lp = new LoginPage(driver);
	    driver.get(baseURL);
		lp.setUserName("aniketjaiswal094@gmail.com");
		lp.setPassword("MarijuanaPed09xx#");
		lp.clicksignUp();
		Thread.sleep(4000);
		kp.clickAllKyc();
		Thread.sleep(2000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Search here...')]")));
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search here...')]")).sendKeys(Email);
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Reject']")).click();
		String str = " it is for testing purpose";
		driver.findElement(By.xpath("//input[@placeholder='Rejection Reason']")).sendKeys(str);
		driver.findElement(By.xpath("//label[normalize-space()='Pan']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-danger'][normalize-space()='Reject']")).click();
		Thread.sleep(2000);
		
		if(driver.findElement(By.xpath("//td[normalize-space()='REJECTED']")).getText().contains("REJECTED")){
		    Assert.assertTrue(true);
			System.out.println("kyc rejected due to"+str);
		}
		else {
			Assert.assertTrue(false);
			System.out.println("There is issue with kyc rejection in Admin portal");
		}
	}
	
	
	@Test
	public void kycVerification005_UploadWrongImage() throws InterruptedException, FindFailed {
		kycPageLocators kp = new kycPageLocators(driver);
		LoginPage lp = new LoginPage(driver);
		driver.navigate().to(baseURL);
		lp.setUserName(Email);
		lp.setPassword("Abc@1234");
		lp.clicksignUp();
		Thread.sleep(2000);
		kp.clicksetting();
		kp.clickKyc_Link();
		kp.reupload_uploadpancard();
		System.out.println("upload pan is clicked");
		UploadImage("kids_wear.jpg");
		Thread.sleep(2000);
		System.out.println("There is some issue with the image");
//		driver.findElement(By.cssSelector("button.button[type=button]")).click();
//		Thread.sleep(2000);
		
		   if(driver.getPageSource().contains("Failed to upload Image.")) {
		    	Assert.assertTrue(true);
		    	}
		    else {
		    	Assert.assertTrue(false);
		    }
	}

}
