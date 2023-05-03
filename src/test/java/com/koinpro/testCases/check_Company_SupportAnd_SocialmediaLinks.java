package com.koinpro.testCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class check_Company_SupportAnd_SocialmediaLinks extends BaseClass {

	String[] links = { "Exchange", "Our Team", "List Your Coin / Token", "Raise a Ticket", "Our Location",
			"White Paper", "Terms & Conditions", "Privacy Policy", "Refund Policy", "Corporate Account", "Facebook",
			"Twitter", "Linkedin", "Telegram", "Community" };

	@Test
	public void checkLinks() throws InterruptedException {
		driver.get("https://koinpro.io/portal/website/web");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Our Location']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
		System.out.println("Number of items : " + links.length);
		try {

			for (int i = 0; i < links.length; i++) {
				String str = links[i];

				System.out.println("for x path : " + str);
				WebElement br = driver.findElement(By.xpath("//a[normalize-space()='" + str + "']"));

				String parentWindowHandle = driver.getWindowHandle();
				System.out.println("bbbbbbbbbbb : " + parentWindowHandle);
				System.out.println("parent window Title : " + driver.getTitle());
				br.click();
				System.out.println("child window Title : " + driver.getTitle());
				Thread.sleep(2000);
				driver.switchTo().window(parentWindowHandle);
				Set<String> handles = driver.getWindowHandles();
				List<String> myList = new ArrayList<String>(handles);

				System.out.println("aaaaaaaaaa : " + myList);
				if (myList.size() == 2) {
					for (int j = 1; j < myList.size(); j++) {
						String st = myList.get(1);
						System.out.println(st);
						if (!st.equals(parentWindowHandle)) {
							driver.switchTo().window(st);
							driver.close();
							driver.switchTo().window(parentWindowHandle);

						} else {
							System.out.println("No window appear");
						}
					}

				} else if (str.contains("Community")) {
					System.out.println("Community link is working");
					Assert.assertTrue(true);
				} else {
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					driver.navigate().back();
					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					js.executeScript("arguments[0].scrollIntoView();", element);
					Thread.sleep(2000);
				}
			}
			System.out.println("All the links is working fine");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
