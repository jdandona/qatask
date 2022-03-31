package com.friday.qatask.pageactions;

import org.openqa.selenium.WebDriver;

import com.friday.qatask.PageDSL.PageHelper;



public class SelectEnginePage extends PageHelper implements CarDetail {

	WebDriver driver;

	public SelectEnginePage(WebDriver driver) {
		super(driver, "SelectEnginePage");
		this.driver = driver;
	}
	

	@Override
	public void SelectCriteria(String criteria) {
		click(element("button_Engine", criteria));
		
	}

}
