# Automated Testing Framework

## Overview

This repository contains an Automated Testing Framework designed for web applications using Java, Selenium, and Cucumber. The framework provides a structured and scalable approach to writing and executing automated tests, making it easier to maintain and enhance test suites. There are some scenarios based on [Webdriver University](https://www.webdriveruniversity.com/) demo site.

## Technologies Used

- **Java:** The programming language used for test script development.
- **Selenium:** A powerful tool for automating web browsers, used for interacting with web elements.
- **Cucumber:** A behavior-driven development (BDD) tool that enables the creation of executable specifications using plain text.

## Features

- **Modular Structure:** The framework follows a modular structure, allowing easy organization and maintenance of test scripts.
- **Page Object Model (POM):** Utilizes the POM design pattern for creating reusable and maintainable page objects.
- **Reporting:** Generates detailed test execution reports for better analysis and troubleshooting.
- **Cross-Browser Testing:** Enables testing across multiple browsers for increased compatibility (chrome and firefox).

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java Development Kit (JDK)
- Maven
- WebDriver for the desired browser(s)

**Obs.:** Drivers for chrome and firefox are included in this repository, but you need to use a driver based on your browser version.


### Setup

1. Clone the repository:

   ```
   git clone https://github.com/your-username/automated-testing-framework.git
   ```
2. Navigate to the project directory:
    ```
    cd automated-testing-framework
    ```
3. Install dependencies:
    ```
    mvn clean install
    ```
4. Update configuration:

    In my environment I had to specify the path to Chrome bin because I used a testing version. You can update configuration about webrivers on src/main/java/driver/DriverFactory.java.

### Usage

Write your feature files using Gherkin syntax in the src/test/resources/features directory.

Implement step definitions in the src/test/java/stepDefinitions package.

Execute tests using the following Maven command:
    
   ```
   mvn test
   ```    
#### Commands
To define the scenarios to run, use:
   ```
   -Dcucumber.filter.tags="@scenarioTag"
   ```
To define how many parallel tests to run, use:
   ```
   -Ddataproviderthreadcount=threadCount
   ```
To define which browser to run the tests, use (options: "chrome" or "firefox"):
   ```
   -DbrowserType="browserType"
   ```
#### Tags available
You can find all scenarios in **src/test/resources/features**
- @contact-us
- @regression
- @UniqueData
- @SpecificData
- @login
- @loginWithValidData
- @loginWithInvalidPassword
- @loginWithInvalidData

### Reporting
After test execution, detailed reports can be found in the target/reports directory. Open the cucumber.html file in a web browser to view the results (json report available too).

### Jenkins 
The framework is prepared to run with Jenkins jobs using TestGN and Maven Surfire Plugin.
