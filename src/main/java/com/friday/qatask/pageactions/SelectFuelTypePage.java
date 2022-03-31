package com.friday.qatask.pageactions;

import org.openqa.selenium.WebDriver;

import com.friday.qatask.PageDSL.PageHelper;



public class SelectFuelTypePage extends PageHelper implements CarDetail {

	WebDriver driver;

	public SelectFuelTypePage(WebDriver driver) {
		super(driver, "SelectFuelTypePage");
		this.driver = driver;
	}



	@Override
	public void SelectCriteria(String criteria) {
		click(element("button_fuelType", criteria));
		
	}

}
