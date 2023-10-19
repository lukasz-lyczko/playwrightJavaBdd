Feature: Account registration

  Background:
    Given I am on account registration page

  Scenario Outline: Email field validation - invalid email format
    When I enter email address "<email>"
    Then I should see email field validation error "<validationError>"
    Then I should see 1 field validation error
    Examples:
      | email             | validationError         |
      | invalid.email.com | Wprowadź poprawne znaki |
      | invalid@email.c   | Wprowadź poprawne znaki |

  Scenario: Email field validation - blank
    When I enter email address "   "
    When I click on "Załóż konto" button
    Then I should see email field validation error "To pole jest wymagane"

  Scenario: Email field validation - submitting empty form
    When I click on "Załóż konto" button
    Then I should see email field validation error "To pole jest wymagane"
    Then I should see 4 field validation errors
    When I click on checkbox with label "Tak, chcę zapisać się do newslettera"
    Then I should see the checkbox is checked
    When I click on checkbox with label "Nie wylogowuj mnie"
    Then I should see the checkbox is checked
