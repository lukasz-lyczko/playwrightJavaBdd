Feature: Search functionality

  Background:
    Given I am on the LUMA homepage

  Scenario: Add single product directly from Hot Sellers section
    When I add "Gray" "Hero Hoodie" in "M" size to cart
    Then I should see "You added Hero Hoodie to your shopping cart." notification
    And I should see shopping cart counter to be "1"
    And I should see "Hero Hoodie" in my shopping cart
    And I should see "Proceed to checkout" button

  Scenario: Navigate from Hot Sellers page to product page
    When I click on product image
    Then Product page should be open


    Scenario: Add to wish list without login
      When I click on "Add to Wish List" icon
      Then I should see "You must login or register to add items to your wishlist." notification

  Scenario: Add to wish list logged in
    Given I am logged in
    When I click on "Add to Wish List" icon
    Then Product should be added to Wish List