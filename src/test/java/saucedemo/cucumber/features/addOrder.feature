Feature: Add Order Saucedemo

  @AddOrder @Positive
  Scenario: Add Order
    Given User see Saucedemo login page
    When User input standard username
    And User input password
    And User click login button
    Then User see product to order
    When User click add to cart on product
    Then User see the product count increase on cart icon
    And User see remove button on product
    When User click cart icon button
    Then User see the cart page
    And User see product in the order cart

  @AddOrder @Negative
  Scenario: Add Order on Detail Product
    Given User see Saucedemo login page
    When User input standard username
    And User input password
    And User click login button
    And User click product title
    Then User see product to order
    When User click add to cart on product
    Then User see the product count increase on cart icon
    And User see remove button on product
    When User click cart icon button
    Then User see the cart page
    And User see product in the order cart

  @AddOrder @Negative
  Scenario: Add Order More Than Three Products
    Given User see Saucedemo login page
    When User input standard username
    And User input password
    And User click login button
    Then User see more than three products to order
    When User click add to cart on more than three products
    Then User see the product count increase more than three products on cart icon
    And User see remove button more than three products ordered
    When User click cart icon button
    Then User see the cart page
    And User see more than three products in the order cart

  @AddOrder @Negative
  Scenario: Add Order More Than Three Products Using Problem User
    Given User see Saucedemo login page
    When User input problem username
    And User input password
    And User click login button
    Then User see more than three products to order
    When User click add to cart on more than three products
    Then User see the product count increase more than three products on cart icon
    And User see remove button more than three products ordered
    When User click cart icon button
    Then User see the cart page
    And User see more than three products in the order cart