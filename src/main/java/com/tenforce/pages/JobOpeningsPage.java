package com.tenforce.pages;

import org.openqa.selenium.WebDriver;

public class JobOpeningsPage extends BasePage {

    public JobOpeningsPage(WebDriver driver) {
        super(driver);
        log.info("Job openings page loaded");
        sleep(2000);
    }

    public boolean isJobPageDisplayed() {
        log.info("Verifying job page content");
        String pageText = getPageText().toLowerCase();
        boolean hasJob = pageText.contains("job");
        boolean hasCV = pageText.contains("cv");
        
        log.info("Page contains 'job': " + hasJob);
        log.info("Page contains 'cv': " + hasCV);
        
        return hasJob && hasCV;
    }
}
