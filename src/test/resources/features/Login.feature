@login
Feature: WebDriver University - Login

  Scenario: Validate successful login with valid data
    Given I access the webdriver login page
    When I enter a valid username
    And I enter a valid password
    And I click the login button
    Then I should be presented with an alert informing a successful login

  Scenario: Validate failed login attempt with invalid data
    Given I access the webdriver login page
    When I enter a invalid username
    And I enter a invalid password
    And I click the login button
    Then I should be presented with an alert informing I have failed to login

  Scenario: Validate failed login attempt with valid username and invalid password
    Given I access the webdriver login page
    When I enter a valid username
    And I enter a invalid password
    And I click the login button
    Then I should be presented with an alert informing I have failed to login