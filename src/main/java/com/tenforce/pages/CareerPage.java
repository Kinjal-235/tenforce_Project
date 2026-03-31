package com.tenforce.pages;

import org.openqa.selenium.WebDriver;

public class CareerPage extends BasePage {

    public CareerPage(WebDriver driver) {
        super(driver);
        log.info("Career page loaded");
        sleep(2000);
    }

    public LifeAtTenforcePage goToLifeAtTenforce() {
        log.info("Navigating to Life at Tenforce section");
        clickLinkByText("life");
        return new LifeAtTenforcePage(driver);
    }
}
