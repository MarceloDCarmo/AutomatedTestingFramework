@login @regression
Feature: WebDriver University - Login

  Background:
    Given I access the webdriver login page

  Scenario Outline: Validate successful and unsuccessful login
    When I enter the username <username>
    And I enter the password <password>
    And I click the login button
    Then I should be presented with an alert with the message "<message>"

    @loginWithValidData
    Examples:
      | username      | password      | message              |
      | webdriver     | webdriver123  | validation succeeded |

    @loginWithInvalidPassword
    Examples:
      | username      | password      | message              |
      | webdriver     | wrongPassword | validation failed    |

    @loginWithInvalidData
    Examples:
      | username      | password      | message              |
      | wrongUsername | wrongPassword | validation failed    |