# Tenforce Automation Test

Selenium Java automation test using Page Object Model for Tenforce career journey.

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- Chrome browser

## How to Run the Tests

### Command Line Execution

```bash
mvn clean test
```

### Run Specific Test

```bash
mvn test -Dtest=CareerJourneyTest
```

### IDE Execution

Right-click on `CareerJourneyTest.java` and select "Run as TestNG Test"

## Framework Choice Justification

**Selenium WebDriver** - Industry standard for browser automation with excellent cross-browser support and active community.

**TestNG** - Chosen over JUnit for its powerful test configuration, parallel execution capabilities, and better reporting features.

**WebDriverManager** - Automatically manages browser driver binaries, eliminating manual ChromeDriver setup and version compatibility issues.

**Maven** - Standard build tool for Java projects, ensuring consistent dependency management and easy command-line execution.

## Architecture

The project follows the **Page Object Model (POM)** design pattern, which separates page structure from test logic. Each web page is represented by a dedicated Java class containing locators and page-specific methods. This approach improves maintainability by centralizing element definitions - when UI changes occur, updates are needed only in the corresponding page class rather than across multiple tests.

The `BasePage` class provides common functionality like clicking, scrolling, and wait strategies that all page objects inherit. Tests reside in separate classes and interact with pages through high-level methods, making test code readable and focused on business logic rather than technical implementation. This separation ensures robust, maintainable tests that are resilient to UI changes.

## Project Structure

```
├── src/
│   ├── main/java/com/tenforce/pages/
│   │   ├── BasePage.java           # Common page functionality
│   │   ├── HomePage.java           # Homepage interactions
│   │   ├── CareerPage.java         # Career page navigation
│   │   ├── LifeAtTenforcePage.java # Life section navigation
│   │   ├── ArticlePage.java        # Article interactions
│   │   └── JobOpeningsPage.java    # Job openings verification
│   └── test/java/com/tenforce/tests/
│       ├── BaseTest.java           # Test setup and teardown
│       └── CareerJourneyTest.java  # Main test scenario
├── pom.xml                         # Maven dependencies
└── testng.xml                      # TestNG configuration
```

## Test Scenario

1. Open https://www.tenforce.com/
2. Navigate to Career page
3. Go to Life at Tenforce section
4. Open "Life of two interns" article
5. Scroll through the article
6. Navigate to Job openings
7. Verify text "Feel free to send your CV to job" is present

## Key Features

- Page Object Model design pattern for maintainability
- Robust locators with multiple fallback strategies
- JavaScript click fallback for intercepted elements
- Cookie banner handling
- Meaningful assertions with detailed error messages
- Command line executable via Maven
- Clean separation of concerns between pages and tests
