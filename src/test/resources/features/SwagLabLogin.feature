Feature: Swag Labs Login Tests

  @SmokeTest
  Scenario: Verify the Login Feature with Valid Credentials
    Given I open the url
    When I Enter Credentials and click log in button int the Login Page
    Then I should see the Inventory Page

  @RegressionTest
  Scenario: Verify the Login Feature with Invalid Credentials
    Given I open the url of Swag Lab
    When I Enter Invalid Credentials and click log in button int the Login Page
    Then I should see the error message
