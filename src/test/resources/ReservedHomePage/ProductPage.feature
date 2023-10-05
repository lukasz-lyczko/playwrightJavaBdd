Feature: Product page

#  Background:
#    Given I'm on product page "/kobieta/akcesoria/ponczo"

    Scenario: Adding poncho to cart
      Given I'm on product page "/kobieta/akcesoria/ponczo"
      When I click on "Ponczo z frędzlami"

  Scenario: Adding shoes to cart
    Given I'm on product page "/kobieta/akcesoria/buty"
    When I click on "Długie zamszowe kozaki"
    And I choose size "41"
    And I add to cart
    Then I should see confirmation dialog with following heading "Produkt został dodany do koszyka"
    And I should see that "Długie zamszowe kozaki" was added to cart
    And I should see size of product "41" was added to cart
    
    Scenario: Product search 
      Given I'm on product page "/"
      When I search for "poncho z golfem"
      Then I should see product containing phrase "poncho z golfem"

  Scenario: User account options
    Given I'm on product page "/"
    When I hover on the Konto link
    Then I should see following buttons
    |Zaloguj się|
    |Zarejestruj się|

  Scenario: Registration validation
    Given I'm on product page "/customer/account/login/#register"
    When I enter email address "marta_gmail.com"
    Then I should see field validation error "Wprowadź poprawne znaki"



