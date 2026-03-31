package com.tenforce.pages;

import org.openqa.selenium.WebDriver;

public class ArticlePage extends BasePage {

    public ArticlePage(WebDriver driver) {
        super(driver);
        log.info("Article page loaded");
        sleep(2000);
    }

    public void scrollArticle() {
        log.info("Scrolling through article");
        scrollDown();
    }

    public JobOpeningsPage goToJobOpenings() {
        log.info("Navigating to Job openings page");
        clickLinkByText("job");
        return new JobOpeningsPage(driver);
    }
}
