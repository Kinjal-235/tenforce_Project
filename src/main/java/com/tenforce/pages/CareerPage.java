package com.tenforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CareerPage extends BasePage {

    public CareerPage(WebDriver driver) {
        super(driver);
    }

    public LifeAtTenforcePage goToLifeAtTenforce() {
        // Scroll to load all content
        scrollToBottom();
        waitForPageLoad();
        
        // Try multiple strategies to find the Life at Tenforce section
        try {
            // Strategy 1: Look for any link containing "life"
            List<WebElement> links = driver.findElements(By.tagName("a"));
            for (WebElement link : links) {
                String text = link.getText().toLowerCase();
                String href = link.getAttribute("href");
                if (text.contains("life") || (href != null && href.toLowerCase().contains("life"))) {
                    scrollToElement(link);
                    clickElement(link);
                    return new LifeAtTenforcePage(driver);
                }
            }
        } catch (Exception e) {
            // Strategy 2: Try CSS selector
            WebElement link = driver.findElement(By.cssSelector("a[href*='life'], a[href*='Life']"));
            scrollToElement(link);
            clickElement(link);
        }
        return new LifeAtTenforcePage(driver);
    }
}
