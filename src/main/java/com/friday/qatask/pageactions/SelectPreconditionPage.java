package com.friday.qatask.pageactions;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.friday.qatask.PageDSL.PageHelper;

public class SelectPreconditionPage extends PageHelper {

	WebDriver driver;

	public SelectPreconditionPage(WebDriver driver) {
		super(driver, "SelectPreconditionPage");
		this.driver = driver;
	}

	public void AcceptCookies() {
		try {

			clickShadowElement("shadowRoot", "button_acceptCookies");

		} catch (NoSuchElementException ex) {
			Reporter.log("Cookies Pop didn't show up", true);
		}
	}
	
	public void theCarWillStillBeRegistered_Or_Reregistered() {
		click(element("radio_buyingCar"));
	}
	
	public void enterInceptionDate(String input) {
		TypeInField(element("input_inceptionDate"), input);
	}
	
	public boolean verifyTiTleText(String title) {
		if (title.equals(element("title_wizardTitle").getText())){
			return true;
			
		}
		else
			return false;
	}
	

}
