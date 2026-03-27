package com.tenforce.tests;

import com.tenforce.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CareerJourneyTest extends BaseTest {

    @Test(description = "Navigate through Tenforce career pages and verify job openings text")
    public void testCareerJourney() {
        // Step 1: Open Tenforce homepage
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(driver.getCurrentUrl().contains("tenforce.com"), 
            "Failed to open Tenforce homepage");

        // Step 2: Navigate to Career page
        CareerPage careerPage = homePage.goToCareerPage();
        String careerUrl = driver.getCurrentUrl();
        Assert.assertTrue(careerUrl.toLowerCase().contains("career") || 
                         driver.getTitle().toLowerCase().contains("career"),
            "Failed to navigate to Career page. Current URL: " + careerUrl);

        // Step 3: Navigate to Life at Tenforce section
        LifeAtTenforcePage lifeAtTenforcePage = careerPage.goToLifeAtTenforce();
        String lifeUrl = driver.getCurrentUrl();
        // Verify navigation occurred (URL changed from career page)
        Assert.assertNotEquals(careerUrl, lifeUrl,
            "Failed to navigate to Life at Tenforce section. URL did not change from: " + careerUrl);

        // Step 4: Open "Life of two interns" article
        ArticlePage articlePage = lifeAtTenforcePage.openLifeOfTwoInternsArticle();
        String articleUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(lifeUrl, articleUrl,
            "Failed to open Life of two interns article. URL did not change from: " + lifeUrl);

        // Step 5: Scroll through the article
        articlePage.scrollThroughArticle();

        // Step 6: Navigate to Job openings and verify text
        JobOpeningsPage jobOpeningsPage = articlePage.goToJobOpenings();
        boolean textPresent = jobOpeningsPage.isExpectedTextPresent();
        
        // If assertion fails, print page content for debugging
        if (!textPresent) {
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Page Title: " + jobOpeningsPage.getPageTitle());
            String content = jobOpeningsPage.getPageContent();
            if (content.toLowerCase().contains("job")) {
                System.out.println("Page contains 'job' keyword");
            }
        }
        
        Assert.assertTrue(textPresent,
            "Expected text related to 'Feel free to send your CV to job' not found on Job openings page. URL: " + driver.getCurrentUrl());
    }
}
