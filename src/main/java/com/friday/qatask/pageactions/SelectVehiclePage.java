package com.friday.qatask.pageactions;

import org.openqa.selenium.WebDriver;

import com.friday.qatask.PageDSL.PageHelper;



public class SelectVehiclePage extends PageHelper implements CarDetail  {

	WebDriver driver;

	public SelectVehiclePage(WebDriver driver) {
		super(driver, "SelectVehiclePage");
		this.driver = driver;
	}

	@Override
	public void SelectCriteria(String criteria) {
		
		click(element("button_FindByMakeAndModel"));
		SendText(element("input_searchCarBrand"), criteria);
		click(element("button_carBrand", criteria.toUpperCase()));
		
	}
	
	
	

}
