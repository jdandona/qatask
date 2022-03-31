package com.friday.qatask.pageactions;

import org.openqa.selenium.WebDriver;

public class CarDetailFactory {

	private WebDriver driver;

	public CarDetailFactory(WebDriver driver) {
		this.driver = driver;
	}

	public CarDetail getCarDetailPageObject(String dataKey) {

		switch (dataKey) {
		case "selectVehicle":
			return new SelectVehiclePage(driver);
		case "selectModel":
			return new SelectModelPage(driver);
		case "selectFuelType":
			return new SelectFuelTypePage(driver);
		case "selectEnginePower":
			return new SelectEnginePowerPage(driver);
		case "selectEngine":
			return new SelectEnginePage(driver);
		case "selectBodyType":
			return new SelectBodyTypePage(driver);

		default:
			return null;
		}
	}

}
