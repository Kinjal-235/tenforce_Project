package com.tenforce.pages;

import org.openqa.selenium.WebDriver;

public class JobOpeningsPage extends BasePage {

    public JobOpeningsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isExpectedTextPresent() {
        waitForPageLoad();
        String pageSource = getPageText().toLowerCase();
        
        // Check for variations of the expected text
        return pageSource.contains("feel free to send") || 
               pageSource.contains("send your cv") ||
               pageSource.contains("cv to job") ||
               (pageSource.contains("feel free") && pageSource.contains("cv"));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
    
    public String getPageContent() {
        return driver.getPageSource();
    }
}
