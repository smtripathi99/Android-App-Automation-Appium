package test.java.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.applitools.eyes.Eyes;
import io.appium.java_client.android.AndroidDriver;


public class Base {
	
	public static AndroidDriver<WebElement> driver;
	protected Eyes eyes;

	public void setUp() throws MalformedURLException {

		File appDir = new File(System.getProperty("user.dir"), "MyApp/app/build/outputs/apk");
		 
	    File app = new File(appDir, "MyApp.app");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
	    capabilities.setCapability(CapabilityType.VERSION, "6.0");
	    capabilities.setCapability(CapabilityType.PLATFORM, "Windows");	 
	    //tell Appium where the location of the app is
	    capabilities.setCapability("app", app.getAbsolutePath());
	    eyes=new Eyes();
        eyes.setApiKey("MY_API_KEY");
	    //create a RemoteWebDriver, the default port for Appium is 4723
	    driver = (AndroidDriver<WebElement>) new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	

	public WebElement findElement(By by) {
		try {
			WebElement element = driver.findElement(by);
			return element;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void WaitForPageToLoad(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10); // you can reuse this one
		isElementPresent(locator);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}



	public void getScreenShot(String Folder, String FileName) throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("screenshot\\" + Folder + "\\" + FileName + ".jpeg"));
	}

	public static WebElement waitForElementToAppear(WebDriver webDriver, String id) {
		WebDriverWait wait = new WebDriverWait(webDriver, 20);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}

	

}
