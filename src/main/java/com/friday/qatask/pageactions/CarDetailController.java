package com.friday.qatask.pageactions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

public class CarDetailController {
	
	private CarDetailFactory carDetailFactory;
	WebDriver driver;
	
	public CarDetailController(WebDriver driver) {
		this.driver = driver;
		carDetailFactory = new CarDetailFactory(driver);
		
	}
	
	
	public void selectCarDeatils(Map<String,Object> carDetails) {
		CarDetail carDetail;
		
		for (Map.Entry<String, Object> entry : carDetails.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
			carDetail = carDetailFactory.getCarDetailPageObject(entry.getKey().toString());
			carDetail.SelectCriteria(entry.getValue().toString());
	        
	    }
		
	}

}
