package com.friday.qatask.TestInitiator;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private String browser;

	public WebDriver getDriver(String browser) {
		this.browser = browser;
		System.out.println(browser);

		try {
			if (this.browser.equalsIgnoreCase("firefox")) {
				return getFirefoxDriver();
			}

			else if (this.browser.equalsIgnoreCase("Chrome")) {
				return getChromeDriver();
			}
		} catch (Exception e) {
			return getChromeDriver();
		}

		return getChromeDriver();

	}

	private WebDriver getChromeDriver() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("--dns-prefetch-disable");
		options.addArguments("disable-infobars");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cap);

		return new ChromeDriver(options);
	}

	private static WebDriver getFirefoxDriver() {

		WebDriverManager.firefoxdriver().setup();

		return new FirefoxDriver();

	}

}
