package com.tenforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LifeAtTenforcePage extends BasePage {

    public LifeAtTenforcePage(WebDriver driver) {
        super(driver);
    }

    public ArticlePage openLifeOfTwoInternsArticle() {
        scrollToBottom();
        waitForPageLoad();
        
        // Try multiple strategies to find the interns article
        try {
            // Strategy 1: Search through all links for "intern"
            List<WebElement> links = driver.findElements(By.tagName("a"));
            for (WebElement link : links) {
                String text = link.getText().toLowerCase();
                String href = link.getAttribute("href");
                if (text.contains("intern") || (href != null && href.toLowerCase().contains("intern"))) {
                    scrollToElement(link);
                    clickElement(link);
                    return new ArticlePage(driver);
                }
            }
        } catch (Exception e) {
            // Strategy 2: Try CSS selector
            WebElement link = driver.findElement(By.cssSelector("a[href*='intern']"));
            scrollToElement(link);
            clickElement(link);
        }
        return new ArticlePage(driver);
    }
}
