Feature: Validating the homepage1
  Scenario: Login with user credentials
    Given Open the Odin Login Page
    When Login in Odin with "Aldrino" and "Independent12#"
    Given Open Customer Page
    Then Search Customer By Id "1000007" And Login As Customer
    Then Validate UxOne Home Page Title "Dashboard"

#    Then Search Customer By Id "1000007" And Goto Details Page
#    Then Customer Details Page Validate Customer ID "1000007"
#    Then Search Customer By Id ""
#    Then Search Customer By Company ""
#    Then Customer Details Page Validate Customer Name "orchestratorRTQA2"
#    Then Search Customer By Company "" And Goto Details Page