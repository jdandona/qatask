package com.friday.qatask.pageactions;

import org.openqa.selenium.WebDriver;

import com.friday.qatask.PageDSL.PageHelper;



public class SelectEnginePowerPage extends PageHelper implements CarDetail {

	WebDriver driver;

	public SelectEnginePowerPage(WebDriver driver) {
		super(driver, "SelectEnginePowerPage");
		this.driver = driver;
	}
	


	@Override
	public void SelectCriteria(String criteria) {
		click(element("button_EnginePower", criteria));
		
	}

}
