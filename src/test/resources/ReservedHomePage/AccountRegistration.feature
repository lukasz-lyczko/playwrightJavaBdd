Feature: Account registration

  Scenario Outline: Email field validation - invalid email format
    Given I'm on account registration page
    When I enter email address <email>
    Then I should see field validation error <validationError>
    Examples:
      | email               | validationError            |
      | "invalid.email.com" | "Wprowadź poprawne znaki" |
      | "invalid@email.c" | "Wprowadź poprawne znaki" |

  Scenario: Email field validation - empty
    Given I'm on account registration page
    When I enter email address <email>
    Then I should see field validation error <validationError>
      | "  " | "To pole jest wymagane" |
