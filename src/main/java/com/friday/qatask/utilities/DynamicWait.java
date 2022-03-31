package com.friday.qatask.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicWait {
	
	WebDriver driver;
    WebDriverWait wait;
    
    int timeout;
    
    public DynamicWait(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60,1));
        
    }

    /**
     * Returns webElement found by the locator if element is visible
     *
     * @param locator
     * @return
     */
    public WebElement getWhenVisible(By locator) {
        WebElement element;
        element = (WebElement) wait.until(ExpectedConditions
                .visibilityOfElementLocated(locator));
        return element;
    }
    
    public WebElement getWhenClickable(WebElement element) {
        
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public boolean waitForPageTitleToBeExact(String expectedPagetitle) {
        return wait.until(ExpectedConditions.titleIs(expectedPagetitle)) != null;
    }
    
    public boolean waitForPageTitleToContain(String expectedPagetitle) {
        return wait.until(ExpectedConditions.titleContains(expectedPagetitle)) != null;
    }
    
    public WebElement waitForElementToBeVisible(WebElement element) {
    	WebElement webWait;
    	try
    	{
          webWait =  wait.until(ExpectedConditions.visibilityOf(element));
    	}
    	catch(StaleElementReferenceException e)
        
    	{
    		webWait =  wait.until(ExpectedConditions.visibilityOf(element));
    	}
    	return webWait;
    }
    
  
    
    
    public List<WebElement> waitForElementsToBeVisible(List<WebElement> elements) {
        return (List<WebElement>) wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    
    public boolean waitForElementToBeInVisible(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator)) != null;
        
    }
    
    public WebElement waitForElementToBeClickable(WebElement element) {
        return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    
    
    public void clickWhenReady(By locator) {
        WebElement element = (WebElement) wait.until(ExpectedConditions
                .elementToBeClickable(locator));
        element.click();
    }

    
    public int getTimeout() {
    	return timeout;
    }

	public void waitForTextToBe(By locator, String value){
	wait.until(ExpectedConditions.textToBe(locator, value));
}
	
	public void visibilityOfElementLocated(By element){
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public void waitForStalenessOfElement(WebElement element){
		wait.until(ExpectedConditions.stalenessOf(element));
	}


}
