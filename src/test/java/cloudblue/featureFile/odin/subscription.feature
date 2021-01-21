Feature: Validating order and Subscription scenarios

  Scenario: Place Order From L2 Reseller
    Given User is on CBC Login Page
    When The user login with reseller credentials
    Then user search for Sub Category Name