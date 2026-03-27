package com.tenforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(linkText = "Career")
    private WebElement careerLink;

    @FindBy(partialLinkText = "Career")
    private WebElement careerLinkPartial;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.tenforce.com/");
        handleCookieBanner();
    }

    public CareerPage goToCareerPage() {
        try {
            scrollToElement(careerLink);
            clickElement(careerLink);
        } catch (Exception e) {
            scrollToElement(careerLinkPartial);
            clickElement(careerLinkPartial);
        }
        return new CareerPage(driver);
    }
}
