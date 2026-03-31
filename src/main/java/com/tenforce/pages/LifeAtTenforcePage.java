package com.tenforce.pages;

import org.openqa.selenium.WebDriver;

public class LifeAtTenforcePage extends BasePage {

    public LifeAtTenforcePage(WebDriver driver) {
        super(driver);
        log.info("Life at Tenforce page loaded");
        sleep(2000);
    }

    public ArticlePage openLifeOfTwoInternsArticle() {
        log.info("Opening interns article");
        clickLinkByText("intern");
        return new ArticlePage(driver);
    }
}
