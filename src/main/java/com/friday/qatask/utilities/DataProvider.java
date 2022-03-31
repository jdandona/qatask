package com.friday.qatask.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import static com.friday.qatask.utilities.YamlReader.*;

public class DataProvider {
	
	
	@org.testng.annotations.DataProvider(name = "ThreeCarBrandsEachBrandThreeDifferentCar")
	public static Iterator<Object[]> createData() {
		setYamlFilePath();
        List<Map<String,Object>> lom = new ArrayList<Map<String,Object>>();
        for (int i= 1; i<=3; i++) {
        	for (int j=1; j<=3; j++) {
        		System.out.println("QuoteSelection.CarBrand"+i+"."+"Model"+j);
        		lom.add(getYamlValues("QuoteSelection.CarBrand"+i+"."+"Model"+j));
        	}
        }
       
        Collection<Object[]> dp = new ArrayList<Object[]>();
        for(Map<String,Object> map:lom){
            dp.add(new Object[]{map});
        }
        return dp.iterator();
    }


}
