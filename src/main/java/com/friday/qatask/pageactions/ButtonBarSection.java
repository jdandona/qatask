package com.friday.qatask.pageactions;

import org.openqa.selenium.WebDriver;

import com.friday.qatask.PageDSL.PageHelper;



public class ButtonBarSection extends PageHelper {

	WebDriver driver;

	public ButtonBarSection(WebDriver driver) {
		super(driver, "ButtonBarSection");
		this.driver = driver;
	}
	
	
	
	public void further() {
		click(element("button_further"));
	}
	
}
