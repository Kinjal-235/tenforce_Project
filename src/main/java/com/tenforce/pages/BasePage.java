package com.tenforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    protected void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
            log.info("Clicked element successfully");
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
            log.info("Clicked element using JavaScript");
        }
        sleep(1000);
    }

    protected void clickLinkByText(String text) {
        log.info("Looking for link containing text: " + text);
        sleep(2000);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            if (link.getText().toLowerCase().contains(text.toLowerCase())) {
                log.info("Found link: " + link.getText());
                scrollToElement(link);
                try {
                    link.click();
                    log.info("Clicked link successfully");
                } catch (Exception e) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].click();", link);
                    log.info("Clicked link using JavaScript");
                }
                sleep(1000);
                return;
            }
        }
        log.warn("Link not found with text: " + text);
    }

    protected void scrollDown() {
        log.info("Scrolling to bottom of page");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        sleep(1000);
    }

    protected void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        sleep(500);
    }

    protected String getPageText() {
        return driver.getPageSource();
    }

    protected void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
