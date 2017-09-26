package suite;

import static org.hamcrest.MatcherAssert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainAppTest {

	WebDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		// Created object of DesiredCapabilities class.
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");

		/*desiredCapabilities.setCapability("platformVersion", "6.0.1");
		desiredCapabilities.setCapability("deviceName", "Kunal Parwani (Galaxy Note Edge)");*/
		 
		/*desiredCapabilities.setCapability("platformVersion", "7.1.1");
		desiredCapabilities.setCapability("deviceName", "Android Emulator");
		desiredCapabilities.setCapability("avd", "Pixel_XL_API_25");*/
		
		/*desiredCapabilities.setCapability("platformVersion", "8.0");
		desiredCapabilities.setCapability("deviceName", "Android Emulator");
		desiredCapabilities.setCapability("avd", "Nexus_5X_API_26");*/
		
		desiredCapabilities.setCapability("platformVersion", "6.0");
		desiredCapabilities.setCapability("deviceName", "Android Emulator");
		desiredCapabilities.setCapability("avd", "Nexus_6P_API_23");
		
		/*desiredCapabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		desiredCapabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");*/
		
		desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
		desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		desiredCapabilities.setCapability("noReset", true);

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new RemoteWebDriver(remoteUrl, desiredCapabilities);
	}


	@Test
	public void emulatorTest() {
		WebElement el1 = driver.findElement(By.id("com.android.calculator2:id/digit_9"));
		el1.click();
		WebElement el2 = driver.findElement(By.id("com.android.calculator2:id/op_add"));
		el2.click();
		WebElement el3 = driver.findElement(By.id("com.android.calculator2:id/digit_9"));
		el3.click();

		// Get result from result text box.
		String result = driver.findElement(By.id("com.android.calculator2:id/result")).getText();
		System.out.println("Number sum result is : " + result);
		assertThat("Result is not as expected", check(result));

	}

	public boolean check(String result) {
		if (result.equals("18")) {
			return true;
		} else {
			return false;
		}
	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}