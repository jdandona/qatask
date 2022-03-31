package com.friday.qatask.tests;

import java.lang.reflect.Method;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.friday.qatask.TestInitiator.TestInitiator;
import com.friday.qatask.pageactions.ButtonBarSection;
import com.friday.qatask.pageactions.CarDetailController;
import com.friday.qatask.pageactions.EnterBirthDatePage;
import com.friday.qatask.pageactions.EnterRegistrationDatePage;
import com.friday.qatask.pageactions.SelectPreconditionPage;
import com.friday.qatask.pageactions.SelectRegisteredOwnerPage;
import com.friday.qatask.utilities.DataProvider;

import static com.friday.qatask.utilities.YamlReader.*;

public class ThreeCarBrands_EachBrandThreeDifferentCar_Test {

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

	@Test(dataProvider = "ThreeCarBrandsEachBrandThreeDifferentCar", dataProviderClass = DataProvider.class)
	public void Test01_Quotes_ThreeCarbRands_EachBrandThreeDifferentCars(Map<String, Object> map) {
		test = new TestInitiator(browser);
		test.launchApplication((getYamlValue("Url")));
		SelectPreconditionPage selectPreConditionPage = test.getScreenObject().getSelectPreconditionPage();

		selectPreConditionPage.AcceptCookies();
		selectPreConditionPage.theCarWillStillBeRegistered_Or_Reregistered();
		selectPreConditionPage.enterInceptionDate((getYamlValue("QuoteSelection.inceptionDate")));

		ButtonBarSection buttonBarSection = test.getScreenObject().getButtonBarSection();
		buttonBarSection.further();

		SelectRegisteredOwnerPage selectRegisteredOwnerPage = test.getScreenObject().getRegisteredOwnerPage();
		selectRegisteredOwnerPage.carRegistered_Yes();
		selectRegisteredOwnerPage.theCarIsNew();
		buttonBarSection.further();

		CarDetailController carDetailController = test.getScreenObject().getCarDetailController();
		carDetailController.selectCarDeatils(map);

		EnterRegistrationDatePage registrationDatePage = test.getScreenObject().getRegistrationDatePage();
		registrationDatePage.enterRegistrationDate((getYamlValue("QuoteSelection.registrationDate")));
		buttonBarSection.further();

		EnterBirthDatePage birthDatePage = test.getScreenObject().getBirthDatePage();
		Assert.assertTrue(birthDatePage.IsUserPresentOnEnterDateOfBirthPage(), "User is not on Birth Date Page");

	}

	@AfterMethod
	public void close() {
		test.closeBrowserSession();
	}

}
