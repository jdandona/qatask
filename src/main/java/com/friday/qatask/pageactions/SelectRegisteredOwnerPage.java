package com.friday.qatask.pageactions;

import org.openqa.selenium.WebDriver;

import com.friday.qatask.PageDSL.PageHelper;



public class SelectRegisteredOwnerPage extends PageHelper {

	WebDriver driver;

	public SelectRegisteredOwnerPage(WebDriver driver) {
		super(driver, "SelectRegisteredOwnerPage");
		this.driver = driver;
	}
	
	
	
	public void carRegistered_Yes() {
		click(element("radio_Yes"));
	}
	
	public void careRegistered_No() {
		click(element("radio_No"));
	}
	
	public void theCarIsUsed() {
		click(element("label_used"));
	}
	
	public void theCarIsNew() {
		click(element("label_new"));
	}

}
