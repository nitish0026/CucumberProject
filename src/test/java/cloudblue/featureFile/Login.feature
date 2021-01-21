Feature: Validating the homepage
  Scenario: Login with user credentials
    Given The homepage
    When User enters "admin" and "123qwe"
    Then User should be in the homepage
    @Regression
  Scenario: Login with user credentials1
    Given The homepage

  Scenario: Login with user credentials2 [DataSheet:TC001]
    Given The user enters url "https://automationtestlab.azurewebsites.net/order/login/auth"
    Then The word "app" should be displayed

  Scenario: Creating a New Customer
    Given The Sp/L2 User able to login
    Then It can create a customer