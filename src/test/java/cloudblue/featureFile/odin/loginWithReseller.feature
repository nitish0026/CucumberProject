Feature: Validating marketplace scenarios

  Scenario: Create Staff User with L2 reseller
    Given User is on CBC Login Page
    When The user login with reseller credentials
    And Navigates to billing and clicks on Users
    Then Add user button should not be available