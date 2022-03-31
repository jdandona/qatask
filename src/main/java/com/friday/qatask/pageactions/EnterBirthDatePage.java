package com.friday.qatask.pageactions;

import org.openqa.selenium.WebDriver;

import com.friday.qatask.PageDSL.PageHelper;



public class EnterBirthDatePage extends PageHelper {

	WebDriver driver;

	public EnterBirthDatePage(WebDriver driver) {
		super(driver, "EnterBirthDatePage");
		this.driver = driver;
	}
	
	
	
	public boolean IsUserPresentOnEnterDateOfBirthPage() {
		String url = getCurrentPageURL();
		if (url.contains("enterBirthDate")) {
			return true;
		}
		else 
			return false;
	}

}
