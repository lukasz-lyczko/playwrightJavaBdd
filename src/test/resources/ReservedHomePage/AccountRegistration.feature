Feature: Account registration

  Scenario Outline: Email field validation - invalid email format
    Given I'm on account registration page
    When I enter email address "<email>"
    Then I should see email field validation error "<validationError>"
    Then I should see 1 field validation error
    Examples:
      | email             | validationError         |
      | invalid.email.com | Wprowadź poprawne znaki |
      | invalid@email.c   | Wprowadź poprawne znaki |


  Scenario: Email field validation - blank
    Given I'm on account registration page
    When I enter email address "   "
    When I click on "Załóż konto" button
    Then I should see email field validation error "To pole jest wymagane"

  Scenario: Email field validation - submitting empty form
    Given I'm on account registration page
    When I click on "Załóż konto" button
    Then I should see email field validation error "To pole jest wymagane"
    Then I should see 4 field validation errors
    When I click on checkbox with label "Tak, chcę zapisać się do newslettera"
    Then I should see the checkbox is checked
    When I click on checkbox with label "Nie wylogowuj mnie"
    Then I should see the checkbox is checked

