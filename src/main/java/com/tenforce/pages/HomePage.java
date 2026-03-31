package com.tenforce.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        log.info("Opening Tenforce homepage");
        driver.get("https://www.tenforce.com/");
        sleep(3000);
        log.info("Homepage loaded successfully");
    }

    public CareerPage goToCareerPage() {
        log.info("Navigating to Career page");
        clickLinkByText("career");
        return new CareerPage(driver);
    }
}
