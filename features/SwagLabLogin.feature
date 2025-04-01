Feature:Swag Labs Login Test
  Scenario: Verify the Login Feature
    Given I open chrome browser
    When I navigate to SwagLabs login page And Enter Credentials
    Then I should see the Home page
    And I close the browser