Feature: Landing page
  Background:
    Given I am on the landing page

  Scenario: Select subcategory form Nowości
    When I select "Nowości" and "KOBIETA" from top menu
    Then I should see "Nowości dla kobiet" heading
    And the url should contain "/nowosci/kobieta"

  Scenario: User account options
    When I hover on the Konto link
    Then I should see following buttons
      | Zaloguj się     |
      | Zarejestruj się |
