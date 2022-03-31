package com.friday.qatask.TestInitiator;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import static com.friday.qatask.utilities.YamlReader.*;

import java.time.Duration;

public class TestInitiator {

	protected WebDriver driver;
	private final DriverFactory driverFactory;
	private PageObjectProvider pageObjectProvider;

	public TestInitiator(String browser) {
		setYamlFilePath();
		driverFactory = new DriverFactory();
		_configureBrowser(browser);
		pageObjectProvider = new PageObjectProvider(driver);

	}

	private void _configureBrowser(String browser) {

		driver = driverFactory.getDriver(browser);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	public PageObjectProvider getScreenObject() {
		return pageObjectProvider;
	}

	public void launchApplication(String baseurl) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		try {
			driver.get(baseurl);
		} catch (TimeoutException exp) {
			driver.navigate().refresh();
		}

	}

	public void closeBrowserSession() {

		driver.quit();
		Reporter.log("Browser closed", true);

	}
	
	public WebDriver getDriver() {
		return this.driver;
	}

}
