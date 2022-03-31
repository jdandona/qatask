package com.friday.qatask.tests;

import static com.friday.qatask.utilities.YamlReader.getYamlValue;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.friday.qatask.TestInitiator.TestInitiator;
import com.friday.qatask.pageactions.SelectPreconditionPage;

public class FailureTestToCheckScreenShotOnFailure {
	
	TestInitiator test;
	String browser;

	@Parameters("browser")
	@BeforeClass
	public void Start_Test_Session(@Optional String browser) {
		this.browser = browser;
	}

	@BeforeMethod
	public void handleTestMethodName(Method method) {

		Reporter.log("Starting test " + method.getName(), true);

	}
	
	
	@Test
	public void Test01_LaucnhApplicationAndVerifyText() {
		test = new TestInitiator(browser);
		test.launchApplication((getYamlValue("Url")));
		SelectPreconditionPage selectPreConditionPage = test.getScreenObject().getSelectPreconditionPage();
		selectPreConditionPage.AcceptCookies();
		Assert.assertTrue(selectPreConditionPage.verifyTiTleText("Enter text to fail the test case"));
		
	}

}
