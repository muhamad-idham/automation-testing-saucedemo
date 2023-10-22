Feature: Checkout Order Saucedemo

  @CheckoutOrder @Positive
  Scenario: Checkout Order
    Given User see Saucedemo login page
    When User input standard username
    And User input password
    And User click login button
    Then User see product to order
    When User click add to cart on product
    Then User see the product count increase on cart icon
    When User click cart icon button
    Then User see the cart page
    And User see product in the order cart
    When User click checkout button
    Then User see checkout information page
    And User input first name
    And User input last name
    And User input postal code
    And User click continue button
    Then User see checkout overview page and total price
    And User click finish button
    And User see checkout finish message

  @CheckoutOrder @Negative
  Scenario: Checkout Order with Empty Product
    Given User see Saucedemo login page
    When User input standard username
    And User input password
    And User click login button
    Then User see product to order
    When User click cart icon button
    Then User see the cart page
    When User click checkout button
    Then User see checkout information page
    And User input first name
    And User input last name
    And User input postal code
    And User click continue button
    Then User see checkout overview page and total price
    And User click finish button
    And User see checkout finish message

  @CheckoutOrder @Negative
  Scenario: Checkout Order with Empty Input First Name
    Given User see Saucedemo login page
    When User input standard username
    And User input password
    And User click login button
    Then User see product to order
    When User click add to cart on product
    Then User see the product count increase on cart icon
    When User click cart icon button
    Then User see the cart page
    And User see product in the order cart
    When User click checkout button
    Then User see checkout information page
    And User input last name
    And User input postal code
    And User click continue button
    Then User see error message input first name

  @CheckoutOrder @Negative
  Scenario: Checkout Order with Empty Input Last Name
    Given User see Saucedemo login page
    When User input standard username
    And User input password
    And User click login button
    Then User see product to order
    When User click add to cart on product
    Then User see the product count increase on cart icon
    When User click cart icon button
    Then User see the cart page
    And User see product in the order cart
    When User click checkout button
    Then User see checkout information page
    And User input first name
    And User input postal code
    And User click continue button
    Then User see error message input last name

  @CheckoutOrder @Negative
  Scenario: Checkout Order with Empty Input Postal Code
    Given User see Saucedemo login page
    When User input standard username
    And User input password
    And User click login button
    Then User see product to order
    When User click add to cart on product
    Then User see the product count increase on cart icon
    When User click cart icon button
    Then User see the cart page
    And User see product in the order cart
    When User click checkout button
    Then User see checkout information page
    And User input first name
    And User input last name
    And User click continue button
    Then User see error message input postal code