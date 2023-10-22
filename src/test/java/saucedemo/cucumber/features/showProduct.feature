Feature: Show Product Saucedemo

  @ShowProduct @Positive
  Scenario: Show Product
    Given User see Saucedemo login page
    When User input standard username
    And User input password
    And User click login button
    And User click product title
    Then User see the product
    When User click back to products button
    Then User see the product page

  @ShowProduct @Positive
  Scenario: Show Product Through Image
    Given User see Saucedemo login page
    When User input standard username
    And User input password
    And User click login button
    And User click product image
    Then User see the product
    When User click back to products button
    Then User see the product page

  @ShowProduct @Negative
  Scenario: Show Product Through Wrong Title
    Given User see Saucedemo login page
    When User input problem username
    And User input password
    And User click login button
    And User click wrong product title
    Then User see the different product
    When User click back to products button
    Then User see the product page

  @ShowProduct @Negative
  Scenario: Show Product Through Wrong Image
    Given User see Saucedemo login page
    When User input problem username
    And User input password
    And User click login button
    And User click wrong product image
    Then User see the different product
    When User click back to products button
    Then User see the product page