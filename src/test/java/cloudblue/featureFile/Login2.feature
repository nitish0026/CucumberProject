Feature: Validating the homepage1
  Scenario: Login with user credentialsqqw
    Given The homepage
    When User enters "admin" and "123qwe"
    Then User should be in the homepage
    @Regression
  Scenario: Login with user credentials1qwqw
    Given The homepage