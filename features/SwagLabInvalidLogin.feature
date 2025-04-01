Feature: Swag Labs Invalid Login Test
  Scenario: Verify the Invalid Login Feature
    Given I open chrome browser for invalid login
    When I navigate to SwagLabs login page And Enter Invalid Credentials
    Then I should see the error message
    And I close the browser for invalid login