package com.friday.qatask.pageactions;

import org.openqa.selenium.WebDriver;

import com.friday.qatask.PageDSL.PageHelper;



public class SelectBodyTypePage  extends PageHelper implements CarDetail {

	WebDriver driver;

	public SelectBodyTypePage(WebDriver driver) {
		super(driver, "SelectBodyTypePage");
		this.driver = driver;
	}


	@Override
	public void SelectCriteria(String criteria) {
		
		click(element("button_bodyType", criteria));
	}

}
