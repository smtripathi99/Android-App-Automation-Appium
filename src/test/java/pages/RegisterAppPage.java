package test.java.pages;


import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.*;

import test.java.base.Base;
import test.java.util.ReadUIProperties;


public class RegisterAppPage {

	protected AndroidDriver<WebElement> driver;
	By permission=By.id(ReadUIProperties.getInstance().getValue("ALLOW_PERMISSION_BUTTON"));
	By email=By.id(ReadUIProperties.getInstance().getValue("SIGNUP_EMAIL_TEXTFIELD"));
	By signin=By.id(ReadUIProperties.getInstance().getValue("SIGNIN_BUTTON"));

	public RegisterAppPage(AndroidDriver<WebElement> driver) throws MalformedURLException {

			this.driver=driver;
	}

	public boolean AllowApp() {
		if ( driver.isLocked()) {
			// unlocked the device
			driver.swipe(10, 10, 20, 20, 2);
		}
		try {
			System.out.println("launching app in emulator...");
			driver.findElement(permission).click();
			Assert.assertTrue("Permission Granted", true);
			System.out.println(permission + " - passed");
			return true;
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return false;
	}
	
	public void registerApp(String emailAdd) {
			if (driver.isLocked()) {
				// unlocked the device
				driver.swipe(10, 10, 20, 20, 2);
			}
			try {
				driver.findElement(email).sendKeys(emailAdd);;
				driver.findElement(signin).click();
			} catch (Exception e) {

				System.out.println(e.getMessage());

			}
	}

	
}

