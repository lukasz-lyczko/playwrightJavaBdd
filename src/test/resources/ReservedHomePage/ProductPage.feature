Feature: Product page

  Scenario: Adding product to cart
    Given I am on product page "/kobieta/akcesoria/buty"
    When I click on "Długie zamszowe kozaki"
    And I choose size "41"
    And I add to cart
    Then I should see confirmation dialog with following heading "Produkt został dodany do koszyka"
    And I should see that "Długie zamszowe kozaki" was added to cart
    And I should see size of product "41" was added to cart

  Scenario: Product search
    Given I am on product page "/"
    When I search for "poncho z golfem"
    Then I should see product containing phrase "poncho z golfem"
