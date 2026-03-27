package com.tenforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends BasePage {

    @FindBy(partialLinkText = "Job")
    private WebElement jobOpeningsLink;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public void scrollThroughArticle() {
        scrollToBottom();
    }

    public JobOpeningsPage goToJobOpenings() {
        try {
            scrollToElement(jobOpeningsLink);
            clickElement(jobOpeningsLink);
        } catch (Exception e) {
            // Try finding by href containing job or opening
            scrollToBottom();
            WebElement link = driver.findElement(By.cssSelector("a[href*='job'], a[href*='opening'], a[href*='career']"));
            clickElement(link);
        }
        return new JobOpeningsPage(driver);
    }
}
