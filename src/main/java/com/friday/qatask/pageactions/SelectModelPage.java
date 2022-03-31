package com.friday.qatask.pageactions;

import org.openqa.selenium.WebDriver;

import com.friday.qatask.PageDSL.PageHelper;



public class SelectModelPage extends PageHelper implements CarDetail {

	WebDriver driver;

	public SelectModelPage(WebDriver driver) {
		
		super(driver, "SelectModelPage");
		System.out.println("Inside object creation of Model Page");
		
		this.driver = driver;
	}



	@Override
	public void SelectCriteria(String criteria) {
		click(element("button_carModel", criteria));
		
	}

}
