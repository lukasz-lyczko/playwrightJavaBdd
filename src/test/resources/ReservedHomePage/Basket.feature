Feature: Shopping basket

  Scenario: Checking empty shopping basket
    Given I am on the landing page
    When I check shopping basket
    Then I should see "Twój koszyk jest pusty" headline
    And I should see "Zaloguj się" button
    And I should see "Lub kontynuuj zakupy" link
