package com.friday.qatask.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.friday.qatask.TestInitiator.TestInitiator;

public class TakeScreenShot implements ITestListener {

	WebDriver driver = null;
	String filePath = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "screenShots";

	@Override
	public void onTestFailure(ITestResult result) {
		Field field;
		String methodName = result.getName().toString().trim();
		try {
			field = result.getTestClass().getRealClass().getDeclaredField("test");
			field.setAccessible(true);
			TestInitiator testSessionInitiator;
			// MobileTestSessionInitiator testSessionInitiator;
			try {
				testSessionInitiator = (TestInitiator) field.get(result.getInstance());
				driver = testSessionInitiator.getDriver();

			} catch (IllegalArgumentException | IllegalAccessException e) {
				System.out.println("Exception while accessing driver associated with current class ");
				e.printStackTrace();
				Reporter.log("Exception while accessing driver associated with current class " + e.getMessage());
			}

		} catch (NoSuchFieldException | SecurityException e1) {
			System.out.println("Exception while accessing fields of current class ");
			e1.printStackTrace();
			Reporter.log("Exception while accessing fields of current class " + e1.getMessage());
		}
		takeScreenShot(methodName, driver);
	}

	public void takeScreenShot(String methodName, WebDriver driver) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFileToDirectory(scrFile, new File(filePath));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
