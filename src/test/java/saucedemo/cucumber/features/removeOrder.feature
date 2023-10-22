Feature: Remove Order Saucedemo

  @RemoveOrder @Positive
  Scenario: Remove Order
    Given User see Saucedemo login page
    When User input standard username
    And User input password
    And User click login button
    Then User see product to order
    When User click add to cart on product
    Then User see the product count increase on cart icon
    And User see remove button on product
    When User click remove button on product ordered
    Then User see add to cart button on order removed
    When User click cart icon button
    Then User see the cart page
    And User not see removed product in the order cart

  @RemoveOrder @Negative
  Scenario: Remove Order on Detail Product
    Given User see Saucedemo login page
    When User input standard username
    And User input password
    And User click login button
    And User click product title
    Then User see product to order
    When User click add to cart on product
    Then User see the product count increase on cart icon
    And User see remove button on product
    When User click remove button on product ordered
    Then User see add to cart button on order removed
    When User click cart icon button
    Then User see the cart page
    And User not see removed product in the order cart

  @RemoveOrder @Negative
  Scenario: Remove Order on Cart Page
    Given User see Saucedemo login page
    When User input standard username
    And User input password
    And User click login button
    Then User see product to order
    When User click add to cart on product
    Then User see the product count increase on cart icon
    And User click cart icon button
    And User see remove button on product
    When User click remove button on product ordered
    Then User see the cart page
    And User not see removed product in the order cart