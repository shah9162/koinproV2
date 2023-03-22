package com.koinpro.pageObjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath= "//input[contains(@type,'email')]")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(xpath= "//input[contains(@name,'password')]")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[contains(@type,'submit')]")
	@CacheLookup
	WebElement btnLogin;	
	
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement subMenu;
	
	@FindBy(xpath="//a[@class='nav-link dropdown-toggle']")
	@CacheLookup
	WebElement mainMenu;
	
	@FindBy(linkText="Login")
	@CacheLookup
	WebElement Login;
	
	
	@FindBy(linkText="Logout (All Devices)")
	@CacheLookup
	WebElement logoutAll;
	
	public void setUserName(String uname) {
		txtUserName.clear();
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.clear();
        txtPassword.sendKeys(pwd);	
	}
	  
	
	public void clicksignUp() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		Actions actions = new Actions(ldriver);
		actions.click(mainMenu).perform();
		actions.moveToElement(subMenu).click().perform();
		}
	
	public void clickLogin() {
		Login.click();
	}
	
	public void eyeButton() {
		Actions action = new Actions(ldriver);
		WebElement Eye = ldriver.findElement(By.xpath("//*[local-name()='svg' and @class='feather feather-eye']"));
		action.moveToElement(Eye).click().perform();
	}
	
	public void clicklogoutAll() {
		Actions actions = new Actions(ldriver);
		actions.click(mainMenu).perform();
		actions.moveToElement(logoutAll).click().perform();
	}
	

	
}

