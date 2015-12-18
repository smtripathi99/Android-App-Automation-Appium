package test.java.tests;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.applitools.eyes.MatchLevel;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import test.java.base.Base;
import test.java.pages.RegisterAppPage;
import test.java.util.ReadUIProperties;


public class RegisterAppTest extends Base {

	public RegisterAppTest() throws MalformedURLException {
		super();
		// TODO Auto-generated constructor stub
	}

	private AndroidDriver<WebElement> driver;
	private RegisterAppPage regapp = new RegisterAppPage(driver);;

	@Title("App Permission Check")
	@Description("This test is for Permission Check")
	// @Test
	public void AllowAppPermission() {

		Assert.assertTrue("Permission on App allowed", regapp.AllowApp());
		// saveImageAttach("Image attach");

	}

	@Test
	public void AppVisual() {
		try {
			// Start visual testing
			// Visual validation point #1
			eyes.setMatchLevel(MatchLevel.EXACT);
			eyes.checkWindow("Initial view");
			eyes.close();
		} finally {
			eyes.abortIfNotClosed();
		}
	}

	@Test
	public void RegisterApp() {

		regapp.registerApp("snehmani.tripathi@infogain.com");
	}

	@After
	public void teardown() {

		if (driver != null) {
			// driver.closeApp();
			// driver.close();
			driver.quit();
		}
	}
}
