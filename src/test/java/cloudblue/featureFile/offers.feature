Feature: Validating the homepage
  Scenario: Test Offer Page Data Table
    Given Open url "https://datatables.net/"
#    Then Find Offer "Gavin Joyce"
    Then Find Offer and goto details page  "Gavin Joyce"