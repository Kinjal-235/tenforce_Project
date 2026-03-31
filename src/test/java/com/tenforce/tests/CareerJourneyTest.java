package com.tenforce.tests;

import com.tenforce.pages.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CareerJourneyTest extends BaseTest {
    
    private Logger log = LoggerFactory.getLogger(CareerJourneyTest.class);

    @Test
    public void testCareerJourney() {
        log.info("Starting Career Journey Test");
        
        // Step 1: Open homepage
        log.info("Step 1: Opening homepage");
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(driver.getCurrentUrl().contains("tenforce.com"));
        log.info("Homepage opened successfully. URL: " + driver.getCurrentUrl());

        // Step 2: Go to Career page
        log.info("Step 2: Navigating to Career page");
        CareerPage careerPage = homePage.goToCareerPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("career"));
        log.info("Career page opened. URL: " + driver.getCurrentUrl());

        // Step 3: Go to Life at Tenforce
        log.info("Step 3: Navigating to Life at Tenforce section");
        LifeAtTenforcePage lifePage = careerPage.goToLifeAtTenforce();
        Assert.assertNotNull(lifePage);
        log.info("Life at Tenforce page opened");

        // Step 4: Open interns article
        log.info("Step 4: Opening interns article");
        ArticlePage articlePage = lifePage.openLifeOfTwoInternsArticle();
        Assert.assertNotNull(articlePage);
        log.info("Interns article opened");

        // Step 5: Scroll through article
        log.info("Step 5: Scrolling through article");
        articlePage.scrollArticle();
        log.info("Article scrolled successfully");

        // Step 6: Go to Job openings
        log.info("Step 6: Navigating to Job openings page");
        JobOpeningsPage jobPage = articlePage.goToJobOpenings();
        Assert.assertTrue(jobPage.isJobPageDisplayed(), "Job page content not found");
        log.info("Job openings page verified successfully");
        
        log.info("Career Journey Test completed successfully");
    }
}
