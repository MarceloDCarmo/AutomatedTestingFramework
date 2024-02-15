@contact-us
Feature: WebDriver University - Contact Us Page

  @UniqueData
  Scenario: Validate Successful Submission - Unique Data
    Given I access the webdriver university contact us page
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on the submit button
    Then I should be presented with a successful contact us submission message

  @SpecificData
  Scenario: Validate Successful Submission - Specific Data
    Given I access the webdriver university contact us page
    When I enter a specific first John
    And I enter a specific last Tester
    And I enter a specific email address "johntester@mail.com"
    And I enter a specific comment "Just an automated test!"
    And I click on the submit button
    Then I should be presented with a successful contact us submission message