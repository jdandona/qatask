package com.friday.qatask.TestInitiator;

import org.openqa.selenium.WebDriver;

import com.friday.qatask.pageactions.ButtonBarSection;
import com.friday.qatask.pageactions.CarDetailController;
import com.friday.qatask.pageactions.EnterBirthDatePage;
import com.friday.qatask.pageactions.EnterRegistrationDatePage;
import com.friday.qatask.pageactions.SelectPreconditionPage;
import com.friday.qatask.pageactions.SelectRegisteredOwnerPage;

public class PageObjectProvider {

	private WebDriver driver;

	public PageObjectProvider(WebDriver driver) {
		this.driver = driver;

	}

	public SelectPreconditionPage getSelectPreconditionPage() {
		return new SelectPreconditionPage(driver);
	}
	
	public ButtonBarSection getButtonBarSection() {
		return new ButtonBarSection(driver);
	}
	
	public SelectRegisteredOwnerPage getRegisteredOwnerPage() {
		return new SelectRegisteredOwnerPage(driver);
	}
	
	public EnterRegistrationDatePage getRegistrationDatePage() {
		return new EnterRegistrationDatePage(driver);
	}
	
	public EnterBirthDatePage getBirthDatePage() {
		return new EnterBirthDatePage(driver);
	}
	
	public CarDetailController getCarDetailController() {
		return new CarDetailController(driver);
	}
	

}
