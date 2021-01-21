Feature: Creating and Validating the L2 Customer
  Scenario: Create Customer In Ux1 L2 Account
    Given Login as L2 User
    And Able to Create Customer
    Then Created Customer can be validated
  Scenario: Create Customer In Ux1 L2 NewAccount
    Given Login as L2 User
    And Able to Create Customer
    Then Created Customer can be validated