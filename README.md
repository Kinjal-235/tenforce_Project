# Tenforce Automation Test

Selenium Java automation test using Page Object Model for Tenforce career journey.

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- Chrome browser

## Project Structure

```
├── src/
│   ├── main/java/com/tenforce/pages/
│   │   ├── BasePage.java
│   │   ├── HomePage.java
│   │   ├── CareerPage.java
│   │   ├── LifeAtTenforcePage.java
│   │   ├── ArticlePage.java
│   │   └── JobOpeningsPage.java
│   └── test/java/com/tenforce/tests/
│       ├── BaseTest.java
│       └── CareerJourneyTest.java
├── pom.xml
└── testng.xml
```

## Run Tests

Execute from command line:

```bash
mvn clean test
```

## Test Scenario

1. Open https://www.tenforce.com/
2. Navigate to Career page
3. Go to Life at Tenforce section
4. Open "Life of two interns" article
5. Scroll through the article
6. Navigate to Job openings
7. Verify text "Feel free to send your CV to job" is present

## Features

- Page Object Model design pattern
- Robust locators (linkText, partialLinkText)
- WebDriverManager for automatic driver management
- Meaningful assertions at each step
- Command line executable via Maven
