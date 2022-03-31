package com.friday.qatask.pageactions;

import org.openqa.selenium.WebDriver;

import com.friday.qatask.PageDSL.PageHelper;



public class EnterRegistrationDatePage extends PageHelper {

	WebDriver driver;

	public EnterRegistrationDatePage(WebDriver driver) {
		super(driver, "EnterRegistrationDatePage");
		this.driver = driver;
	}
	
	public void enterRegistrationDate(String date) {
		TypeInField(element("input_registrationDate"), date);
	}
}
